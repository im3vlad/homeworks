package homeworks08;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class Person {
    private static final int PRODUCT_BAG = 7;
    private String name;
    private double money;

    private Product[] productsPackage = new Product[PRODUCT_BAG];

    public Person() {}

    public Person(String name, double money) {
        this.name = name;
        this.money = money;
    }
    public String getName() {
        return name;
    }

    public double getMoney() {
        return money;
    }

    public Product[] getProductsPackage() {
        return productsPackage;
    }


    public void setName(String name) throws Exception {
        if (Objects.equals(name, "")) {
            throw new Exception("Имя покупателя не может быть пустой строкой");
        }
        this.name = name;

    }

    public void setName(Scanner scanner) throws Exception {
        System.out.println("Введите имя покупателя:");
        String name = scanner.nextLine();

        if (Objects.equals(name, "")) {
            throw new Exception("Имя покупателя не может быть пустой строкой");
        }
        this.name = name;
    }

    public void setMoney(double money) throws Exception {
        if (money < 0) {
            throw new Exception("Деньги не могут быть отрицательным числом");
        }
        this.money = money;
    }

    public void setMoney(Scanner scanner) throws Exception {
        System.out.println("Введите сумму денег, доступную пользователю");
        double money = scanner.nextDouble();

        if (money < 0) {
            throw new Exception("Деньги не могут быть отрицательным числом");
        }
        this.money = money;
    }

    public void setProductsPackage(Product product) throws Exception {
        if (this.money < product.getPrice()) {
            System.out.println(this.name + " не может себе позволить " + product.getNameProduct() );
        } else {
            ArrayList<Product> products = new ArrayList<>(Arrays.asList(productsPackage));
            products.add(product);

            this.productsPackage = products.toArray(productsPackage);
            System.out.println(this.name + " купил/а " + product.getNameProduct());

            this.setMoney(money - product.getPrice());


        }
    }
    public void buyProduct (Product product) {
        if (this.money - product.getPrice() >=0) {
            //products(Product product);
            buyProduct(product);
            System.out.println(name + " купил/а "+ product.getNameProduct());
        } else {
            System.out.println(name + " не может себе позволить " + product.getNameProduct());
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Double.compare(getMoney(), person.getMoney()) == 0 && Objects.equals(getName(), person.getName()) && Arrays.equals(getProductsPackage(), person.getProductsPackage());
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(getName(), getMoney());
        result = 31 * result + Arrays.hashCode(getProductsPackage());
        return result;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", money=" + money +
                ", productsPackage=" + Arrays.toString(productsPackage) +
                '}';
    }
}
