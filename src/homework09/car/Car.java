package homework09.car;

import java.util.Objects;

public class Car {
    private String brand;
    private  String model;
    private int yearOfRelease;
    private int power;
    private int boost;
    private int pendant;
    private int durability;

    public Car(){//пустой конструктор
    }
    public Car(String brand,String model, int yearOfRelease, int power, int boost, int pendant, int durability) {
        this.brand = brand;
        this.model = model;
        this.yearOfRelease = yearOfRelease;
        this.power = power;
        this.boost = boost;
        this.pendant = pendant;
        this.durability = durability;
    } //конструктор с параметрами

    //гетеры и сетеры
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYearOfRelease() {
        return yearOfRelease;
    }

    public void setYearOfRelease(int yearOfRelease) {
        this.yearOfRelease = yearOfRelease;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getBoost() {
        return boost;
    }

    public void setBoost(int boost) {
        this.boost = boost;
    }

    public int getPendant() {
        return pendant;
    }

    public void setPendant(int pendant) {
        this.pendant = pendant;
    }

    public int getDurability() {
        return durability;
    }

    public void setDurability(int durability) {
        this.durability = durability;
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", yearOfRelease=" + yearOfRelease +
                ", power=" + power +
                ", boost=" + boost +
                ", pendant=" + pendant +
                ", durability=" + durability +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return yearOfRelease == car.yearOfRelease && power == car.power && boost == car.boost && pendant == car.pendant && durability == car.durability && Objects.equals(brand, car.brand) && Objects.equals(model, car.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, model, yearOfRelease, power, boost, pendant, durability);
    }
}


