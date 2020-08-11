package h_multi_threads;

import a_swordoffer.a_26_27_28_sub_mirror_tree.TheSameTree;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class PrintNumberInTwoThreads {
    //Implementation 1
    private static volatile int num = 1;

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


    //Implementation 3
    private static AtomicInteger atomicInteger = new AtomicInteger(1);
    static void implementation3() {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (atomicInteger.get() < 20) {
                    if (atomicInteger.get() % 2 == 0) {
                        System.out.println(Thread.currentThread().getName() + ": " + atomicInteger.get());
                        atomicInteger.incrementAndGet();
                    }
                }

            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (atomicInteger.get() < 20) {
                    if (atomicInteger.get() % 2 == 1) {
                        System.out.println(Thread.currentThread().getName() + ": " + atomicInteger.get());
                        atomicInteger.getAndIncrement();
                    }
                }
            }
        });
        thread1.start();
        thread2.start();
    }

    //CountDownLatch是一个非常实用的多线程控制工具类
    private static CountDownLatch countDownLatch = new CountDownLatch(2);
    private static CountDownLatch countDownLatch2 = new CountDownLatch(2);

    public static void main(String[] args) throws InterruptedException {
        implementation1();
        countDownLatch.await(); //上面这个函数执行完了再执行下面的函数
        System.out.println("===========================");
        implementation2();
        countDownLatch2.await();
        System.out.println("===========================");
        implementation3();
    }


}
