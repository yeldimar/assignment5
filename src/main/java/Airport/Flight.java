package Airport;

import java.util.ArrayList;
import java.util.List;

class Flight extends Subject {
    private String flightNumber;
    private String destination;
    private String airplaneType;
    private int expectedTakeoffTime;
    private int gateNumber;
    private String state; 
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

    // ✅ Getter methods to fix visibility issues
    public String getFlightNumber() {
        return flightNumber;
    }

    public String getDestination() {
        return destination;
    }

    public String getAirplaneType() {
        return airplaneType;
    }

    public int getExpectedTakeoffTime() {
        return expectedTakeoffTime;
    }

    public int getGateNumber() {
        return gateNumber;
    }

    public Airplane getAssignedAirplane() {
        return assignedAirplane;
    }

    public String getState() { 
        return state;
    }
    public void setState(String newState) { 
        this.state = newState;
    }
}
