package manager;

import java.util.Scanner;
import model.Reservation;
import service.BookingQueueService;
import service.BookingService;

/**
 * Handles user interaction for booking requests.
 * Acts as a controller between the UI
 * and the booking services.
 *
 * @author Neel
 * @version 2.0
 */
public class BookingManager {

    private BookingQueueService bookingQueueService;
    private BookingService bookingService;

    public BookingManager(BookingQueueService bookingQueueService,
                          BookingService bookingService) {

        this.bookingQueueService = bookingQueueService;
        this.bookingService = bookingService;
    }

    public void createBookingRequest(Scanner scanner) {

        System.out.print("Enter Guest Name: ");
        String guestName = scanner.nextLine();

        System.out.print("Enter Room Type: ");
        String roomType = scanner.nextLine();

        System.out.print("Enter Number of Nights: ");
        int nights = scanner.nextInt();
        scanner.nextLine();

        Reservation reservation = new Reservation(guestName, roomType, nights);
        bookingQueueService.addBookingRequest(reservation);
    }

    public void processNextRequest() {
        bookingService.processBooking();
    }

    public void showQueue() {
        bookingQueueService.viewQueue();
    }
    
    public void showConfirmedReservations() {
        bookingService.viewConfirmedReservations();
    }
}