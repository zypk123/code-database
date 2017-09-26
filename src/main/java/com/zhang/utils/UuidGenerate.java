package com.zhang.utils;

import java.util.UUID;

/**
 * UUID生成器
 *
 * @author zhangyu
 * @create 2017-09-26 10:35
 **/
public class UuidGenerate {

    public static String getUUID() {
        UUID uuid = UUID.randomUUID();
        String str = uuid.toString();
        String uuidStr = str.replace("-", "");
        return uuidStr;
    }
}
