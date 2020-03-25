package pl.wsb.students.model;

public class Car extends Vehicle {
    private static final int PRICE = 10;

    @Override
    public int getPrice() {
        return PRICE;
    }

    public Car(String brand, String model, int horsePower) {
        super(brand, model, horsePower);
    }
}
