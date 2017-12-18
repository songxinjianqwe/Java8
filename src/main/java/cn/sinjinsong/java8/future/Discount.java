package cn.sinjinsong.java8.future;

import static cn.sinjinsong.java8.future.PipelineShop.delay;

/**
 * @author songx
 * @date 2017/12/18
 */
public class Discount {
    public enum DiscountCode{
        NONE(0),SILVER(5),GOLD(10),PLATINUM(15),DIAMOND(20);
        private int percentage;
        DiscountCode(int percentage){
            this.percentage = percentage;    
        }
    }
    
     public static String applyDiscount(Quote quote){
        return quote.getShopName()+ " price is " + apply(quote.getPrice(), quote.getDiscountCode());
     }

    private static double apply(double price, DiscountCode discountCode) {
        // 模拟调用远程服务的延迟
        delay();
        return price * ( 100 - discountCode.percentage ) / 100 ; 
    }

}
