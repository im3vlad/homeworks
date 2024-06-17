package homework02;

import java.util.Scanner;


public class Actions {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите числа:");
        int a  = in.nextInt();
        int b  = in.nextInt();
        System.out.println("Сумма двух целых чисел: " + (a + b));
        System.out.println("Разница двух целых чисел: " + (a - b));
        System.out.println("Произведение из двух целых чисел: " + (a * b));
        System.out.println("Среднее из двух целых чисел: " + ((a + b) / 2));
        if (a > b){
            System.out.println("Расстояние двух целых чисел: " + Math.abs(a-b));
        }else if (a < b){
            System.out.println("Расстояние двух целых чисел: " + Math.abs(b-a));}
        System.out.println("Максимальное целое число: " + Math.max(a, b));
        System.out.println("Минимальное целое число: " + Math.min(a, b));










    }
}
