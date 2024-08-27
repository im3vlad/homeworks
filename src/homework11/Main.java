package homework11;

import java.util.*;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        List<Car> cars = new ArrayList<>();
        System.out.println("Введите список автомобилей в формате НОМЕР_АВТОМОБИЛЯ|МОДЕЛЬ|ЦВЕТ|ПРОБЕГ|ЦЕНА :");
        try(Scanner scanner = new Scanner(System.in)) {
            String newCarString = "START";

            while (!newCarString.isEmpty()){
                newCarString = scanner.nextLine();
                String[] newCarStringParams = newCarString.split("\\|");
                Car newCar = new Car();
                newCar.setCarNumber(newCarStringParams[0]);
                newCar.setModel(newCarStringParams[1]);
                newCar.setColor(newCarStringParams[2]);
                newCar.setMileage(Long.parseLong(newCarStringParams[3]));
                newCar.setCost(Long.parseLong(newCarStringParams[4]));
                System.out.println("");
                System.out.println(newCar);
                cars.add(newCar);
            }
        } catch (RuntimeException exception){
            exception.getClass();
        }

        // 1 Номера всех автомобилей, имеющих заданный в переменной цвет
        //   colorToFind или нулевой пробег mileageToFind.

        String color = "Black";
        Long mileage = 0L;

        Predicate<Car> filterCarNumbersByColorOrMileage = car ->
                car.getColor().equals(color) || Objects.equals(car.getMileage(), mileage);

        // 2 Количество уникальных моделей в ценовом диапазоне от n до m тыс.

        Long startPrice = 700_000L;
        Long endPrice = 800_000L;

        Predicate<Car> filterCarByStartEndPrice = car -> car.getCost() >= startPrice && car.getCost() <= endPrice ;

        // 3  Вывести цвет автомобиля с минимальной стоимостью.
        //    Предикат не нужен

        // 4 Среднюю стоимость искомой модели modelToFind

        String modelToFind = "Toyota";
        String modelToFindTwo = "Volga";

        Predicate<Car> filterCarByModel = car ->
                car.getModel().equals(modelToFind) ;

        Predicate<Car> filterCarByModelTwo = car ->
                car.getModel().equals(modelToFindTwo) ;

        // Streams
        //1 Номера всех автомобилей, имеющих заданный в переменной цвет
        //  colorToFind или нулевой пробег mileageToFind.
        List<String> carNumbers = cars
                .stream()
                .filter(filterCarNumbersByColorOrMileage)
                .map(Car::getCarNumber)
                .toList();
        // System.out.printf("Исходный список автомобилей: %s\n",String.join(", ", cars.toString()));
        System.out.printf("Заданный цвет colorToFind: %s\n", color);
        System.out.printf("Заданный пробег mileageToFind: %d\n", mileage);
        System.out.printf("Номера автомобилей по цвету или пробегу: %s\n", String.join(", ", carNumbers));


        // 2 Количество уникальных моделей в ценовом диапазоне от n до m тыс.
        Long countDistinctCarsByCost = cars
                .stream()
                .filter(filterCarByStartEndPrice)
                .distinct()
                .count();
        //System.out.printf("Исходный список автомобилей: %s\n",String.join(", ", cars.toString()));
        System.out.printf("Заданный диапазон цен:от %d до %d\n", startPrice, endPrice);
        System.out.printf("Количество уникальных моделей в ценовом диапазоне: %d" + " шт.\n", countDistinctCarsByCost);

        //3  Вывести цвет автомобиля с минимальной стоимостью.

        try {
            String carColorWithMinCost = cars
                    .stream()
                    .min(Comparator.comparingLong(Car::getCost))
                    .orElseThrow().getColor();
            //System.out.printf("Исходный список автомобилей: %s\n",String.join(", ", cars.toString()));
            System.out.printf("Цвет автомобиля с минимальной стоимостью: %s\n", carColorWithMinCost);

            // 4 Средняя стоимость искомой модели modelToFind

            OptionalDouble optionalAverageCarPrice = cars
                    .stream()
                    .filter(filterCarByModel)
                    .map(Car::getCost)
                    .mapToDouble(cost -> cost)
                    .average();
            Double averageCarCost = optionalAverageCarPrice.orElseThrow();

            OptionalDouble optionalAverageCarPriceTwo = cars
                    .stream()
                    .filter(filterCarByModelTwo)
                    .map(Car::getCost)
                    .mapToDouble(cost -> cost)
                    .average();
            Double averageCarCostTwo = optionalAverageCarPriceTwo.orElseThrow();

            //System.out.printf("Исходный список автомобилей: %s\n",String.join(", ", cars.toString()));
            System.out.printf("Заданная модель автомобиля: %s\n", modelToFind);
            System.out.printf("Средняя стоимость модели " + modelToFind + ": %.2f\n", averageCarCost);

            System.out.printf("Заданная модель автомобиля: %s\n", modelToFindTwo);
            System.out.printf("Средняя стоимость модели " + modelToFindTwo + ": %.2f\n", averageCarCostTwo);

        }catch (NoSuchElementException exception) {
            System.out.println(exception.getMessage());
        }
    }
}

