package h_multi_threads;

/**
 * @program: swordofferjava
 * @description:
 * @author: Jin Hongjian
 * @create: 2020-09-14
 **/
public class DeadLockDemo extends Thread {

    String lockA;
    String lockB;

    public DeadLockDemo(String name, String lockA, String lockB) {
        super(name);
        this.lockA = lockA;
        this.lockB = lockB;
    }

    public void run() {
        synchronized (lockA) {
            System.out.println(Thread.currentThread().getName() + "拿到了" + lockA + ",等待拿到" + lockB);
            try {
                Thread.sleep(1000);
                synchronized (lockB) {
                    System.out.println(Thread.currentThread().getName() + "拿到了" + lockB);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    public static void main(String[] args) {
        String lockA = "lockA";
        String lockB = "lockB";
        DeadLockDemo threadA = new DeadLockDemo("ThreadA", lockA, lockB);
        DeadLockDemo threadB = new DeadLockDemo("ThreadB", lockB, lockA);
        threadA.start();
        threadB.start();
/*        try {
            threadA.join(); //thread.join方法的意思就是等待thread执行完再继续执行本线程
            threadB.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        System.out.println("主线程");
    }
}