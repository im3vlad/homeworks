package homework03;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Television tv = new Television();
        System.out.print("Введите бренд: ");
        tv.setBrand(sc.nextLine());
        System.out.print("Введите модель: ");
        tv.setModel(sc.nextLine());
        System.out.print("Введите цвет: ");
        tv.setColor(sc.nextLine());

        System.out.println("Ваш телевизор: " + tv);
        Television tv1 = new Television();
        System.out.print("Введите бренд: ");
        tv1.setBrand(sc.nextLine());
        System.out.print("Введите модель: ");
        tv1.setModel(sc.nextLine());
        System.out.print("Введите цвет: ");
        tv1.setColor(sc.nextLine());
        System.out.println("Ваш телевизор: " + tv1);







    }
}
