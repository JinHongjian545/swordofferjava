package h_multi_threads.printNumer_twoThreads;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class NoLockImplementation {
    //这里都不需要用volatile
    private static int num = 1;

    static void implementation1() {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (num <= 20) {
                    if (num % 2 == 0) {
                        System.out.println(Thread.currentThread().getName() + ": " + num);
                        num++;
                    }
                }
                countDownLatch.countDown();
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (num <= 20) {
                    if (num % 2 == 1) {
                        System.out.println(Thread.currentThread().getName() + ": " + num);
                        num++;
                    }
                }
                countDownLatch.countDown();
            }
        });
        thread1.start();
        thread2.start();
    }

    //CountDownLatch是一个非常实用的多线程控制工具类
    private static CountDownLatch countDownLatch = new CountDownLatch(2);

    public static void main(String[] args) throws InterruptedException {
        implementation1();
        countDownLatch.await(); //上面这个函数执行完了再执行下面的函数
        System.out.println("===========================");
    }


}
