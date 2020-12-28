package com.sys.lockTest.threadpool;

/**
 * @author yangLongFei 2020-12-19-12:27
 */
public class RunTask implements Runnable {

    private int taskNum;

    public RunTask(int taskNum) {
        this.taskNum = taskNum;
    }

    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run() {
        System.out.println("正在执行task "+ taskNum );
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("task "+ taskNum +"执行完毕");
    }
}
