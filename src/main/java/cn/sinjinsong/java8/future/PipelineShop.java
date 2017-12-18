package cn.sinjinsong.java8.future;

import java.util.concurrent.ThreadLocalRandom;

/**
 * @author songx
 * @date 2017/12/18
 */
public class PipelineShop {
    private String name;

    public PipelineShop(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getPrice(String product) {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        double price = calculatePrice(product);
        Discount.DiscountCode code = Discount.DiscountCode.values()[random.nextInt(Discount.DiscountCode.values().length)];
        return String.format("%s:%.2f:%s", name, price, code);
    }
    
    private double calculatePrice(String product) {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        // 模拟耗时操作
        delay();
        // 随机
        return random.nextDouble() * product.charAt(0) + product.charAt(1);
    }

    public static void delay() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
