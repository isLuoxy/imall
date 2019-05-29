package com.l99.imall.util;

/**
 * 秒杀订单编号生成
 * @author L99
 * @createDate 2019/5/18
 *
 */
public class IdGenerate {

    private static SnowflakeIdWorker snowflakeIdWorker = new SnowflakeIdWorker(1, 1);

    public static final long nextId() {
        return snowflakeIdWorker.nextId();
    }
}
