package com.sys.lockTest.redisLock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * redission 分布式框架，分布式锁
 * zookepper（强一致性，数据敏感的时候使用）
 * redis （主节点宕机后，从节点可能会出现短暂的不一致情况）
 * setnx set if not exists
 * setnx key value
 * setnx samuel nx 设置成功
 * setnx samuel nx100 不成功
 */
@RestController
public class OrderController {

    @Autowired
    private StringRedisTemplate redisTemplate;

    @RequestMapping("/seckill")
    public  String seckill(){
        String result = "seckill success";
        String lock_key = "stock_num_lock_key";
        String threadId = UUID.randomUUID().toString();
        try {

            //加锁，在设置数据的时候，设置超时时间，保证操作的原子性
//            Boolean success = redisTemplate.opsForValue().setIfAbsent(lock_key, threadId,30,TimeUnit.SECONDS);
            Boolean aBoolean = redisTemplate.opsForValue().setIfAbsent(lock_key, threadId);
            Boolean success = redisTemplate.expire(lock_key, 30, TimeUnit.SECONDS);
            if(!success){
                System.out.println("加锁失败");
                return "get lock fail";
            }

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
            //unlock
            if(threadId.equals(redisTemplate.opsForValue().get(lock_key))){
                redisTemplate.delete(lock_key);
            }

        }

        return result;
    }


//    @Autowired
//    private StringRedisTemplate redisTemplate;
    @RequestMapping("/seckill2")
    public  String seckill2(){
        String result = "seckill success";
        String lock_key = "stock_num_lock_key";
        String threadId = UUID.randomUUID().toString();
        try {

            //加锁
//            Boolean success = redisTemplate.opsForValue().setIfAbsent(lock_key, threadId, 30, TimeUnit.SECONDS);
            Boolean aBoolean = redisTemplate.opsForValue().setIfAbsent(lock_key, threadId);
            Boolean success = redisTemplate.expire(lock_key, 30, TimeUnit.SECONDS);
            if(!success){
                System.out.println("加锁失败");
                return "get lock fail";
            }
            //加上一个自旋线程，防止代码块执行超时过期，导致key过期（自动解锁）
            new Thread(){
                @Override
                public void run(){
                    String str = redisTemplate.opsForValue().get(lock_key);
                    while (threadId.equals(str)){
                        redisTemplate.expire(lock_key,10,TimeUnit.SECONDS);
                        try {
                            TimeUnit.SECONDS.sleep(4);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }.start();

            Integer stockNum = Integer.parseInt(redisTemplate.opsForValue().get("stock_num"));
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
            //unlock
            if(threadId.equals(redisTemplate.opsForValue().get(lock_key))){
                redisTemplate.delete(lock_key);
            }
        }

        return result;
    }

}