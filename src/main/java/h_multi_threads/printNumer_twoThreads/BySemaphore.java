package h_multi_threads.printNumer_twoThreads;
import java.util.concurrent.Semaphore;

//这里不能实现，因为不能保证释放以后下次获取到信号量的就是另外一个线程，也有可能是自己又获取到了
public class BySemaphore {
    private static Semaphore semaphore = new Semaphore(1);
    private static int num = 1;

    static void implementation4() {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (num <= 20) {
                    try {
                        semaphore.acquire();
                        System.out.println(Thread.currentThread().getName() + ": " + num++);
                        semaphore.release();
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (num <= 20) {
                    try {
                        semaphore.acquire();
                        System.out.println(Thread.currentThread().getName() + ": " + num++);
                        semaphore.release();
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        thread1.start();
        thread2.start();
    }

    public static void main(String[] args) throws InterruptedException {
        implementation4();
    }


}
