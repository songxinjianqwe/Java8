package cn.sinjinsong.java8.future;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;

/**
 * @author songx
 * @date 2017/12/18
 */
public class CallbackBestProductPriceCalculator {
    private List<PipelineShop> shops = Arrays.asList(
            new PipelineShop("BestPrice"),
            new PipelineShop("LetsSaveBig"),
            new PipelineShop("MyFavoriteShop"),
            new PipelineShop("BuyItAll")
    );

    public Stream<CompletableFuture<String>> findPricesStream(String product) {
        return shops
                .stream()
                .map(shop -> CompletableFuture.supplyAsync(() -> shop.getPrice(product)))
                .map(future -> future.thenApply(Quote::parse))
                .map(future -> future.thenCompose(
                        quote -> CompletableFuture.supplyAsync(
                                () -> Discount.applyDiscount(quote)
                        )
                ));
    }
}
