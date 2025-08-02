--    DefaultRedisScript<String> redisScript = new DefaultRedisScript<>();
--    redisScript.setScriptSource(new ResourceScriptSource(new ClassPathResource("lua/KILL_GOODS.lua")));
--    redisScript.setResultType(String.class);
--    List keyList = Arrays.asList("goods", "GOODS_STOCK_KEY");
--    String result = stringRedisTemplate.execute(redisScript, keyList, "userId");


--tonumber  转成数字类型
local isExist = redis.call("exists", KEYS[1])
if isExist then
    local goodsNumber = redis.call("get", KEYS[1])
    if tonumber(goodsNumber) > 0 then
        redis.call("decr", KEYS[1])
        return "success"
    else

        -- tostring()  转成字符串类型
        --redis.call("del", KEYS[1])
        --return redis.call("get", KEYS[2])
        return "没有库存"
    end
else
    return "找不到商品"
end