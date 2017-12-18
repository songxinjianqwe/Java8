package cn.sinjinsong.java8.future;

import java.util.concurrent.*;

/**
 * @author songx
 * @date 2017/12/18
 */
public class Shop {
    private ThreadLocalRandom random;
    private ExecutorService executorService = Executors.newCachedThreadPool();
    
    public Future<Double> getPriceAsync(String product){
        CompletableFuture<Double> future = new CompletableFuture<>();
        // 另一个线程计算
        executorService.submit(() -> {
            try {
                double price = calculatePrice(product);
                future.complete(price);
            } catch (Exception e) {
                // 处理异常
                future.completeExceptionally(e);
                e.printStackTrace();
            }
        });
        return future;
    }
    
    private double calculatePrice(String product){
        random = ThreadLocalRandom.current();
        // 模拟耗时操作
        delay();
        // 随机
        return random.nextDouble() * product.charAt(0) + product.charAt(1);
    }
    
    public static void delay(){
        try {
            Thread.sleep(1000);
            throw new RuntimeException("product is not available");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Shop shop = new Shop();

        Future<Double> price = shop.getPriceAsync("my favorite product");
        // 计算price和doSomethingElse是并发执行的
        doSomethingElse();
        try {
            // 如果此时已经计算完毕，则立即返回；如果没有计算完毕，则会阻塞
            Double result = price.get();
            System.out.println("result is " + result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        
    }

    private static void doSomethingElse() {
        System.out.println("doSomethingElse");
    }
}
