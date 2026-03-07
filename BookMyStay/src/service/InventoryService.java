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
 * @version 2.0
 */
package service;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * InventoryService maintains the core room inventory data.
 *
 * Responsibilities:
 * - Store room types and counts
 * - Store room prices
 * - Allocate rooms during confirmed bookings
 * - Prevent duplicate room IDs
 *
 * Data Structures Used:
 * HashMap<String, Integer> -> RoomType → Available Count
 * HashMap<String, Double>  -> RoomType → Price Per Night
 * HashSet<String>          -> Booked Room IDs
 * HashMap<String, Set<String>> -> RoomType → Assigned Rooms
 *
 * @author Neel
 * @version 4.0
 */
public class InventoryService {

    private HashMap<String, Integer> roomCounts;
    private HashMap<String, Double> roomPrices;

    private Set<String> bookedRoomIds;
    private HashMap<String, Set<String>> allocatedRooms;

    private int idCounter = 1;

    public InventoryService() {

        roomCounts = new HashMap<>();
        roomPrices = new HashMap<>();

        bookedRoomIds = new HashSet<>();
        allocatedRooms = new HashMap<>();
    }

    public void addRoomType(String type, int count, double price) {

        roomCounts.put(type, count);
        roomPrices.put(type, price);

        allocatedRooms.put(type, new HashSet<>());
    }

    public void updateRoomCount(String type, int count) {
        roomCounts.put(type, count);
    }

    public void updateRoomPrice(String type, double price) {
        roomPrices.put(type, price);
    }

    public HashMap<String, Integer> getRoomCounts() {
        return roomCounts;
    }

    public HashMap<String, Double> getRoomPrices() {
        return roomPrices;
    }

    public String allocateRoom(String roomType) {

        Integer available = roomCounts.get(roomType);

        if (available == null || available == 0) {
            return null;
        }

        String roomId = roomType.substring(0,1).toUpperCase() + idCounter++;

        if(bookedRoomIds.contains(roomId)) {
            return null;
        }

        bookedRoomIds.add(roomId);

        allocatedRooms.get(roomType).add(roomId);

        roomCounts.put(roomType, available - 1);

        return roomId;
    }

    public boolean isRoomBooked(String roomId) {
        return bookedRoomIds.contains(roomId);
    }

    public void displayInventory() {

        for(String type : roomCounts.keySet()) {
            System.out.println(type +
                    " | Available: " + roomCounts.get(type) +
                    " | Price: " + roomPrices.get(type) +
                    " | Allocated Rooms: " + allocatedRooms.get(type));
        }
    }

    public HashMap<String, Set<String>> getAllocatedRooms() {
        return allocatedRooms;
    }
}