package service;

import model.Reservation;
import java.util.ArrayList;
import java.util.List;
/**
 * @author Neel
 * @version 1.0
 */
public class BookingHistoryService {

    private List<Reservation> reservationHistory;

    public BookingHistoryService() {
        reservationHistory = new ArrayList<>();
    }

    public void addReservation(Reservation reservation) {
        reservationHistory.add(reservation);
    }

    public List<Reservation> getAllReservations() {
        return reservationHistory;
    }

    public List<Reservation> getCancelledReservations() {

        List<Reservation> cancelled = new ArrayList<>();

        for (Reservation r : reservationHistory) {
            if ("CANCELLED".equalsIgnoreCase(r.getStatus())) {
                cancelled.add(r);
            }
        }

        return cancelled;
    }
    
    public void viewHistory() {

        if(reservationHistory.isEmpty()) {
            System.out.println("No booking history available.");
            return;
        }

        System.out.println("\n===== Booking History =====");

        for(Reservation r : reservationHistory) {
            System.out.println(r);
        }
    }
}