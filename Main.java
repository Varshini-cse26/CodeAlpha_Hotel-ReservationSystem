import java.util.*;

class Room {
    int roomNumber;
    String category;
    boolean isAvailable;

    public Room(int roomNumber, String category) {
        this.roomNumber = roomNumber;
        this.category = category;
        this.isAvailable = true;
    }
}

class HotelReservationSystem {
    private List<Room> rooms = new ArrayList<>();

    // Add a room
    public void addRoom(int roomNumber, String category) {
        rooms.add(new Room(roomNumber, category));
    }

    // Search for available rooms
    public void searchAvailableRooms(String category) {
        boolean found = false;
        System.out.println("Available rooms in category: " + category);
        for (Room room : rooms) {
            if (room.isAvailable && room.category.equalsIgnoreCase(category)) {
                System.out.println("Room Number: " + room.roomNumber);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No rooms available in this category.");
        }
    }

    // Make a reservation
    public void makeReservation(int roomNumber) {
        for (Room room : rooms) {
            if (room.roomNumber == roomNumber && room.isAvailable) {
                room.isAvailable = false;
                System.out.println("Room " + roomNumber + " has been reserved.");
                return;
            }
        }
        System.out.println("Room not available or doesn't exist.");
    }

    // View all rooms
    public void viewAllRooms() {
        System.out.println("All rooms:");
        for (Room room : rooms) {
            System.out.println("Room Number: " + room.roomNumber + ", Category: " + room.category + ", Available: " + room.isAvailable);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HotelReservationSystem system = new HotelReservationSystem();

        // Add some default rooms
        system.addRoom(101, "Single");
        system.addRoom(102, "Double");
        system.addRoom(103, "Suite");

        while (true) {
            System.out.println("\n=== Hotel Reservation System ===");
            System.out.println("1. View All Rooms");
            System.out.println("2. Search Available Rooms");
            System.out.println("3. Make a Reservation");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    system.viewAllRooms();
                    break;

                case 2:
                    System.out.print("Enter room category (Single, Double, Suite): ");
                    scanner.nextLine(); // Consume the newline
                    String category = scanner.nextLine();
                    system.searchAvailableRooms(category);
                    break;

                case 3:
                    System.out.print("Enter room number to reserve: ");
                    int roomNumber = scanner.nextInt();
                    system.makeReservation(roomNumber);
                    break;

                case 4:
                    System.out.println("Thank you for using the Hotel Reservation System. Goodbye!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
