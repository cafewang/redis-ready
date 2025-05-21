package com.wangyang.redis_ready;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.StringRedisTemplate;

@SpringBootTest
public class BitmapTest {
    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Test
    void testCount() {
        String key = "bitmap";
        stringRedisTemplate.opsForValue().setBit(key, 0, true);
        stringRedisTemplate.opsForValue().setBit(key, 10, true);
        stringRedisTemplate.opsForValue().setBit(key, 100, true);
        Assertions.assertEquals(true, stringRedisTemplate.opsForValue().getBit(key, 100));
        Assertions.assertEquals(false, stringRedisTemplate.opsForValue().getBit(key, 99));
        Assertions.assertEquals(3, stringRedisTemplate.execute((RedisCallback<Long>) connection ->
                connection.stringCommands().bitCount(key.getBytes())));
        stringRedisTemplate.opsForValue().getAndDelete(key);
    }
}
