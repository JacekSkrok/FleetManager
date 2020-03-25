package pl.wsb.students.model;

public class Motor extends Vehicle {
    private static final int PRICE = 8;

    @Override
    public int getPrice() {
        return PRICE;
    }

    public Motor(String brand, String model, int horsePower) {
        super(brand, model, horsePower);
    }
}
