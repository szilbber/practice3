package lesson3;

public class LuxRoom extends ProRoom {

    public LuxRoom() {
        super();
    }
    public LuxRoom(int roomNumber, int maxOccupancy, boolean isBooked) {
        super(roomNumber, maxOccupancy, Prices.LUX_PRICE.getPrice(), isBooked);
    }
    public LuxRoom(int roomNumber, int maxOccupancy,int price,  boolean isBooked) {
        super(roomNumber, maxOccupancy, price, isBooked);
    }
}