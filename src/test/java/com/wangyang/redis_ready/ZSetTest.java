package com.wangyang.redis_ready;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;

@SpringBootTest
public class ZSetTest {
    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Test
    void testOder() {
        String key = "zset";
        String v1 = "c", v2 = "d", v3 = "a";
        double score1 = 1, score2 = 1, score3 = 2;
        stringRedisTemplate.opsForZSet().add(key, v1, score1);
        stringRedisTemplate.opsForZSet().add(key, v2, score2);
        stringRedisTemplate.opsForZSet().add(key, v3, score3);
        Assertions.assertEquals(v3, stringRedisTemplate.opsForZSet().popMax(key).getValue());
        Assertions.assertEquals(v2, stringRedisTemplate.opsForZSet().popMax(key).getValue());
        Assertions.assertEquals(v1, stringRedisTemplate.opsForZSet().popMax(key).getValue());
        stringRedisTemplate.opsForZSet().popMax(key);
    }
}
