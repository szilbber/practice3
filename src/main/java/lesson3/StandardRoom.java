package lesson3;

public class StandardRoom extends ProRoom {
    public StandardRoom() {
        super();
    }
    protected StandardRoom(int roomNumber, int maxOccupancy, boolean isBooked) {
        super(roomNumber, maxOccupancy, Prices.STANDARD_PRICE.getPrice(), isBooked);
    }

}