package homework06;

import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        //создаем два массива
        Person[] persons = new Person[3];
        Product[] products = new Product[4];
        /*Scanner scanner = new Scanner(System.in);
        String condition = scanner.nextLine();*/
        //захолим в массив персон
        for (int i = 0; i < persons.length; i++) {
            persons[i] = new Person();
            Person person = persons[i];
            int balance;//создаем примитив баланс
            for (int p = 0; p < products.length; p++) {
                products[p] = new Product();
                Product product = products[p];
                //заходим в массив продуктов
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
//заполняем массив персон с помощью класса утилс
        Utils utils = new Utils();
        for (int i = 0; i < persons.length; i++) {
            persons[i] = utils.createPerson();
        }
        //заполняеем массив продуктов с помощью класса утилс
        for (int i = 0; i < products.length; i++) {
            products[i] = utils.createProduct();
        }
    }
    }

