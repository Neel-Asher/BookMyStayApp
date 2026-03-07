package manager;

import service.InventoryService;
import util.InventoryPrinter;

/**
 * InventoryManager acts as a controller layer
 * between the application and the inventory service.
 *
 * Responsibilities:
 * - Coordinate inventory operations
 * - Ensure correct updates
 * - Provide simplified APIs for admin operations
 *
 * This layer improves system scalability by separating
 * application logic from business logic.
 *
 * @author Neel
 * @version 1.0
 */
public class InventoryManager {

    private InventoryService inventoryService;

    public InventoryManager() {
        inventoryService = new InventoryService();
    }

    public void createRoomType(String roomType, int count, double price) {
        inventoryService.addRoomType(roomType, count, price);
    }

    public void updateRoomCount(String roomType, int newCount) {
        inventoryService.updateRoomCount(roomType, newCount);
    }

    public void updateRoomPrice(String roomType, double newPrice) {
        inventoryService.updateRoomPrice(roomType, newPrice);
    }
    
    public InventoryService getInventoryService() {
        return inventoryService;
    }

    public void displayInventory() {
        InventoryPrinter.printInventory(
                inventoryService.getRoomInventory(),
                inventoryService.getRoomPrices()
        );
    }

}