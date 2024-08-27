package homework11;

import java.util.Objects;

public class Car {
    private String carNumber;
    private String model;
    private String color;
    private Long mileage;
    private Long cost;
    public Car() {

    }


    public Car(String carNumber, String model, String color, Long mileage, Long cost) {
        this.carNumber = carNumber;
        this.model = model;
        this.color = color;
        this.mileage = mileage;
        this.cost = cost;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Long getMileage() {
        return mileage;
    }

    public void setMileage(Long mileage) {
        this.mileage = mileage;
    }

    public Long getCost() {
        return cost;
    }

    public void setCost(Long cost) {
        this.cost = cost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(getCarNumber(), car.getCarNumber()) && Objects.equals(getModel(), car.getModel()) && Objects.equals(getColor(), car.getColor()) && Objects.equals(getMileage(), car.getMileage()) && Objects.equals(getCost(), car.getCost());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCarNumber(), getModel(), getColor(), getMileage(), getCost());
    }

    @Override
    public String toString() {
        return "Car{" +
                "carNumber='" + carNumber + '\'' +
                ", model='" + model + '\'' +
                ", color='" + color + '\'' +
                ", mileage=" + mileage +
                ", cost=" + cost +
                '}';
    }
}
