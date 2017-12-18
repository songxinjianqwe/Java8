package cn.sinjinsong.java8.future;

/**
 * @author songx
 * @date 2017/12/18
 */
public class Quote {
    private String shopName;
    private double price;
    private Discount.DiscountCode discountCode;

    public Quote(String shopName, double price, Discount.DiscountCode discountCode) {
        this.shopName = shopName;
        this.price = price;
        this.discountCode = discountCode;
    }
    
    public static Quote parse(String str){
        String [] slices = str.split(":");
        return new Quote(slices[0],Double.parseDouble(slices[1]),Discount.DiscountCode.valueOf(slices[2]));
    }

    public String getShopName() {
        return shopName;
    }

    public double getPrice() {
        return price;
    }

    public Discount.DiscountCode getDiscountCode() {
        return discountCode;
    }
}
