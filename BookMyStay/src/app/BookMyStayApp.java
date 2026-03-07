package app;

import java.util.Scanner;
import manager.InventoryManager;

/**
 * Main application entry point for the BookMyStay system.
 *
 * This class simulates interaction between a Hotel Admin
 * and the room inventory management system.
 *
 * Features in this version:
 * - Interactive console menu
 * - Admin can view inventory
 * - Update room counts
 * - Update room prices
 * - Check room availability
 *
 * Some default inventory values are initialized for simplicity.
 *
 * @author Neel
 * @version 1.1
 */
public class BookMyStayApp {

    public static void main(String[] args) {

        InventoryManager inventoryManager = new InventoryManager();
        Scanner scanner = new Scanner(System.in);

        inventoryManager.createRoomType("Single", 10, 3500);
        inventoryManager.createRoomType("Double", 6, 5500);
        inventoryManager.createRoomType("Suite", 3, 9000);

        int choice;

        do {

            System.out.println("\n====== BookMyStay Inventory System ======");
            System.out.println("1. View Room Inventory");
            System.out.println("2. Update Room Count");
            System.out.println("3. Update Room Price");
            System.out.println("4. Check Room Availability");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1:
                    inventoryManager.displayInventory();
                    break;

                case 2:
                    System.out.print("Enter room type: ");
                    String roomTypeCount = scanner.nextLine();

                    System.out.print("Enter new room count: ");
                    int newCount = scanner.nextInt();

                    inventoryManager.updateRoomCount(roomTypeCount, newCount);

                    System.out.println("Room count updated successfully.");
                    break;

                case 3:
                    System.out.print("Enter room type: ");
                    String roomTypePrice = scanner.nextLine();

                    System.out.print("Enter new room price: ");
                    double newPrice = scanner.nextDouble();

                    inventoryManager.updateRoomPrice(roomTypePrice, newPrice);

                    System.out.println("Room price updated successfully.");
                    break;

                case 4:
                    System.out.print("Enter room type to check availability: ");
                    String roomType = scanner.nextLine();

                    int available = inventoryManager
                            .getInventoryService()
                            .getAvailableRooms(roomType);

                    System.out.println("Available " + roomType + " rooms: " + available);
                    break;

                case 5:
                    System.out.println("Exiting BookMyStay System...");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 5);

        scanner.close();
    }
}