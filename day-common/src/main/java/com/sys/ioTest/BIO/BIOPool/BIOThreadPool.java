package com.sys.ioTest.BIO.BIOPool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author yangLongFei 2021-03-14-15:32
 */
public class BIOThreadPool {
    //线程池
    private ExecutorService executorService;

    public BIOThreadPool(int maxPoolSize, int queueSize) {
        this.executorService = new ThreadPoolExecutor(
                3,
                maxPoolSize,
                120L,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(queueSize)
        );
    }

    public void execute(Runnable runnable) {
        this.executorService.execute(runnable);
    }
}
