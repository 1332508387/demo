package com.lh.distributed.redis;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.sql.Time;

public class ItemController {
    private static final String TIME_KEY = "TIME_KEY";
    private static final String COUNT_KEY = "COUNT_KEY";
    public void getItemById(Long id) {
        if (!JedisTemplate.hasKey(TIME_KEY)) {
            JedisTemplate.setEle(TIME_KEY, "0", "NX", "EX", 3);
            JedisTemplate.setEle2(COUNT_KEY, "0");
        }

        String value = JedisTemplate.getValue(COUNT_KEY);
        int v = Integer.valueOf(value) + 1;
        if (JedisTemplate.hasKey(TIME_KEY) && v > 10) {
            System.out.println("limit");
        }

        System.out.println("success");
        JedisTemplate.setEle2(COUNT_KEY, v + "");
    }

    public static void main(String[] args) {
        for (int i = 0; i < 200; i++) {
            new ItemController().getItemById(1L);
        }
    }
}
