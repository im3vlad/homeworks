package homework09;

import homework09.car.Car;
import homework09.car.PerformanceCar;
import homework09.car.ShowCar;
import homework09.race.DriftRace;
import homework09.race.Race;

public class Main {
    public static void main(String[] args) {
        PerformanceCar car = new PerformanceCar("Ferari", "M1", 5, 100,75, 100, 5);
        ShowCar cr = new ShowCar("Ford", "M5", 5, 100,75, 100, 5);
        Race race = new Race(25, "erw", 45);
        System.out.println(car + "\n" + cr + "\n" + race);
    }
}
