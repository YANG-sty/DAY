package com.sys.lockTest.redisLock;

import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @author yangLongFei 2021-02-03-11:37
 */
public class RedissonController {


    @Autowired
    private StringRedisTemplate redisTemplate;

    @Autowired
    private Redisson redisson;

    @RequestMapping("/seckill")
    public  String seckill(){
        String result = "seckill success";
        String lock_key = "stock_num_lock_key";
        String threadId = UUID.randomUUID().toString();
        RLock lock = redisson.getLock(lock_key);
        try {
            //加锁
            lock.lock();

            Integer stockNum = Integer.parseInt(redisTemplate.opsForValue().get("stock_num"));
            //退出jvm虚拟机
//            System.exit(0);
            if(stockNum>0){
                int newStockNum = stockNum-1;
                redisTemplate.opsForValue().set("stock_num",newStockNum+"");
                System.out.println("下单成功，新库存为：："+newStockNum);
                result = "seckill success";

            }else {
                System.out.println("库存不足，下单失败");
                result =  "sekcill fail";
            }
        }finally {
            //解锁
            lock.unlock();
        }

        return result;
    }

}
