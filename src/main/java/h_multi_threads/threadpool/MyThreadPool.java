package h_multi_threads.threadpool;

import com.sun.xml.internal.bind.v2.model.annotation.RuntimeAnnotationReader;
import h_multi_threads.three_way_of_multithreads.RunnableTest;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @program: swordofferjava
 * @description: 手写线程池, 固定线程数量的线程池
 * @author: Jin Hongjian
 * @create: 2020-09-21
 **/
public class MyThreadPool {
    private List<Thread> threads;

    private ArrayBlockingQueue<Runnable> taskQueue;

    private final Object mutex = new Object();

    public MyThreadPool(int threadSize, int blockingQueueSize) {
        threads = new ArrayList<>(threadSize);
        taskQueue = new ArrayBlockingQueue<>(blockingQueueSize);

        /* 直接初始化 */
        for (int i = 0; i < threadSize; i++) {
            ThreadWorker threadWorker = new ThreadWorker();
            threads.add(threadWorker);
            threadWorker.start(); //启动这些线程
        }
    }

    /* 添加任务 */
    public void submit(Runnable runnable) {
        synchronized (mutex) {
            taskQueue.offer(runnable);
            mutex.notify();
        }
    }

    /* 关闭线程池 */
    public void shutdown() {
        synchronized (mutex) {
            while (!taskQueue.isEmpty()) {
                taskQueue.poll();
            }
        }
        for (Thread thread : threads) {
            if (thread.isAlive())
                thread.interrupt();
        }
    }

    /* 自定义线程类 */
    private class ThreadWorker extends Thread {
        @Override
        public void run() {
            Runnable runnable = null;
            while (true) {
                synchronized (mutex) {
                    while (taskQueue.isEmpty()) {
                        try {
                            mutex.wait();
                        } catch (InterruptedException e) {
                            System.out.println("接收到中断，结束线程: " + Thread.currentThread().getName());
                            return; //中断的时候退出
                        }
                    }
                    runnable = taskQueue.poll();
                }
                if (runnable != null) {
                    runnable.run();
                }
            }
        }
    }


    /* 测试 */
    public static void main(String[] args) {
        MyThreadPool myThreadPool = new MyThreadPool(3, 5);
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            myThreadPool.submit(() -> {
                System.out.println(Thread.currentThread().getName() + ": " + finalI + " is Running");
                try {
                    Thread.sleep(500); //这里如果
                } catch (Exception e) {
                    //e.printStackTrace();
                }
            });
        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        myThreadPool.shutdown();

/*        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(5);
        fixedThreadPool.shutdown();*/
    }

}
