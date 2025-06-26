package lesson2;
import java.util.Objects;

public class Car2 implements Comparable<Car2> {
    private String vin;
    private String model;
    private String manufacturer;
    private int year;
    private int mileage;
    private double price;
    private CarType type;

    public Car2(String vin, String model, String manufacturer, int year, int mileage, double price, CarType type) {
        this.vin = vin;
        this.model = model;
        this.manufacturer = manufacturer;
        this.year = year;
        this.mileage = mileage;
        this.price = price;
        this.type = type;
    }
    public String getModel() { return model; }
    public String getManufacturer() { return manufacturer; }
    public int getYear() { return year; }
    public int getMileage() { return mileage; }
    public double getPrice() { return price; }
    public CarType getType() { return type; }
    public String getVin() {return vin;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car2 car = (Car2) o;
        return Objects.equals(vin, car.vin);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vin);
    }

    @Override
    public String toString() {
        return String.format("VIN: %s | %s %s (%d) | Пробег: %d км | Цена: %.2f$",
                vin, manufacturer, model, year, mileage, price);
    }

    @Override
    public int compareTo(Car2 o) {
        return Integer.compare(o.year, this.year);
    }

}
