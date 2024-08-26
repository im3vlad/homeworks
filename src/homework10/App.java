package homework10;

import java.util.Arrays;
import java.util.Scanner;

public class App {
    public static void main(String[] args){
        int[] numbers = {11, 4, 3, 77, 23, 13, 5, 64, 30};



        ByCondition conditionOne = number -> number % 2 == 0 && number != 0;
        ByCondition conditionTwo = number -> number % 3 == 0 && number != 0;
        ByCondition conditionThree = number -> {
            int summa = 0;
            while (number != 0){
                int lastDigit = number % 10;
                summa += lastDigit;
                number = number / 10;
            }
            return summa % 2 == 0 && summa != 0;
        };

        System.out.println("Четные элементы массива:" + Arrays.toString(Sequence.filter(numbers, conditionOne)));
        System.out.println("Числа массива, которые делятся на три:" + Arrays.toString(Sequence.filter(numbers, conditionTwo)));
        System.out.println("Элементы массива, сумма цифр которых является четным числом:" + Arrays.toString(Sequence.filter(numbers, conditionThree)));

        try(Scanner scanner = new Scanner(System.in)){
            System.out.println("Введите новый массив чисел через запятую: ");

            String newNumbersAsSrting = scanner.nextLine();
            String[] newNumbersAsSrtingList = newNumbersAsSrting.split(",\\s+");
            int[] numbersFromConsole = new int[newNumbersAsSrtingList.length];
            for(int position = 0; position < newNumbersAsSrtingList.length; position++){
                numbersFromConsole[position] = Integer.parseInt(newNumbersAsSrtingList[position]);
            }

            System.out.println("Четные элементы массива:" + Arrays.toString(Sequence.filter(numbersFromConsole, conditionOne)));
            System.out.println("Числа массива, которые делятся на три:" + Arrays.toString(Sequence.filter(numbersFromConsole, conditionTwo)));
            System.out.println("Элементы массива, сумма цифр которых является четным числом:" + Arrays.toString(Sequence.filter(numbersFromConsole, conditionThree)));
        } catch (NumberFormatException exception) {
            throw new RuntimeException("Входные данные должны быть числом");
        }

    }
    }


