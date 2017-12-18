package future;

import cn.sinjinsong.java8.future.BestProductPriceWithDiscountCalculator;
import cn.sinjinsong.java8.future.BestProductPriceCalculator;
import cn.sinjinsong.java8.future.CallbackBestProductPriceCalculator;
import org.junit.Test;

import java.util.concurrent.CompletableFuture;

/**
 * @author songx
 * @date 2017/12/18
 */
public class FutureTest {
    private BestProductPriceCalculator calculator = new BestProductPriceCalculator();
    private BestProductPriceWithDiscountCalculator priceWithDiscountCalculator = new BestProductPriceWithDiscountCalculator();
    private CallbackBestProductPriceCalculator callbackBestProductPriceCalculator = new CallbackBestProductPriceCalculator();
    // 1s 
    @Test
    public void testParallelStream(){
        calculator.findPricesWithParallelStream("my favorite product");
    }
    //2s 
    @Test
    public void testCompletableFuture(){
        calculator.findPricesWithCompletableFuture("my favorite product");    
    }
    
    @Test
    public void testPipeline() {
        priceWithDiscountCalculator.findPricesWithPipeline("my favorite product").forEach(System.out::println);
    }
    
    @Test
    public void testCallback(){
        CompletableFuture[] futures = callbackBestProductPriceCalculator.findPricesStream("my favorite product").map(
                future -> future.thenAccept(System.out::println)
        ).toArray(size -> new CompletableFuture[size]);
        CompletableFuture.allOf(futures).join();
    }
    
}
