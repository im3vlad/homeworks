package homeworks08;

import homeworks07.DiscountProduct;
import homeworks07.Person;
import homeworks07.Product;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        homeworks07.Person pavelAndreevich = new homeworks07.Person("Павел Андреевич", 10000);
        homeworks07.Person annaPetrovna = new homeworks07.Person("Анна Петровна", 2000);
        homeworks07.Person boris = new homeworks07.Person("Борис", 10);
        homeworks07.Person zhenya = new homeworks07.Person("Женя", 0);
        homeworks07.Person sveta = new homeworks07.Person("Света", -3);


        homeworks07.Product bread = new homeworks07.Product("Обычный продукт:Хлеб", 40);
        homeworks07.Product milk = new homeworks07.Product("Обычный продукт:Молоко", 60);
        homeworks07.Product cake = new homeworks07.Product("Обычный продукт:Торт", 1000);
        homeworks07.Product coffee = new homeworks07.Product("Обычный продукт:Кофе растворимый", 879);
        homeworks07.Product oil = new homeworks07.Product("Обычный продукт:Масло", 150);
        homeworks07.Product iceCream = new homeworks07.Product("Обычный продукт:Мороженное", 200);
        homeworks07.Product pasta = new homeworks07.Product("Обычный продукт:Макароны", 800);

        homeworks07.DiscountProduct beer = new homeworks07.DiscountProduct("Акционный продукт:Пиво", 250, 38);
        homeworks07.DiscountProduct pizza = new homeworks07.DiscountProduct("Акционный продукт:Пицца", 700, 101);
        homeworks07.DiscountProduct waffles = new homeworks07.DiscountProduct("Акционный продукт:Вафли", 100, 49);
        homeworks07.DiscountProduct hookah = new homeworks07.DiscountProduct("Акционный продукт:Кальян", 1800, 1050);
        homeworks07.DiscountProduct carhart = new homeworks07.DiscountProduct("Акционный продукт:КАРХАРТ КОРОЛЯ", 99999, 99998);

        List<homeworks07.Person> personsCollection = Arrays.asList(pavelAndreevich, annaPetrovna, boris, zhenya, sveta);
        List<homeworks07.Product> productsCollection = Arrays.asList(bread, milk, cake, coffee, oil, iceCream, pasta);
        List<homeworks07.DiscountProduct> discountProductsCollection = Arrays.asList(beer, pizza, waffles, hookah, carhart);

        boolean isEnoughFlag = false;

        for (int i = 0; i < productsCollection.size(); i++) {
            if (isEnoughFlag) break;
            for (int k = 0; k < discountProductsCollection.size(); k++) {
                if (isEnoughFlag) break;

                for (int j = 0; j < personsCollection.size(); j++) {
                    System.out.println(" Если Вы желаете прервать наполнение продуктовой корзины введите " + "END" + "\n" +
                            " Для продолжения программы нажмите Enter");
                    String deprivateCommand = scanner.nextLine();

                    if (Objects.equals(deprivateCommand.trim(), "END")) {
                        isEnoughFlag = true;
                        break;
                    }

                    homeworks07.Person currentPerson = personsCollection.get(j);
                    homeworks07.Product currentProduct = productsCollection.get(i);
                    DiscountProduct currentDiscountProduct = discountProductsCollection.get(k);
                    currentPerson.setProductsPackage(currentProduct);
                    currentPerson.setProductsPackage(currentDiscountProduct);

                    if (j == personsCollection.size() && i == productsCollection.size() && !isEnoughFlag) {
                        isEnoughFlag = true;
                    }


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

