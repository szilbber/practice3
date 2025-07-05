package lesson3;

public interface LuxRoomService extends RoomService<LuxRoom> {
    void foodDelivery(Room room);
}