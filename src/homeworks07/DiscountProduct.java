package homeworks07;

import java.util.Objects;

public class DiscountProduct extends  Product{
    private double discount;
    public DiscountProduct(String name, int price, int discount) {
        super(name, price);
        this.discount = price - discount;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        DiscountProduct that = (DiscountProduct) o;
        return discount == that.discount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), discount);
    }

    @Override
    public String toString() {
        return "Продукт со скидкой: "+ discount ;
    }
}
