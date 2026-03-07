package service;

import java.util.Queue;
import java.util.ArrayList;
import java.util.List;

import model.Reservation;

public class BookingService {

	private BookingQueueService bookingQueueService;
    private InventoryService inventoryService;
    private List<Reservation> confirmedReservations;
    private BookingHistoryService bookingHistoryService;

    public BookingService(BookingQueueService bookingQueueService,
            InventoryService inventoryService,
            BookingHistoryService bookingHistoryService) {

		this.bookingQueueService = bookingQueueService;
		this.inventoryService = inventoryService;
		this.bookingHistoryService = bookingHistoryService;
		this.confirmedReservations = new ArrayList<>();
	}

    public void processBooking() {

        if(bookingQueueService.isQueueEmpty()) {
            System.out.println("No booking requests in queue");
            return;
        }

        Reservation reservation = bookingQueueService.getNextBooking();

        String roomId = inventoryService.allocateRoom(reservation.getRoomType());

        if(roomId != null) {

            reservation.setRoomId(roomId);
            reservation.setStatus("CONFIRMED");

            confirmedReservations.add(reservation);

            bookingHistoryService.addReservation(reservation);

            System.out.println("Reservation confirmed for "
                    + reservation.getGuestName()
                    + " | Room ID: " + roomId);
        }
        else {
            System.out.println("Room allocation failed for " + reservation.getGuestName());
        }

    }
    
    public void viewConfirmedReservations() {

        if(confirmedReservations.isEmpty()) {
            System.out.println("No confirmed reservations.");
            return;
        }

        System.out.println("\n====== Confirmed Reservations ======");

        for(Reservation r : confirmedReservations) {
            System.out.println(r);
        }
    }
}