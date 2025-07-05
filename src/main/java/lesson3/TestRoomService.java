package lesson3;

public class TestRoomService {
    public static void main(String[] args) {
        RoomService<Room> service = new SimpleRoomService();
        LuxRoomService luxService = new SimpleLuxRoomService();

        Room economyRoom = new EconomyRoom(100, 1, true);
        Room standardRoom = new StandardRoom(101, 2, false);
        LuxRoom luxRoom = new LuxRoom(202, 3, false);
        LuxRoom ultraLuxRoom = new UltraLuxRoom(303, 4, true);

        //EconomyRoom
        try {
            service.reserve(economyRoom);
        } catch (RoomAlreadyBookedException e) {
            System.err.println("Ошибка: " + e.getMessage());
        }
        service.free(economyRoom);
        service.clean(economyRoom);
        service.reserve(economyRoom);

        System.out.println();

        //StandardRoom
        service.clean(standardRoom);
        service.reserve(standardRoom);
        service.free(standardRoom);
        luxService.foodDelivery(standardRoom);



        System.out.println();

        //LuxRoom
        luxService.clean(luxRoom);
        luxService.reserve(luxRoom);
        luxService.free(luxRoom);
        luxService.foodDelivery(luxRoom);
        System.out.println();

        //UltraLuxRoom
        try {
            service.reserve(ultraLuxRoom);
        } catch (RoomAlreadyBookedException e) {
            System.err.println("Ошибка: " + e.getMessage());
        }
        service.free(ultraLuxRoom);
        service.clean(ultraLuxRoom);
        service.reserve(ultraLuxRoom);
    }

}