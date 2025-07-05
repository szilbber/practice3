package lesson3;

public class UltraLuxRoom extends LuxRoom {

    public UltraLuxRoom() {
        super();
    }

    protected UltraLuxRoom(int roomNumber, int maxOccupancy, boolean isBooked) {
        super(roomNumber, maxOccupancy, Prices.ULTRA_LUX_PRICE.getPrice(), isBooked);
    }

}