package Airport;

import java.util.ArrayList;
import java.util.List;

class Flight extends Subject {
    private String flightNumber;
    private String destination;
    private String airplaneType; // NEW: Flight specifies its airplane type.
    private int expectedTakeoffTime;
    private int gateNumber;
    private Airplane assignedAirplane;
    private List<Observer> observers;

    public Flight(String flightNumber, String destination, int takeoffTime, String airplaneType) {
        this.flightNumber = flightNumber;
        this.destination = destination;
        this.expectedTakeoffTime = takeoffTime;
        this.airplaneType = airplaneType; // Store requested type
        this.observers = new ArrayList<>();
    }

    public void assignAirplane(Airplane airplane) {
        this.assignedAirplane = airplane;
        System.out.println("✈ Flight " + flightNumber + " assigned Airplane " + airplane.getType());
        notifyObservers("Airplane Assigned");
    }
}
