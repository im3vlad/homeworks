package homework06;

import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        //создаем два массива
        Person[] persons = new Person[3];
        Product[] products = new Product[4];
        Utils utils = new Utils();
//заполняем массив персон с помощью класса утилс
        for (int i = 0; i < persons.length; i++) {
            persons[i] = utils.createPerson();

        }
        //заполняеем массив продуктов с помощью класса утилс
        for (int i = 0; i < products.length; i++) {
            products[i] = utils.createProduct();
        }
//
        for (int i = 0; i < persons.length; i++) {
            Person person = persons[i];//захолим в массив персон
            int balance;//создаем примитив баланс
            for (int p = 0; p < products.length; p++) {
                Product product = products[p];//заходим в массив продуктов
                balance = person.getSumMoney() - product.getPrice();//покупка продукта
                if (balance > 0) {//условие
                    person.packageProduct[p] = product;//заполняем пакет
                    person.setSumMoney(balance);
                } else {//если меньше 0 не может позволить
                    System.out.println(person.getName() + " не может позволить себе продукт: " + product.getName());
                }
            }
            System.out.println(person.getName() + " купил " + Arrays.toString(person.packageProduct));
        }
    }
}
