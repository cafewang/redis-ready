package com.wangyang.redis_ready;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;

@SpringBootTest
public class StringTest {
    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Test
    void testUnicode() {
        String key = "键", value = "值";
        stringRedisTemplate.opsForValue().set(key, value);
        Assertions.assertEquals(value, stringRedisTemplate.opsForValue().getAndDelete(key));
    }

    @Test
    void testNumber() {
        String key = "key";
        long value = 123L;
        stringRedisTemplate.opsForValue().set(key, Long.toString(value));
        Assertions.assertEquals(value + 1, stringRedisTemplate.opsForValue().increment(key));
        stringRedisTemplate.opsForValue().getAndDelete(key);
    }

    @Test
    void testLinearOps() {
        String key = "key", value = "Hello World";
        stringRedisTemplate.opsForValue().set(key, value);
        stringRedisTemplate.opsForValue().set(key, "Redis", 6);
        Assertions.assertEquals("Hello Redis", stringRedisTemplate.opsForValue().getAndDelete(key));
    }
}
