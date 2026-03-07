package service;

import java.util.Queue;
import java.util.ArrayList;
import java.util.List;

import model.Reservation;

public class BookingService {

	private BookingQueueService bookingQueueService;
    private InventoryService inventoryService;
    private List<Reservation> confirmedReservations;

    public BookingService(BookingQueueService bookingQueueService,
            InventoryService inventoryService) {

		this.bookingQueueService = bookingQueueService;
		this.inventoryService = inventoryService;
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
            confirmedReservations.add(reservation);

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