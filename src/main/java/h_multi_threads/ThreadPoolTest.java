package h_multi_threads;

import java.util.concurrent.*;

/**
 * @program: swordofferjava
 * @description: 线程池的测试 以及 通过Callable和Future类获取线程的返回值
 * @author: Jin Hongjian
 * @create: 2020-07-15
 **/
public class ThreadPoolTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //固定大小线程池
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(6);
        for (int i = 0; i < 12; i++) {
            int finalI = i;
            fixedThreadPool.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("Runnable 线程名称：" + Thread.currentThread().getName() + " Num:" + finalI);
                    try {
                        Thread.sleep(2000);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }

        Future<String> future = fixedThreadPool.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                System.out.println("Callable 线程名称：" + Thread.currentThread().getName());
                try {
                    Thread.sleep(2000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return "========= TEST STRING =========";
            }
        });
        System.out.println("主线程输出");

        fixedThreadPool.shutdown();
        while (true) {
            if (fixedThreadPool.isTerminated()) {
                System.out.println("==================== 所有的子线程都结束了 ==================");
                break;
            }
            Thread.sleep(1000);
        }

        if (!future.isDone()) {
            System.out.println("子线程Future还没执行完");
        }

        System.out.println(future.get()); //这里如果子线程没有执行完则会阻塞

        System.out.println("TEST DONE");

    }

}
