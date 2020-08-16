package h_multi_threads.printNumer_twoThreads;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class WaitAndNotify {
    //Implementation 2
    private static int count = 1;
    static void implementation2() {
        Object monitor = new Object(); //用来作为对象锁
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (monitor) {
                    while (count <= 20) {
                        if (count % 2 == 0) {
                            System.out.println(Thread.currentThread().getName() + ": " + count);
                            count++;
                            monitor.notify();
                        } else {
                            try {
                                monitor.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
                countDownLatch2.countDown();
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (monitor) {
                    while (count <= 20) {
                        if (count % 2 == 1) {
                            System.out.println(Thread.currentThread().getName() + ": " + count);
                            count++;
                            monitor.notify();
                        } else {
                            try {
                                monitor.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
                countDownLatch2.countDown();
            }
        }).start();

    }

    //CountDownLatch是一个非常实用的多线程控制工具类
    private static CountDownLatch countDownLatch2 = new CountDownLatch(2);

    public static void main(String[] args) throws InterruptedException {
        implementation2();
        countDownLatch2.await();
        System.out.println("===========================");
    }


}
