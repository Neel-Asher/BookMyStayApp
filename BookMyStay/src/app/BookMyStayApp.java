package app;

import java.util.Scanner;
import manager.InventoryManager;
import manager.SearchManager;
import manager.BookingManager;
import service.SearchService;
import service.BookingQueueService;

/**
 * Main application class for BookMyStay.
 * Demonstrates inventory management,
 * room search, and booking queue operations.
 *
 * @author Neel
 * @version 3.0
 */
public class BookMyStayApp {

    public static void main(String[] args) {

        InventoryManager inventoryManager = new InventoryManager();

        SearchService searchService =
                new SearchService(inventoryManager.getInventoryService());

        SearchManager searchManager =
                new SearchManager(searchService);

        BookingQueueService bookingQueueService =
                new BookingQueueService();

        BookingManager bookingManager =
                new BookingManager(bookingQueueService);

        Scanner scanner = new Scanner(System.in);

        inventoryManager.createRoomType("Single", 10, 3500);
        inventoryManager.createRoomType("Double", 6, 5500);
        inventoryManager.createRoomType("Suite", 3, 9000);

        int choice;

        do {

            System.out.println("\n====== BookMyStay System ======");
            System.out.println("1 View Room Inventory");
            System.out.println("2 Update Room Count");
            System.out.println("3 Update Room Price");
            System.out.println("4 Search Available Rooms");
            System.out.println("5 Add Booking Request");
            System.out.println("6 Process Next Booking");
            System.out.println("7 View Booking Queue");
            System.out.println("8 Exit");

            System.out.print("Enter choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1:
                    inventoryManager.displayInventory();
                    break;

                case 2:
                    System.out.print("Enter room type: ");
                    String typeCount = scanner.nextLine();

                    System.out.print("Enter new count: ");
                    int count = scanner.nextInt();

                    inventoryManager.updateRoomCount(typeCount, count);
                    break;

                case 3:
                    System.out.print("Enter room type: ");
                    String typePrice = scanner.nextLine();

                    System.out.print("Enter new price: ");
                    double price = scanner.nextDouble();

                    inventoryManager.updateRoomPrice(typePrice, price);
                    break;

                case 4:
                    searchManager.displayAvailableRooms();
                    break;

                case 5:
                    bookingManager.createBookingRequest(scanner);
                    break;

                case 6:
                    bookingManager.processNextRequest();
                    break;

                case 7:
                    bookingManager.showQueue();
                    break;

                case 8:
                    System.out.println("Exiting BookMyStay...");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 8);

        scanner.close();
    }
}