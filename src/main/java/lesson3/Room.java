package lesson3;
import java.util.Random;
public abstract class Room {

    private int roomNumber;
    private int maxOccupancy;
    private int pricePerNight;
    private boolean isBooked;

    protected Room() {
        this.roomNumber = 0;
        this.maxOccupancy = new Random().nextInt(4) + 1;
        this.pricePerNight = 1000 + new Random().nextInt(5000);
        this.isBooked = false;
    }

    protected Room(int roomNumber, int maxOccupancy, int pricePerNight, boolean isBooked) {
        this.roomNumber = roomNumber;
        this.maxOccupancy = maxOccupancy;
        this.pricePerNight = pricePerNight;
        this.isBooked = isBooked;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public int getMaxOccupancy() {
        return maxOccupancy;
    }

    public void setMaxOccupancy(int maxOccupancy) {
        this.maxOccupancy = maxOccupancy;
    }

    public int getPricePerNight() {
        return pricePerNight;
    }

    public void setPricePerNight(int pricePerNight) {
        this.pricePerNight = pricePerNight;
    }

    public boolean isBooked() {
        return isBooked;
    }

    public void setBooked(boolean booked) {
        isBooked = booked;
    }

    @Override
    public String toString() {
        return "Room{" +
                "roomNumber=" + roomNumber +
                ", maxOccupancy=" + maxOccupancy +
                ", pricePerNight=" + pricePerNight +
                ", isBooked=" + isBooked +
                '}';
    }
}