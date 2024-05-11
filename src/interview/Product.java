package interview;

import java.math.BigDecimal;

/**
 * @author :马翔宇
 * @description
 * @date: 2023/9/23 13:40
 */
public abstract class Product {
    private int mount;
    private BigDecimal price;
    private String desc;

    public Product(int mount, BigDecimal price, String desc) {
        this.mount = mount;
        this.price = price;
        this.desc = desc;
    }

    public int getMount() {
        return mount;
    }

    public void setMount(int mount) {
        this.mount = mount;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
