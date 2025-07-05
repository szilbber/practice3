package lesson3;

public abstract class ProRoom extends Room {

    protected ProRoom() {
        super();
    }
    protected ProRoom(int roomNumber, int maxOccupancy, int pricePerNight, boolean isBooked) {
        super(roomNumber, maxOccupancy, pricePerNight, isBooked);
    }

}