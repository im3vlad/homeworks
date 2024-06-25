package homework06;

import java.util.Objects;

public class Person {
    String name;
    int sumMoney;
    String packageProduct;

    public Person(String name, int sumMoney, String packageProduct) {
        this.name = name;
        this.sumMoney = sumMoney;
        this.packageProduct = packageProduct;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return sumMoney == person.sumMoney && Objects.equals(name, person.name) && Objects.equals(packageProduct, person.packageProduct);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, sumMoney, packageProduct);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSumMoney() {
        return sumMoney;
    }

    public void setSumMoney(int sumMoney) {
        this.sumMoney = sumMoney;
    }

    public String getPackageProduct() {
        return packageProduct;
    }

    public void setPackageProduct(String packageProduct) {
        this.packageProduct = packageProduct;
    }
}
