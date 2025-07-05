package lesson3;

public class EconomyRoom extends Room {

    protected EconomyRoom() {
        super();
    }
    protected EconomyRoom(int roomNumber, int maxOccupancy, boolean isBooked) {
        super(roomNumber, maxOccupancy, Prices.ECONOMY_PRICE.getPrice(), isBooked);
    }

}