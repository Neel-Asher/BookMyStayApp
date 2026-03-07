package manager;

import model.Reservation;
import service.BookingHistoryService;

import java.util.List;

/**
 * Generates booking history reports for admins.
 * Uses BookingHistoryService as the data source.
 *
 * @author Neel
 * @version 1.0
 */
public class ReportManager {

    private BookingHistoryService bookingHistoryService;

    public ReportManager(BookingHistoryService bookingHistoryService) {
        this.bookingHistoryService = bookingHistoryService;
    }

    public void generateBookingReport() {

        List<Reservation> reservations = bookingHistoryService.getAllReservations();

        if(reservations.isEmpty()) {
            System.out.println("No booking history available.");
            return;
        }

        System.out.println("\n===== BOOKING HISTORY REPORT =====");

        for (Reservation r : reservations) {

            System.out.println("Guest Name : " + r.getGuestName());
            System.out.println("Room Type  : " + r.getRoomType());
            System.out.println("Room ID    : " + r.getRoomId());
            System.out.println("Nights     : " + r.getNights());
            System.out.println("Status     : " + r.getStatus());
            System.out.println("-------------------------------");
        }

        System.out.println("Total Reservations: " + reservations.size());
    }
}