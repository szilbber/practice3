package lesson3;

public class RoomAlreadyBookedException extends RuntimeException {
    public RoomAlreadyBookedException() {
        super("Комната уже забронирована.");
    }

    public RoomAlreadyBookedException(String message) {
        super(message);
    }
}