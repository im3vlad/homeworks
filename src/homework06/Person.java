package homework06;

import java.util.Objects;

public class Person {
    private String name;
    private int sumMoney;
    Product[] packageProduct = new Product[3];//пакет продуктов(массив)

    /*public Person(String name, int sumMoney) {
        this.name = name;
        this.sumMoney = sumMoney;
    }*/

    @Override
    public String toString() {
        return "Имя: " + name + " Сумма денег: " + sumMoney;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, sumMoney);
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
}
