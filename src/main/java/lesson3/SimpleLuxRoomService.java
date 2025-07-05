package lesson3;

public class SimpleLuxRoomService implements LuxRoomService {

    @Override
    public void clean(LuxRoom room) {
        System.out.println("Комната " + room.getRoomNumber() + " убрана.");
    }

    @Override
    public void reserve(LuxRoom room) {
        if (room.isBooked()) {
            throw new RoomAlreadyBookedException("Комната №" + room.getRoomNumber() + " уже забронирована.");
        }
        room.setBooked(true);
        System.out.println("Комната " + room.getRoomNumber() + " забронирована.");
    }

    @Override
    public void free(LuxRoom room) {
        room.setBooked(false);
        System.out.println("Комната " + room.getRoomNumber() + " освобождена.");
    }

    @Override
    public void foodDelivery(Room room) {
        if (room == null) {
            System.out.println("Ошибка: комната не указана.");
            return;
        }

        if (!(room instanceof LuxRoom)) {
            System.out.println("Ошибка: доставка еды доступна только в люксовые комнаты.");
            return;
        }

        System.out.println("Доставка еды в комнату №" + room.getRoomNumber() + ". Приятного аппетита!");
    }
}