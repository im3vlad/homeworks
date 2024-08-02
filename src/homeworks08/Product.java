package homeworks08;

import java.util.Objects;
import java.util.Scanner;

public class Product {
    private String nameProduct;
    private double price;

    public Product() {

    }

    public Product (String nameProduct, double price) {
        this.nameProduct = nameProduct;
        this.price = price;
    }

    public String getNameProduct() {
        return nameProduct;
    }
    public double getPrice() {
        return price;
    }


    public void setNameProduct(String nameProduct) throws Exception {
        if (Objects.equals(nameProduct, "")) {
            throw new Exception("Наименование продукта не может быть пустой строкой");
        }
        this.nameProduct = nameProduct;
    }

    public void setNameProduct(Scanner scanner) throws Exception {
        System.out.println("Введите наименование продукта");
        String nameProduct = scanner.nextLine();

        if (Objects.equals(nameProduct, "")) {
            throw new Exception("Наименование продукта не может быть пустой строкой");
        }
    }


    public void setPrice(double price) throws Exception {

        if (price < 0) {
            throw new Exception("Стоимость продукта не может быть отрицательным числом");
        }
        this.price = price;
    }

    public  void setPrice(Scanner scanner) throws Exception{
        System.out.println("Введите стоимость продукта: ");
        double money = scanner.nextDouble();

        if (money < 0 ) {
            throw new Exception("Стоимость продукта не может быть отрицательным числом");
        }
        this.price = money;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Double.compare(getPrice(), product.getPrice()) == 0 && Objects.equals(getNameProduct(), product.getNameProduct());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNameProduct(), getPrice());
    }

    @Override
    public String toString() {
        return "Product{" +
                "nameProduct='" + nameProduct + '\'' +
                ", price=" + price +
                '}';
    }
}
