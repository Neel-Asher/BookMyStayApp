package service;

import java.util.Queue;
import java.util.LinkedList;
import model.Reservation;

/**
 * Manages booking requests using a FIFO queue.
 * Ensures fairness by processing requests
 * in the exact order they are received.
 *
 * @author Neel
 * @version 2.0
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

    public Reservation getNextBooking() {

        if (bookingQueue.isEmpty()) {
            return null;
        }

        return bookingQueue.poll();
    }

    public boolean isQueueEmpty() {
        return bookingQueue.isEmpty();
    }
    
    public Queue<Reservation> getQueue() {
        return bookingQueue;
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