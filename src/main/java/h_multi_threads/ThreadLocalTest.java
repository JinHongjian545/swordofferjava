package h_multi_threads;

/**
 * @program: swordofferjava
 * @description: 测试Java ThreadLocal
 * @author: Jin Hongjian
 * @create: 2020-07-15
 **/

public class ThreadLocalTest {

    private static final ThreadLocal<String> threadLocalA = new ThreadLocal<>();
    private static final ThreadLocal<String> threadLocalB = new ThreadLocal<>();

    static void print(String str) {
        //打印当前线程中本地内存中本地变量的值
        System.out.println(str + " :" + threadLocalA.get());
        System.out.println(str + " :" + threadLocalB.get());
        //清除本地内存中的本地变量
        threadLocalA.remove();
        threadLocalB.remove();
    }

    public static void main(String[] args) {
        Thread t1  = new Thread(new Runnable() {
            @Override
            public void run() {
                //设置线程1中本地变量的值
                threadLocalA.set("localVar1-A");
                threadLocalB.set("localVar1-B");
                //调用打印方法
                print("thread1");
                //打印本地变量
                System.out.println("after remove : " + threadLocalA.get());
            }
        });

        Thread t2  = new Thread(new Runnable() {
            @Override
            public void run() {
                //设置线程1中本地变量的值
                threadLocalA.set("localVar2-A");
                threadLocalB.set("localVar2-B");
                //调用打印方法
                print("thread2");
                //打印本地变量
                System.out.println("after remove : " + threadLocalA.get());
            }
        });

        t1.start();
        t2.start();
    }
}