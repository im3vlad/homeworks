package homework05;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Televisions tv0 = new Televisions();
        Televisions tv1= new Televisions();
        Televisions tv2 = new Televisions();
        Televisions tv3 = new Televisions();
        Televisions tv4 = new Televisions();
        Televisions tv5 = new Televisions();
        Televisions tv6 = new Televisions();
        Televisions tv7 = new Televisions();
        Televisions tv8 = new Televisions();
        Televisions tv9 = new Televisions();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Допустимая громкость(50-70): ");
        int maxVolume = scanner.nextInt();

    System.out.println("Введите бренд: ");
    tv0.setBrand(scanner.nextLine());
    System.out.print("Введите модель: ");
    tv0.setModel(scanner.nextLine());
    System.out.print("Введите цвет: ");
    tv0.setColor(scanner.nextLine());
    tv0.setToggle(true);
        System.out.print("Введите громкость: ");
    tv0.setVolume(scanner.nextInt());
        System.out.print("Введите канал: ");
    tv0.setNumberChannel(scanner.nextInt());

        Televisions [] tvs = new Televisions[10];
        for (int i = 0; i< tvs.length; i++){
        }

        System.out.println("Ваш телевизор: " + tv0);
    }
}
