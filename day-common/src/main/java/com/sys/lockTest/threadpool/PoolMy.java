package com.sys.lockTest.threadpool;

import java.util.concurrent.*;

/**
 * @author yangLongFei 2020-12-19-10:49
 */
public class PoolMy {

    /**
     * 线程池
     */
    public static void main(String[] args) {


        /**
         * Executors.newCachedThreadPool();        //创建一个缓冲池，缓冲池容量大小为Integer.MAX_VALUE
         * Executors.newSingleThreadExecutor();   //创建容量为1的缓冲池
         * Executors.newFixedThreadPool(int);    //创建固定容量大小的缓冲池
         */
        /*ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            final int index = i;
            try {
                Thread.sleep(index * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            cachedThreadPool.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(index);
                }
            });
        }*/


        ThreadFactory threadFactory = new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                return null;
            }
        };

        /**
         * 一般需要根据任务的类型来配置线程池大小：
         * 如果是CPU密集型任务，就需要尽量压榨CPU，参考值可以设为 NCPU+1
         * 如果是IO密集型任务，参考值可以设置为2*NCPU
         * 当然，这只是一个参考值，具体的设置还需要根据实际情况进行调整，比如可以先将线程池大小设置为参考值，再观察任务运行情况和系统负载、资源利用率来进行适当调整。
         *
         * workQueue的类型为BlockingQueue<Runnable>，通常可以取下面三种类型：
         * 　　1）ArrayBlockingQueue：基于数组的先进先出队列，此队列创建时必须指定大小；
         * 　　2）LinkedBlockingQueue：基于链表的先进先出队列，如果创建时没有指定此队列大小，则默认为Integer.MAX_VALUE；
         * 　　3）synchronousQueue：这个队列比较特殊，它不会保存提交的任务，而是将直接新建一个线程来执行新来的任务。
         *
         *
         * 设置任务拒绝，这个时候，需要使用 ArrayBlockingQueue 手动的指定缓存队列的大小
         * 当线程池的任务缓存队列已满并且线程池中的线程数目达到maximumPoolSize，如果还有任务到来就会采取任务拒绝策略，通常有以下四种策略：
         * ThreadPoolExecutor.AbortPolicy:丢弃任务并抛出RejectedExecutionException异常。
         * ThreadPoolExecutor.DiscardPolicy：也是丢弃任务，但是不抛出异常。
         * ThreadPoolExecutor.DiscardOldestPolicy：丢弃队列最前面的任务，然后重新尝试执行任务（重复此过程）
         * ThreadPoolExecutor.CallerRunsPolicy：由调用线程处理该任务
         */
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 10, 15, TimeUnit.SECONDS, new LinkedBlockingQueue<>());

        /**
         * 可以进行动态的调整操作
         * setCorePoolSize：设置核心池大小
         * setMaximumPoolSize：设置线程池最大能创建的线程数目大小
         */
        threadPoolExecutor.setCorePoolSize(10);
        threadPoolExecutor.setMaximumPoolSize(20);


        for (int i = 0; i < 20; i++) {
            RunTask myTask = new RunTask(i);
            threadPoolExecutor.execute(myTask);
            System.out.println("线程池中线程数目：" + threadPoolExecutor.getPoolSize() + "，队列中等待执行的任务数目：" +
                    threadPoolExecutor.getQueue().size() + "，已执行完的任务数目：" + threadPoolExecutor.getCompletedTaskCount());
        }

        /**
         * shutdown()：不会立即终止线程池，而是要等所有任务缓存队列中的任务都执行完后才终止，但再也不会接受新的任务
         * shutdownNow()：立即终止线程池，并尝试打断正在执行的任务，并且清空任务缓存队列，返回尚未执行的任务
         */
        threadPoolExecutor.shutdown();

    }
}
