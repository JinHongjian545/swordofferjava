package h_multi_threads.three_way_of_multithreads;

import java.util.concurrent.Callable;

/**
 * @program: swordofferjava
 * @description:
 * @author: Jin Hongjian
 * @create: 2020-07-18
 **/
public class CallableTest implements Callable<String> {
    @Override
    public String call() throws Exception {
        System.out.println("通过Callable实现的多线程，Thread：" + Thread.currentThread().getName());
        return "Return String";
    }
}
