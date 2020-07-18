package h_multi_threads.three_way_of_multithreads;

/**
 * @program: swordofferjava
 * @description:
 * @author: Jin Hongjian
 * @create: 2020-07-18
 **/
public class RunnableTest implements Runnable {
    @Override
    public void run() {
        System.out.println("通过Runnable接口实现的多线程，Thread：" + Thread.currentThread().getName());
    }
}
