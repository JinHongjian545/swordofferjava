package h_multi_threads.three_way_of_multithreads;

import com.sun.org.apache.xalan.internal.res.XSLTErrorResources_en;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @program: swordofferjava
 * @description:
 * @author: Jin Hongjian
 * @create: 2020-07-18
 **/
public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("测试开始");
        //创建线程 通过Thread
        for (int i = 0; i < 5; i++) {
            ThreadClassTest thread = new ThreadClassTest();
            thread.start();
        }

        //创建线程，通过Runnable
        for (int i = 0; i < 5; i++) {
            RunnableTest runnableTest = new RunnableTest();
            runnableTest.run();
        }

        //创建线程，通过Callable
        for (int i = 0; i < 5; i++) {
            CallableTest callableTest = new CallableTest();
            String call = callableTest.call();
            System.out.println(call);
        }

        Thread.sleep(2000);
        System.out.println("====================================");

        //通过线程池提交
        List<Future> futures = new ArrayList<>();
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 5; i++) {
            fixedThreadPool.execute(new RunnableTest());
        }
        for (int i = 0; i < 5; i++) {
            CallableTest callableTest = new CallableTest();
            Future<String> submit = fixedThreadPool.submit(callableTest);
            futures.add(submit);
        }

        for (Future future : futures) {
            System.out.println(future.get());
        }

        Thread.sleep(2000);
        System.out.println("==============================");

        //使用FutureTask获取线程返回值
        FutureTask<String> futureTask = new FutureTask<String>(new CallableTest());
        fixedThreadPool.submit(futureTask);

        System.out.println(futureTask.get());

        fixedThreadPool.shutdown();
    }


}
