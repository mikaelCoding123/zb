package com.web.demo.action;

import cn.hutool.core.lang.Snowflake;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.bean.Order;
import com.result.Result;
import com.result.ResultUtil;
import com.web.demo.bo.Goods;
import com.web.demo.dao.GoodsMapper;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.scripting.support.ResourceScriptSource;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author
 * @version 1.0
 * @date 2025/7/24
 */


@RestController
@RequestMapping("/kill")
@Slf4j
public class SecondKillAction {
  private final static String LOCK_GOODS = "LOCK_GOODS_";
  private final static String LUA_DEC_1 = "redis.call('DECR', KEYS[1]) ";
  private final String teset = "local a = tonumber(ARGV[1])\n" +
      "local b = tonumber(ARGV[2])\n" +
      "return a + b";

  @Resource
  private RedissonClient redissonClient;
  @Resource
  private GoodsMapper goodsMapper;

  @Resource
  private RedisTemplate redisTemplate;


  @Resource
  private StringRedisTemplate stringRedisTemplate;

  /**
   * @param id      商品id
   * @param request
   * @return
   */
  @RequestMapping("/v1/good/{id}")
  public Result killv1(@PathVariable("id") String id, HttpServletRequest request) {
    String sessionId = request.getSession().getId();
    Long stock = 0L;
    RLock lock = redissonClient.getLock(LOCK_GOODS + id);
    try {
      boolean b = lock.tryLock(10L, TimeUnit.MILLISECONDS);

      if (!b) {
        return ResultUtil.success("你没有抢到");
      }
      //在redis里库存减1  stock库存
      stock = redisTemplate.opsForValue().decrement("goods_" + id);
      System.out.println(stock);
      if (stock <= 0) {
        //
        UpdateWrapper<Goods> goodsUpdateWrapper = new UpdateWrapper<>();
        goodsUpdateWrapper.setSql(true, "number=0").eq(true, "id", id);
        goodsMapper.update(null, goodsUpdateWrapper);
        return ResultUtil.success("秒杀产品库存为0");
      } else {
        //创建订单 通过mq进行下订单
        Snowflake snowflake = new Snowflake();
        long orderId = snowflake.nextId();
        Order order = new Order();
        order.setId(orderId + "");
      }

    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    } finally {
      //当reids连接中断的时候，可以用日志来记录操作（redis不能长时间连接失败）
      log.info("记录操作:用户{}-{}-结果{}-当前库存{}", sessionId, "抢到商品" + id, "已下单" + id, stock);
      lock.unlock();
    }
    return ResultUtil.success(null);

  }

  @RequestMapping("/push/goods/{id}")
  public com.result.Result pushGoods(@PathVariable("id") String id) {
    //进行秒杀
    Goods goods = goodsMapper.selectById(id);
    Integer number = goods.getNumber();
    redisTemplate.opsForValue().set("2", "hua");

    redisTemplate.opsForValue().set("goods_" + id, number);

    return ResultUtil.success();
  }

  /**
   * 通过LUA文件来执行redis
   * @return
   */
  @RequestMapping("/lua")
  public com.result.Result goLUA() {
    DefaultRedisScript<String> redisScript = new DefaultRedisScript<>();
    redisScript.setScriptSource(new ResourceScriptSource(new ClassPathResource("lua/KILL_GOODS.lua")));
    redisScript.setResultType(String.class);
    List<String> keyList = Arrays.asList("goods", "GOODS_STOCK_KEY");//lua文件种的 KEYS[1],KEYS[2]
    String result = stringRedisTemplate.execute(redisScript, keyList, "userId");
    return ResultUtil.success(result);
  }

  @RequestMapping("/push/{id}")
  public com.result.Result pushGood1s(@PathVariable("id") String id) {

    redisTemplate.opsForValue().set("2", "hua");
    redisTemplate.opsForValue().get("2");

    redisTemplate.opsForValue().set("goods_" + id, 11);


    return ResultUtil.success();
  }


}
