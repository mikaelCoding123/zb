package com.config.batis;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.jsontype.impl.LaissezFaireSubTypeValidator;
import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class MybatisPlusConfig {

  /**
   * 添加分页插件
   */
  @Bean
  public MybatisPlusInterceptor mybatisPlusInterceptor() {
    MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
    interceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.MYSQL)); // 如果配置多个插件, 切记分页最后添加
    // 如果有多数据源可以不配具体类型, 否则都建议配上具体的 DbType

    /**
     * 分页拦截器的设置
     * @Configuration
     * public class MybatisPlusConfig {
     *     @Bean
     *     public PaginationInterceptor paginationInterceptor() {
     *         PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
     *         // 设置请求的页面大于最大页后操作， true调回到首页，false 继续请求
     *         // 默认false 为false时 会返回空数据
     *         paginationInterceptor.setOverflow(false);
     *         // 设置最大单页限制数量，默认 500 条，-1 不受限制
     *         // paginationInterceptor.setLimit(500);
     *         // 开启 count 的 join 优化,只针对部分 left join
     *         paginationInterceptor.setCountSqlParser(new JsqlParserCountOptimize(true));
     *         return paginationInterceptor;
     *     }
     *
     * }
     */

    return interceptor;
  }

  @Bean
  public SlowSqlInterceptor slowSqlInterceptor() {
    SlowSqlInterceptor slowSqlInterceptor = new SlowSqlInterceptor();
    return slowSqlInterceptor;
  }


  //RedissonClient
  @Bean
  public RedissonClient redissonClient() {
    Config config = new Config();
    config.useSingleServer().setAddress("redis://127.0.0.1:6379").setDatabase(0).setTimeout(300_000);
    return Redisson.create(config);

  }

  @Bean
  public RedisTemplate<Object, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
    RedisTemplate<Object, Object> redisTemplate = new RedisTemplate<>();
    redisTemplate.setConnectionFactory(redisConnectionFactory);
    //创建一个json的序列化对象
    GenericJackson2JsonRedisSerializer jackson2JsonRedisSerializer = new GenericJackson2JsonRedisSerializer();
    //设置value的序列化方式json
    redisTemplate.setValueSerializer(jackson2JsonRedisSerializer);
    //设置key序列化方式String
    redisTemplate.setKeySerializer(new StringRedisSerializer());
    //设置hash key序列化方式String
    redisTemplate.setHashKeySerializer(new StringRedisSerializer());
    //设置hash value序列化json
    redisTemplate.setHashValueSerializer(jackson2JsonRedisSerializer);
    // 设置支持事务
    redisTemplate.setEnableTransactionSupport(true);
    redisTemplate.afterPropertiesSet();
    return redisTemplate;
  }

  @Bean
  public RedisSerializer<Object> redisSerializer() {
    //创建JSON序列化器
    ObjectMapper objectMapper = new ObjectMapper();
    objectMapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
    //必须设置，否则无法将JSON转化为对象，会转化成Map类型
    objectMapper.activateDefaultTyping(LaissezFaireSubTypeValidator.instance, ObjectMapper.DefaultTyping.NON_FINAL);
    return new GenericJackson2JsonRedisSerializer(objectMapper);
  }



}