package cn.sinjinsong.java8.future;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

/**
 * @author songx
 * @date 2017/12/18
 */
public class BestProductPriceCalculator {
    private List<SyncShop> shops = Arrays.asList(
            new SyncShop("BestPrice"),
            new SyncShop("LetsSaveBig"),
            new SyncShop("MyFavoriteShop"),
            new SyncShop("BuyItAll")
    );

    public List<String> findPricesWithParallelStream(String product) {
        return shops
                .parallelStream()
                .map(shop -> shop.getName() + ":" + shop.getPrice(product))
                .collect(Collectors.toList());
    }

    public List<String> findPricesWithCompletableFuture(String product) {
        List<CompletableFuture<String>> futures = shops
                .stream()
                .map(shop -> CompletableFuture.supplyAsync(() -> shop.getName() + ":" + shop.getPrice(product)))
                .collect(Collectors.toList());
        // join方法和Future的get方法有相同的含义，并且也声明在Future接口中，它们唯一的不同就是join不会抛出任何检测到的异常。
        return futures.stream().map(CompletableFuture::join).collect(Collectors.toList());
    }
    
    
    
}
