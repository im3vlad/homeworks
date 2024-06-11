package homework3;

import java.util.Scanner;

public class TV {
    private String brand;
    private String model;
    private String color;

    public TV() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите бренд: ");
        this.brand = sc.nextLine();
        System.out.print("Введите модель: ");
        this.model = sc.nextLine();
        System.out.print("Введите цвет: ");
        this.color = sc.nextLine();
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
