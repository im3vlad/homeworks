package homeworks08;


import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        Person pavelAndreevich = new Person("Павел Андреевич", 10000);
        Person annaPetrovna = new Person("Анна Петровна", 2000);
        Person boris = new Person("Борис", 10);
        Person zhenya = new Person("Женя", 0);
        Person sveta = new Person("Света", -3);


        Product bread = new Product("Обычный продукт:Хлеб", 40);
        Product milk = new Product("Обычный продукт:Молоко", 60);
        Product cake = new Product("Обычный продукт:Торт", 1000);
        Product coffee = new Product("Обычный продукт:Кофе растворимый", 879);
        Product oil = new Product("Обычный продукт:Масло", 150);
        Product iceCream = new Product("Обычный продукт:Мороженное", 200);
       Product pasta = new Product("Обычный продукт:Макароны", 800);

        DiscountProduct beer = new DiscountProduct("Акционный продукт:Пиво", 250, 38);
        DiscountProduct pizza = new DiscountProduct("Акционный продукт:Пицца", 700, 101);
        DiscountProduct waffles = new DiscountProduct("Акционный продукт:Вафли", 100, 49);
        DiscountProduct hookah = new DiscountProduct("Акционный продукт:Кальян", 1800, 1050);
        DiscountProduct carhart = new DiscountProduct("Акционный продукт:КАРХАРТ КОРОЛЯ", 99999, 99998);

        List<Person> personsCollection = Arrays.asList(pavelAndreevich, annaPetrovna, boris, zhenya, sveta);
        List<Product> productsCollection = Arrays.asList(bread, milk, cake, coffee, oil, iceCream, pasta);
        List<DiscountProduct> discountProductsCollection = Arrays.asList(beer, pizza, waffles, hookah, carhart);

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

                    Person currentPerson = personsCollection.get(j);
                    Product currentProduct = productsCollection.get(i);
                    DiscountProduct currentDiscountProduct = discountProductsCollection.get(k);
                    try {
                        currentPerson.setProductsPackage(currentProduct);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                    try {
                        currentPerson.setProductsPackage(currentDiscountProduct);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }


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

