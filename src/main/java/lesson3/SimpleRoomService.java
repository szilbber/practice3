package lesson3;

public class SimpleRoomService implements RoomService<Room> {
    @Override
    public void clean(Room room) {
        System.out.println("Комната " + room.getRoomNumber() + " убрана.");
    }

    @Override
    public void reserve(Room room) {
        if (room.isBooked()) {
            throw new RoomAlreadyBookedException("Невозможно забронировать комнату №" + room.getRoomNumber() + ". Она уже занята.");
        }
        room.setBooked(true);
        System.out.println("Комната " + room.getRoomNumber() + " успешно забронирована.");
    }

    @Override
    public void free(Room room) {
        room.setBooked(false);
        System.out.println("Комната " + room.getRoomNumber() + " освобождена.");
    }
}