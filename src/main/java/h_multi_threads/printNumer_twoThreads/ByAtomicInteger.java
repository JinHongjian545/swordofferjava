package h_multi_threads.printNumer_twoThreads;

import a_swordoffer.a_26_27_28_sub_mirror_tree.TheSameTree;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class ByAtomicInteger {
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

    public static void main(String[] args) throws InterruptedException {
        implementation3();
    }


}
