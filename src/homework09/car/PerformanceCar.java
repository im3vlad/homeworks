package homework09.car;

import java.util.Arrays;
import java.util.Objects;

public class PerformanceCar extends Car{
    String[] addOns;
    double t = (getHorsePower() * 100) / 500;
    double horsePowerPerformaceCar = getHorsePower() + t ;
    double k = (getHorsePower() * 100) / 500;
    double pendantPerformanceCar = getPendant() - k;

    public PerformanceCar(double horsePowerPerformaceCar, double pendantPerformanceCar) {
        this.horsePowerPerformaceCar = horsePowerPerformaceCar;
        this.pendantPerformanceCar = pendantPerformanceCar;
        this.addOns = addOns;
    }

    public String[] getAddOns() {
        return addOns;
    }

    public void setAddOns(String[] addOns) {
        this.addOns = addOns;
    }

    public double getHorsePowerPerformaceCar() {
        return horsePowerPerformaceCar;
    }

    public void setHorsePowerPerformaceCar(double horsePowerPerformaceCar) {
        this.horsePowerPerformaceCar = horsePowerPerformaceCar;
    }

    public double getPendantPerformanceCar() {
        return pendantPerformanceCar;
    }

    public void setPendantPerformanceCar(double pendantPerformanceCar) {
        this.pendantPerformanceCar = pendantPerformanceCar;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        PerformanceCar that = (PerformanceCar) o;
        return Double.compare(horsePowerPerformaceCar, that.horsePowerPerformaceCar) == 0 && Double.compare(pendantPerformanceCar, that.pendantPerformanceCar) == 0 && Objects.deepEquals(addOns, that.addOns);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), Arrays.hashCode(addOns), horsePowerPerformaceCar, pendantPerformanceCar);
    }

    @Override
    public String toString() {
        return "PerformanceCar{" +
                "pendantPerformanceCar=" + pendantPerformanceCar +
                ", addOns=" + Arrays.toString(addOns) +
                ", horsePowerPerformaceCar=" + horsePowerPerformaceCar +
                '}';
    }
}
