package homework09.race;

import java.util.List;
import java.util.Objects;

public class Race {
    private int length;
    private String route;
    private int thePrizeFund;
    private List<String> cars;
    public Race(int length, String route, int thePrizeFund) {
        this.length = length;
        this.route = route;
        this.thePrizeFund = thePrizeFund;

    }
    public Race(){}

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public int getThePrizeFund() {
        return thePrizeFund;
    }

    public void setThePrizeFund(int thePrizeFund) {
        this.thePrizeFund = thePrizeFund;
    }

    public List<String> getCars() {
        return cars;
    }

    public void setCars(List<String> cars) {
        this.cars = cars;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Race race = (Race) o;
        return length == race.length && thePrizeFund == race.thePrizeFund && Objects.equals(route, race.route) && Objects.equals(cars, race.cars);
    }

    @Override
    public int hashCode() {
        return Objects.hash(length, route, thePrizeFund, cars);
    }

    @Override
    public String toString() {
        return "Race{" +
                "route='" + route + '\'' +
                ", length=" + length +
                ", thePrizeFund=" + thePrizeFund +
                '}';
    }
}
