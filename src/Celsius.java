import java.util.Scanner;

public class Celsius {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double fahrenheit = in.nextDouble();

        double celsius = (fahrenheit - 32.0) * 5.0 / 9;
        System.out.println(fahrenheit + " градусов по Фаренгейту равна " + celsius + " по Цельсию.");


    }
}