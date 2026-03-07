package service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.Service;

/**
 * @author: Neel
 * @version: 1.0
 */
public class AddOnServiceService {

    private Map<String, List<Service>> reservationServices;

    public AddOnServiceService() {
        reservationServices = new HashMap<>();
    }

    public void addService(String reservationId, Service service) {

        reservationServices.putIfAbsent(reservationId, new ArrayList<>());

        reservationServices.get(reservationId).add(service);

        System.out.println(service.getName() + " added to reservation " + reservationId);
    }

    public void viewServices(String reservationId) {

        List<Service> services = reservationServices.get(reservationId);

        if(services == null || services.isEmpty()) {
            System.out.println("No services attached to reservation.");
            return;
        }

        double total = 0;

        System.out.println("\nServices for reservation " + reservationId);

        for(Service s : services) {
            System.out.println(s);
            total += s.getPrice();
        }

        System.out.println("Total Service Cost: ₹" + total);
    }
}