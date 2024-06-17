package homework03;

public class Television {
    private String brand;
    private String model;
    private String color;

    public Television() {
        this.brand = brand;
        this.model = model;
        this.color = color;
    }
    public String toString (){
        return "Бренд:" + brand + ".Модель:" + model + ".Цвет:" + color + ".";
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public String getColor() {
        return color;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
