package service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import model.RoomDetails;

/**
 * Provides room search functionality for guests.
 * This service performs read-only access on
 * the inventory data and filters available rooms.
 *
 * Ensures no mutation of inventory during search.
 *
 * @author Neel
 * @version 2.0
 */
public class SearchService {

    private InventoryService inventoryService;

    public SearchService(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    public List<RoomDetails> searchAvailableRooms() {

        List<RoomDetails> results = new ArrayList<>();

        HashMap<String, Integer> inventory = inventoryService.getRoomCounts();
        HashMap<String, Double> prices = inventoryService.getRoomPrices();

        for (String roomType : inventory.keySet()) {

            int available = inventory.get(roomType);

            if (available > 0) {

                double price = prices.get(roomType);

                String amenities = getAmenitiesForRoom(roomType);

                RoomDetails room =
                        new RoomDetails(roomType, price, available, amenities);

                results.add(room);
            }
        }

        return results;
    }

    private String getAmenitiesForRoom(String roomType) {

        if (roomType.equalsIgnoreCase("Single")) {
            return "WiFi, TV";
        }

        if (roomType.equalsIgnoreCase("Double")) {
            return "WiFi, TV, AC";
        }

        if (roomType.equalsIgnoreCase("Suite")) {
            return "WiFi, TV, AC, Mini Bar";
        }

        return "Standard Amenities";
    }
}