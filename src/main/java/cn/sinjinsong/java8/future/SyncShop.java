package cn.sinjinsong.java8.future;

import java.util.concurrent.ThreadLocalRandom;

/**
 * @author songx
 * @date 2017/12/18
 */
public class SyncShop {
    private String name;

    public SyncShop(String name) {
        this.name = name;
    }

    public static void delay() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    public double getPrice(String product) {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        delay();
        return random.nextDouble() * product.charAt(0) + product.charAt(1);
    }

    public String getName() {
        return name;
    }
}
