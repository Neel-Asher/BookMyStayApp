package service;

import java.util.LinkedList;
import java.util.Queue;
import model.Reservation;

/**
 * Manages booking requests using a FIFO queue.
 * Ensures fairness by processing requests
 * in the exact order they are received.
 *
 * @author Neel
 * @version 1.0
 */
public class BookingQueueService {

    private Queue<Reservation> bookingQueue;

    public BookingQueueService() {
        bookingQueue = new LinkedList<>();
    }

    public void addBookingRequest(Reservation reservation) {

        bookingQueue.offer(reservation);

        System.out.println("Booking request added to queue.");
        System.out.println("Current queue size: " + bookingQueue.size());
    }

    public void processNextBooking() {

        if (bookingQueue.isEmpty()) {
            System.out.println("No booking requests to process.");
            return;
        }

        Reservation reservation = bookingQueue.poll();

        System.out.println("Processing booking request:");
        System.out.println(reservation);
    }

    public void viewQueue() {

        if (bookingQueue.isEmpty()) {
            System.out.println("Booking queue is empty.");
            return;
        }

        System.out.println("\n====== Current Booking Queue ======");

        for (Reservation r : bookingQueue) {
            System.out.println(r);
        }
    }
}