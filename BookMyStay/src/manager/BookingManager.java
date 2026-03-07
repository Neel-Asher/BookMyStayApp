package manager;

import java.util.Scanner;
import model.Reservation;
import service.BookingQueueService;

/**
 * Handles user interaction for booking requests.
 * Acts as a controller between the UI
 * and the booking queue service.
 *
 * @author Neel
 * @version 1.0
 */
public class BookingManager {

    private BookingQueueService bookingQueueService;

    public BookingManager(BookingQueueService bookingQueueService) {
        this.bookingQueueService = bookingQueueService;
    }

    public void createBookingRequest(Scanner scanner) {

        System.out.print("Enter Guest Name: ");
        String guestName = scanner.nextLine();

        System.out.print("Enter Room Type: ");
        String roomType = scanner.nextLine();

        System.out.print("Enter Number of Nights: ");
        int nights = scanner.nextInt();
        scanner.nextLine();

        Reservation reservation =
                new Reservation(guestName, roomType, nights);

        bookingQueueService.addBookingRequest(reservation);
    }

    public void processNextRequest() {
        bookingQueueService.processNextBooking();
    }

    public void showQueue() {
        bookingQueueService.viewQueue();
    }
}