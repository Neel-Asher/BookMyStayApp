package model;

/**
 * Represents detailed room information returned
 * during a guest room search.
 *
 * Contains room type, price, availability,
 * and amenities for display purposes.
 *
 * @author Neel
 * @version 1.0
 */
public class RoomDetails {

    private String roomType;
    private double price;
    private int availableCount;
    private String amenities;

    public RoomDetails(String roomType, double price, int availableCount, String amenities) {
        this.roomType = roomType;
        this.price = price;
        this.availableCount = availableCount;
        this.amenities = amenities;
    }

    public String getRoomType() {
        return roomType;
    }

    public double getPrice() {
        return price;
    }

    public int getAvailableCount() {
        return availableCount;
    }

    public String getAmenities() {
        return amenities;
    }
}