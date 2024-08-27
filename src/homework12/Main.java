package homework12;

import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.zip.DataFormatException;

public class Main {
    public static void main(String[] args) {
        DateFormat dateOfBirthday = new SimpleDateFormat("dd.MM.yyyy");
        System.out.println("Введите количество человек для записи в файл: ");
        try {
            Scanner scanner = new Scanner(System.in);
            int count = scanner.nextInt();
            int i = 0;
            List<Person> personList = new ArrayList<>();
            while (i < count) {
                System.out.println("\nВведите данные, разделенные пробелом: Фамилия Имя Отчество дата рождения(в формате dd.mm.yyyy) номер телефона(11 цифр) пол(m или f) возраст(от 0 до 100)");
                Scanner scannerPerson = new Scanner(System.in);
                String personInfo = scannerPerson.nextLine();
                String[] inputString = personInfo.split("\\s+");
                try {
                    Person newPerson = new Person();
                    newPerson.setLastName(inputString[0]);
                    newPerson.setName(inputString[1]);
                    newPerson.setPatromynic(inputString[2]);
                    newPerson.setDateOfBirthday(dateOfBirthday.parse(inputString[3]));
                    if (!Pattern.matches("[0-9]+", inputString[4])) {
                        throw new NumberFormatException("Номер должен состоять из цифр!");
                    }
                    newPerson.setNumberPhone(Long.parseLong(inputString[4]));
                    newPerson.setSex(inputString[5]);
                    newPerson.setAge(Integer.parseInt(inputString[6]));
                    personList.add(newPerson);
                } catch (RuntimeException | ParseException | DataFormatException e) {
                    System.out.println("Неправильные данные, необходимо ввести 7 параметров");
                    System.out.println(e.getMessage());
                    scanner.nextLine();

                } finally {
                    i++;
                }



                try {
                    FileWriter writer = new FileWriter("persons.txt");
                    for(Person printPerson: personList) {
                        writer.write(printPerson + System.lineSeparator());
                        System.out.println(printPerson);
                    }
                    writer.close();


                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

        }
        catch (InputMismatchException e) {
            System.out.println("Ошибка ввода. Введите цифру");

        }
    }
}
