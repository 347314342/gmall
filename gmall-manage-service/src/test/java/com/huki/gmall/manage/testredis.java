package com.huki.gmall.manage;

import com.huki.gmall.util.RedisUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import redis.clients.jedis.Jedis;

//连接redis的测试
@RunWith(SpringRunner.class)
@SpringBootTest
public class testredis {

    @Autowired
    RedisUtil redisUtil;

@Test
    public  void contextLoads() {
        Jedis jedis = redisUtil.getJedis();

        jedis.set("huki2", "nice2");
        String hk = jedis.get("huki2");
        System.out.println(hk);
    }
}
