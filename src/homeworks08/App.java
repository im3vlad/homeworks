package homeworks08;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get("C:\\Users\\Anastas\\Desktop\\magazine.txt"));
        for (String stroka : lines) {
            System.out.println(stroka);
        }

        try (var objectOutputStream = new OutputStreamWriter(new FileOutputStream("file_output.txt", false), StandardCharsets.UTF_8);
             Scanner scanner = new Scanner(System.in)) {
            Person pavelAndreevich = new Person("Павел Андреевич", 10000);
            Person annaPetrovna = new Person("Анна Петровна", 2000);
            Person boris = new Person("Борис", 10);
            Person zhenya = new Person("Женя", 0);
            Person sveta = new Person("Света", -3);


            Product bread = new Product("Хлеб", 40);
            Product milk = new Product("Молоко", 60);
            Product cake = new Product("Торт", 1000);
            Product coffee = new Product("Кофе растворимый", 879);
            Product oil = new Product("Масло", 150);
            Product iceCream = new Product("Мороженное", 200);
            Product pasta = new Product("Макароны", 800);


            List<Person> personsCollection = Arrays.asList(pavelAndreevich, annaPetrovna, boris, zhenya, sveta);
            List<Product> productsCollection = Arrays.asList(bread, milk, cake, coffee, oil, iceCream, pasta);

            boolean isEnoughFlag = false;
            var fileString = new StringBuilder();
            for (int i = 0; i < productsCollection.size(); i++) {
                if (isEnoughFlag) break;

                for (int j = 0; j < personsCollection.size(); j++) {
                    System.out.println(" Если Вы желаете прервать наполнение продуктовой корзины введите " + "END" + "\n" +
                            " Для продолжения программы нажмите Enter");
                    String deprivateCommand = scanner.nextLine();

                    if (Objects.equals(deprivateCommand.trim(), "END")) {
                        isEnoughFlag = true;
                        break;
                    }

                    Person currentPerson = personsCollection.get(j);
                    Product currentProduct = productsCollection.get(i);
                    var stringToAppend = currentPerson.setProductsPackage(currentProduct);
                    fileString.append(stringToAppend).append("\n");

                    if (j == personsCollection.size() && i == productsCollection.size() && !isEnoughFlag) {
                        isEnoughFlag = true;
                    }


                }
            }


            objectOutputStream.write(fileString.toString());
        } catch (Exception e) {
            System.out.println("ОШИБКА: Не удалось сохранить информацию в файл");
        }

    }
}

