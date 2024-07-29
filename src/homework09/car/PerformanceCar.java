package homework09.car;


import java.util.Arrays;
import java.util.Objects;

public class PerformanceCar extends Car {
    private String[] addOns;

    public PerformanceCar(String brand, String model, int yearOfRelease,
                          int horsePower,
                          int boost, int pendant,
                          int durability) {
        super(brand, model, yearOfRelease,horsePower * 2, boost, pendant / 4, durability);

    }
    public PerformanceCar(){}


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        PerformanceCar car = (PerformanceCar) o;
        return Objects.deepEquals(addOns, car.addOns);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), Arrays.hashCode(addOns));
    }

    @Override
    public String toString() {
        return "PerformanceCar{" +
                "addOns=" + Arrays.toString(addOns) +
                "} " + super.toString();
    }
}
