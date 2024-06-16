package homework05;

public class Televisions {
    private String brand;
    private String model;
    private String color;
    private Integer numberChannel;
    private Integer volume;
    private boolean toggle;

    public Televisions(String brand, String model, String color, Integer numberChannel, Integer volume, boolean toggle) {
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.numberChannel = numberChannel;
        this.volume = volume;
        this.toggle = toggle;
    }

    public Televisions() {
        this.brand = getBrand();
    }


    public String toString () {return brand + model + color + numberChannel + volume + toggle; }

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
