package homework006;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);


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
                currentPerson.setProductsPackage(currentProduct);

                if (j == personsCollection.size() && i == productsCollection.size() && !isEnoughFlag) {
                    isEnoughFlag = true;
                }


            }
        }
        for (Person person : personsCollection) {
            StringBuilder currentPersonsProducts = new StringBuilder();

            for (Product productsPackageItem : person.getProductsPackage()) {
                if (currentPersonsProducts.isEmpty()) {
                    currentPersonsProducts.append(productsPackageItem.getNameProduct());
                } else {
                    currentPersonsProducts.append(", ").append(productsPackageItem.getNameProduct());
                }
            }

            if (Objects.equals(currentPersonsProducts.length(), 0)) {
                System.out.println(person.getName() + " - " + "Ничего не куплено");
            } else {
                System.out.println(person.getName() + " - " + currentPersonsProducts);
            }
        }
        scanner.close();
    }
}
