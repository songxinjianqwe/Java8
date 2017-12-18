package cn.sinjinsong.java8.future;

import java.util.concurrent.*;

/**
 * @author songx
 * @date 2017/12/18
 */
public class FutureSample {
    public void future() {
        ExecutorService executor = Executors.newCachedThreadPool();
        Future<Double> future = executor.submit(new Callable<Double>() {
            @Override
            public Double call() throws Exception {
                return doSomethingComputation();
            }
        });
        // 在另一个线程执行耗时操作的同时，去执行一些其他的任务。
        // 这些任务不依赖于future的结果，可以与future并发执行。
        // 如果下面的任务马上依赖于future的结果，那异步操作是没有意义的。
        doSomethingElse();
        try {
            // 如果不设置超时时间，那么线程会阻塞在这里。
            Double result = future.get(1, TimeUnit.SECONDS);
            System.out.println("result is " + result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
    }

    private void doSomethingElse() {
        System.out.println("doSomethingElse");
    }

    private double doSomethingComputation() {
        System.out.println("doSomethingComputation");
        return 0.1;
    }
}
