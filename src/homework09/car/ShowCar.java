package homework09.car;


import java.util.Objects;

public class ShowCar extends Car{
    private int stars;
    public ShowCar(String brand, String model, int yearOfRelease,
                   int horsePower,
                   int boost, int pendant,
                   int durability){
        super(brand, model, yearOfRelease, horsePower, boost, pendant, durability);
        this.stars = 0;
    }
    public ShowCar(){}

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ShowCar showCar = (ShowCar) o;
        return stars == showCar.stars;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), stars);
    }

    @Override
    public String toString() {
        return "ShowCar{} " + super.toString();
    }
}

