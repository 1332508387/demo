package com.lh.distributed.redis;

import org.omg.IOP.ComponentIdHelper;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisShardInfo;

public class JedisTemplate {
    private static final String REDIS_HOST = "192.168.1.10";
    private static Jedis jedis;

    static {
        jedis = new Jedis(REDIS_HOST);
        jedis.auth("ntidREDIS@6379!");
    }

    public static void setEle(String key, String value, String nxxx, String ex, long time) {
        String set = jedis.set(key, value, nxxx, ex, 10);
        System.out.println(set);
    }

    public static void setEle2(String key, String value) {
        jedis.set(key, value);
    }

    public static boolean hasKey(String key) {
        return jedis.get(key) != null;
    }

    public static String getValue(String key) {
        return jedis.get(key);
    }

    public static void main(String[] args) {
        /*boolean f = JedisTemplate.hasKey("COUNT_KEY");
        System.out.println(f);*/
//        JedisTemplate.setEle("AAA", "0", "NX", "EX", 2);
        JedisTemplate.setEle2("AAA", "aaa");
        JedisTemplate.setEle2("AAA", "bbb");
    }

}
