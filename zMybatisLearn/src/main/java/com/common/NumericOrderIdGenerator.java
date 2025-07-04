package com.common;

/**
 * @author
 * @version 1.0
 * @date 2025/6/18
 */

import cn.hutool.core.util.IdUtil;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.HashSet;
import java.util.concurrent.ThreadLocalRandom;

public class NumericOrderIdGenerator {
    // 时间基准点：2020-01-01 00:00:00 UTC
    private static final long BASE_TIMESTAMP = Instant.parse("2020-01-01T00:00:00Z").getEpochSecond();
    private static final int TIMESTAMP_LENGTH = 7;  // 7位时间差（支持约23年）
    private static final int MERCHANT_ID_LENGTH = 6; // 6位商家ID（支持百万级）
    private static final int BUYER_ID_LENGTH = 6;    // 6位买家ID（支持百万级）
    private static final int RANDOM_LENGTH = 1;      // 1位随机数（10种可能）
    private static final int TOTAL_LENGTH = TIMESTAMP_LENGTH + MERCHANT_ID_LENGTH + BUYER_ID_LENGTH + RANDOM_LENGTH;

    /**
     * 生成纯数字订单ID
     *
     * @param merchantId 商家ID（0 ~ 999,999）
     * @param buyerId    买家ID（0 ~ 999,999）
     * @return 20位纯数字订单号
     */
    public static String generate(long merchantId, long buyerId) {
        // 验证ID范围
        validateId(merchantId, 999999, "商家ID");
        validateId(buyerId, 999999, "买家ID");

        StringBuilder sb = new StringBuilder(TOTAL_LENGTH);

        // 1. 时间部分：从2020年开始的秒数（7位）
        long secondsFromBase = Instant.now().getEpochSecond() - BASE_TIMESTAMP;
        formatNumber(sb, secondsFromBase, TIMESTAMP_LENGTH);

        // 2. 商家ID（6位）
        formatNumber(sb, merchantId, MERCHANT_ID_LENGTH);

        // 3. 买家ID（6位）
        formatNumber(sb, buyerId, BUYER_ID_LENGTH);

        // 4. 随机数（1位）
        sb.append(ThreadLocalRandom.current().nextInt(10));

        return sb.toString();
    }

    private static void validateId(long id, long max, String name) {
        if (id < 0 || id > max) {
            throw new IllegalArgumentException(name + "必须在0到" + max + "之间");
        }
    }

    /**
     * 格式化数字为固定长度（左侧补零）
     */
    private static void formatNumber(StringBuilder sb, long number, int length) {
        String numStr = Long.toString(number);
        if (numStr.length() > length) {
            throw new IllegalArgumentException("数值超出长度限制: " + number);
        }

        // 左侧补零
        for (int i = numStr.length(); i < length; i++) {
            sb.append('0');
        }
        sb.append(numStr);
    }

    /**
     * 解码订单ID（提取时间戳）
     */
    public static Instant getOrderTime(String orderId) {
        if (orderId == null || orderId.length() != TOTAL_LENGTH) {
            throw new IllegalArgumentException("订单ID长度必须为" + TOTAL_LENGTH + "位");
        }

        // 提取时间部分
        String timePart = orderId.substring(0, TIMESTAMP_LENGTH);
        long secondsFromBase = Long.parseLong(timePart);
        return Instant.ofEpochSecond(BASE_TIMESTAMP + secondsFromBase);
    }

    /**
     * 解码订单ID（提取商家ID）
     */
    public static long getMerchantId(String orderId) {
        return Long.parseLong(orderId.substring(
                TIMESTAMP_LENGTH,
                TIMESTAMP_LENGTH + MERCHANT_ID_LENGTH
        ));
    }

    /**
     * 解码订单ID（提取买家ID）
     */
    public static long getBuyerId(String orderId) {
        return Long.parseLong(orderId.substring(
                TIMESTAMP_LENGTH + MERCHANT_ID_LENGTH,
                TIMESTAMP_LENGTH + MERCHANT_ID_LENGTH + BUYER_ID_LENGTH
        ));
    }

    // 测试
    public static void main(String[] args) {
//        // 生成订单ID
//        String orderId = generate(12345, 67890);
//        System.out.println("生成的订单ID: " + orderId);
//
//        // 解码信息
//        System.out.println("\n订单详细信息:");
//        System.out.println("生成时间: " + getOrderTime(orderId));
//        System.out.println("商家ID: " + getMerchantId(orderId));
//        System.out.println("买家ID: " + getBuyerId(orderId));
//
//        // 批量生成测试
//        System.out.println("\n批量生成测试:");
//        for (int i = 0; i < 2; i++) {
//            System.out.println(generate(1001, 2002));
//        }
        System.out.println(IdUtil.getSnowflake(1l).nextId());
        System.out.println(13 % 6);

        System.out.println(System.currentTimeMillis());

        HashSet<BigDecimal> bigDecimals = new HashSet<>();

    }
}

