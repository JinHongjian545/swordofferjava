package h_multi_threads;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/**
 * @program: swordofferjava
 * @description: Java子线程往父线程抛异常
 * @author: Jin Hongjian
 * @create: 2020-07-15
 **/
public class ThreadThrowException {

    public static void main(String[] args) {

        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(6);
        try {
            //无法捕获子线程异常
            fixedThreadPool.execute(new MyRunnable());
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println("捕获到异常"); //是不可能执行到这里的，因为捕获不到子线程的异常
            e.printStackTrace();
        }

        System.out.println();
        System.out.println();

        //通过UncaughtExceptionHandler捕获子线程运行时异常
        try {
            Thread thread2 = new Thread(new MyRunnable());
            thread2.setUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
            thread2.start();
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println("捕获到异常"); //同样也是不可能执行到这里的，因为捕获异常的工作让异常处理器做了，不是在这里Catch
            e.printStackTrace();
        }

        System.out.println();
        System.out.println();


        try {
            //通过线程池执行子线程，不能捕获异常
            //线程池中会重设置新的Thread对象，而这个Thread对象没有设置任何异常处理器，换句话说我们在线程池外对线程做的任何操作都是没有用的
            Thread thread = new Thread(new MyRunnable());
            thread.setUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
            fixedThreadPool.execute(thread);
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println("捕获到异常"); //是不可能执行到这里的，因为捕获不到子线程的异常
            e.printStackTrace();
        }

        System.out.println();
        System.out.println();


        ExecutorService fixedThreadPool1 = Executors.newFixedThreadPool(6, new HandlerThreadFactory());
        try {
            //这里同样走线程池，但是呢是通过ThreadFactory方式，在ThreadFactory中会对线程做一些控制，可以设置异常处理器
            //此时是可以捕获异常的。
            fixedThreadPool1.execute(new MyRunnable());
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println("捕获到异常"); //同样也是不可能执行到这里的，因为捕获异常的工作让异常处理器做了，不是在这里Catch
            e.printStackTrace();
        }


        System.out.println();
        System.out.println("======= TEST DONE ========");

        fixedThreadPool.shutdown();
        fixedThreadPool1.shutdown();
        /*
        * shutdown()有什么功能？
            答：阻止新来的任务提交，对已经提交了的任务不会产生任何影响。当已经提交的任务执行完后，它会将那些闲置的线程（idleWorks）进行中断，这个过程是异步的。
            问：如何阻止新来的任务提交？
            答：通过将线程池的状态改成SHUTDOWN，当再将执行execute提交任务时，如果测试到状态不为RUNNING，则抛出rejectedExecution，
        */
    }

}

//子线程抛出异常
class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("MyRunnable 子线程正在执行，线程名：" + Thread.currentThread().getName());
        //随机抛个异常
        throw new RuntimeException("MyRunnable 线程抛出异常，线程名：" + Thread.currentThread().getName());
    }
}

//捕获异常处理器
class MyUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {
    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.println("！！！ MyUncaughtExceptionHandler 捕获到异常，线程名：" + t.getName() + ", 异常信息：" + e.getMessage());
    }
}

//设置一个线程工厂来创建线程，让通过线程池提交的子线程也可以捕获异常
class HandlerThreadFactory implements ThreadFactory {
    @Override
    public Thread newThread(Runnable r) {
        Thread thread = new Thread(r);
        thread.setUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
        System.out.println("线程工厂中创建新线程");
        return thread;
    }
}