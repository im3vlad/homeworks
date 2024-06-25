package homework05;

import java.util.Objects;

public class Televisions {
    private String brand;
    private String model;
    private String color;
    private Integer numberChannel;
    private Integer volume;
    private boolean toggle;

    public Televisions() {
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.numberChannel = numberChannel;
        this.volume = volume;
        this.toggle = toggle;
    }

    @Override
    public String toString() {
        return "Televisions{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", color='" + color + '\'' +
                ", numberChannel=" + numberChannel +
                ", volume=" + volume +
                ", toggle=" + toggle +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Televisions that = (Televisions) o;
        return toggle == that.toggle && Objects.equals(brand, that.brand) && Objects.equals(model, that.model) && Objects.equals(color, that.color) && Objects.equals(numberChannel, that.numberChannel) && Objects.equals(volume, that.volume);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, model, color, numberChannel, volume, toggle);
    }

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

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getNumberChannel() {
        return numberChannel;
    }

    public void setNumberChannel(Integer numberChannel) {
        this.numberChannel = numberChannel;
    }

    public Integer getVolume() {
        return volume;
    }

    public void setVolume(Integer volume) {
        this.volume = volume;
    }

    public boolean isToggle() {
        return toggle;
    }

    public void setToggle(boolean toggle) {
        this.toggle = toggle;
    }
}
