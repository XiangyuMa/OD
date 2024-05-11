package interview;

import java.math.BigDecimal;

public class WineProduct extends Product{
    public static float discount;

    public WineProduct(int mount, BigDecimal price, String desc) {
        super(mount, price, desc);
    }


    public float getDiscount() {
        return discount;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }
}
