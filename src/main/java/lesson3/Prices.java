package lesson3;

public enum Prices {
    ECONOMY_PRICE(1000),
    STANDARD_PRICE(2000),
    LUX_PRICE(5000),
    ULTRA_LUX_PRICE(10000);

    private final int price;

    Prices(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
}