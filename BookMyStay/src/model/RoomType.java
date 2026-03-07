package model;

/**
 * Represents a type of room in the hotel.
 *
 * Example room types include:
 * Single, Double, Suite.
 *
 * This class models the domain entity for a room type.
 *
 * @author Neel
 * @version 1.0
 */
public class RoomType {

    private String name;

    public RoomType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}