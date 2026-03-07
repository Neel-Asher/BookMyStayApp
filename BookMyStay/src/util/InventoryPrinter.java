package util;

import java.util.Map;

/**
 * Utility class responsible for formatting
 * and displaying hotel inventory information.
 *
 * Separates presentation logic from business logic.
 *
 * Example Output:
 *
 * ===== HOTEL ROOM INVENTORY =====
 * Room Type : Single
 * Available : 10
 * Price     : 3500
 *
 * @author Neel
 * @version 1.0
 */
public class InventoryPrinter {

    public static void printInventory(Map<String, Integer> inventory,
                                      Map<String, Double> prices) {

        System.out.println("\n===== HOTEL ROOM INVENTORY =====");

        for (String roomType : inventory.keySet()) {

            System.out.println("\nRoom Type : " + roomType);
            System.out.println("Available : " + inventory.get(roomType));
            System.out.println("Price     : " + prices.get(roomType));
        }

        System.out.println("\n===============================");
    }
}