package model;

import java.time.LocalDateTime;

/**
 * Represents a booking request made by a guest.
 * A reservation object is placed in the booking queue
 * and processed using FIFO order.
 *
 * @author Neel
 * @version 1.0
 */
public class Reservation {

    private String guestName;
    private String roomType;
    private int nights;
    private LocalDateTime requestTime;

    public Reservation(String guestName, String roomType, int nights) {
        this.guestName = guestName;
        this.roomType = roomType;
        this.nights = nights;
        this.requestTime = LocalDateTime.now();
    }

    public String getGuestName() {
        return guestName;
    }

    public String getRoomType() {
        return roomType;
    }

    public int getNights() {
        return nights;
    }

    public LocalDateTime getRequestTime() {
        return requestTime;
    }

    @Override
    public String toString() {
        return "Guest: " + guestName +
               ", Room: " + roomType +
               ", Nights: " + nights +
               ", Requested At: " + requestTime;
    }
}