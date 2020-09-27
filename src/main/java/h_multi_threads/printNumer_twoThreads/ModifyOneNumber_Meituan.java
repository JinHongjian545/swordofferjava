package h_multi_threads.printNumer_twoThreads;

import java.util.concurrent.CountDownLatch;

/*
 * a初始值为10
 * 线程A不断的对a的值进行加 1，但要求A不能超过15
 * 线程B不断的对a的值进行加减 1，但要求A不能超过0
 * 不要求线程之间轮流执行操作
 * */
public class ModifyOneNumber_Meituan {
    private static int a = 10;
    private static final Object mutex = new Object();

    public static void main(String[] args) {
        Thread A = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    synchronized (mutex) {
                        if (a == 15) {
                            try {
                                mutex.wait();
                            } catch (Exception ignored) {
                            }
                        }
                        if (a < 15) {
                            a++;
                            System.out.println("Thread A: " + a);
                            if (a == 15) {
                                mutex.notify();
                            }
                        }
                    }
                }
            }
        });
        Thread B = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    synchronized (mutex) {
                        if (a == 0) {
                            try {
                                mutex.wait();
                            } catch (Exception ignored) {
                            }
                        }
                        if (a > 0) {
                            a--;
                            System.out.println("Thread B: " + a);
                            if (a == 0) {
                                mutex.notify();
                            }
                        }
                    }
                }
            }
        });

        A.start();
        B.start();

    }

    /*
    try {
                                    mutex.wait();
                                }catch (Exception e){}
    * */

}
