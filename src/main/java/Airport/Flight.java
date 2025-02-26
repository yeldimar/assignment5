package Airport;

import java.util.List;

class Flight extends Subject {
    private String flightNumber;
    private String destination;
    private String airplaneType;
    private int expectedTakeoffTime;
    private int gateNumber;
    private int businessPassengers;
    private int economyPassengers;
    private String state; 
    private Airplane assignedAirplane;
    private List<Observer> observers;

    public Flight(String flightNumber, String destination, int takeoffTime, String airplaneType, int businessPassengers, int economyPassengers) {
        this.flightNumber = flightNumber;
        this.destination = destination;
        this.airplaneType = airplaneType;
        this.expectedTakeoffTime = takeoffTime;
        this.businessPassengers = businessPassengers; // ✅ Fixed assignment
        this.economyPassengers = economyPassengers;   // ✅ Fixed assignment
        this.state = "OPEN_FOR_BOOKING"; // Default State
    }

    public void assignAirplane(Airplane airplane) {
        this.assignedAirplane = airplane;
        System.out.println("✈ Flight " + flightNumber + " assigned Airplane " + airplane.getType());
        notifyObservers("Airplane Assigned");
    }

    // ✅ Getter methods
    public String getFlightNumber() {
        return flightNumber;
    }

    public int getBusinessPassengers() {
        return businessPassengers;
    }

    public int getEconomyPassengers() {
        return economyPassengers;
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
