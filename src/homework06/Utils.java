package homework06;

import java.util.Scanner;

public class Utils {
    //сканер и условия для строки персона,суммы денег
    public Person createPerson() {
        Scanner sc = new Scanner(System.in);
        Person person = new Person();
        System.out.println("Введите имя покупателя: ");
        String name = sc.nextLine();
        if (name.isEmpty() && name.isBlank()) {
            System.out.println("Имя не может быть пустым");
            return null;
        }
        person.setName(name);
        System.out.println("Введите сумму денег покупателя: ");
        int sumMoney = sc.nextInt();
        if (sumMoney < 0) {
            System.out.println("Деньги не могут быть отрицательными: ");
            return null;
        }
        person.setSumMoney(sumMoney);
        return person;
    }
//сканер и условия для продукта
    public Product createProduct() {
        Scanner sc = new Scanner(System.in);
        Product product = new Product();
        System.out.println("Введите название продукта: ");
        String productName = sc.nextLine();
        if (productName.isEmpty() && productName.isBlank()){
            System.out.println("Название не может быть пустым: ");
            return null;
        }
        product.setName(productName);
        System.out.println("Введите стоимость продукта: ");
        int price = sc.nextInt();

        if (price < 0){
            System.out.println("Сумма не может быть отрицательной: ");
            return null;
        }
        product.setPrice(price);
        return product;
    }
}
