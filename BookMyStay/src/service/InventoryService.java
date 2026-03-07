package service;

import java.util.HashMap;
import java.util.Map;

/**
 * InventoryService maintains the core room inventory data.
 *
 * Responsibilities:
 * - Store room types and their counts
 * - Store room prices
 * - Provide fast lookup for availability
 *
 * Data Structures Used:
 * HashMap<String, Integer> -> RoomType → Available Count
 * HashMap<String, Double>  -> RoomType → Price Per Night
 *
 * HashMap ensures O(1) access time for inventory operations.
 *
 * @author Neel
 * @version 1.0
 */
public class InventoryService {

    private Map<String, Integer> roomInventory;
    private Map<String, Double> roomPrices;

    public InventoryService() {
        roomInventory = new HashMap<>();
        roomPrices = new HashMap<>();
    }

    public void addRoomType(String roomType, int count, double price) {
        roomInventory.put(roomType, count);
        roomPrices.put(roomType, price);
    }

    public void updateRoomCount(String roomType, int newCount) {
        if (roomInventory.containsKey(roomType)) {
            roomInventory.put(roomType, newCount);
        }
    }

    public void updateRoomPrice(String roomType, double newPrice) {
        if (roomPrices.containsKey(roomType)) {
            roomPrices.put(roomType, newPrice);
        }
    }

    public int getAvailableRooms(String roomType) {
        return roomInventory.getOrDefault(roomType, 0);
    }

    public double getRoomPrice(String roomType) {
        return roomPrices.getOrDefault(roomType, 0.0);
    }

    public Map<String, Integer> getInventory() {
        return roomInventory;
    }

    public Map<String, Double> getPrices() {
        return roomPrices;
    }
}