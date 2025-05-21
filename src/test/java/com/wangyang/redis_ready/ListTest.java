package com.wangyang.redis_ready;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;

@SpringBootTest
public class ListTest {
    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Test
    void testPushAndPop() {
        String key = "list";
        stringRedisTemplate.opsForList().leftPushAll(key, "1", "2", "3");
        Assertions.assertEquals("1", stringRedisTemplate.opsForList().rightPop(key));
        Assertions.assertEquals(2, stringRedisTemplate.opsForList().size(key));
        stringRedisTemplate.opsForList().leftPop(key, 3);
    }
}
