package Airport;

import java.util.ArrayList;
import java.util.List;

class Airport {
    private List<Gate> gates;
    private List<Runway> runways;
    private List<Flight> flights;

    public Airport(int numGates, int numRunways) {
        gates = new ArrayList<>();
        runways = new ArrayList<>();
        flights = new ArrayList<>();

        for (int i = 1; i <= numGates; i++) {
            gates.add(new Gate(i));
        }

        for (int i = 1; i <= numRunways; i++) {
            runways.add(new Runway(i));
        }
    }

    public void addFlight(Flight flight) {
        flights.add(flight);
        System.out.println("🛫 Flight " + flight.getFlightNumber() + " added to the airport.");
    }

    public Gate getAvailableGate() {
        for (Gate gate : gates) {
            if (gate.isAvailable()) {
                return gate;
            }
        }
        return null;
    }

    public Runway getAvailableRunway() {
        for (Runway runway : runways) {
            if (runway.isAvailable()) {
                return runway;
            }
        }
        return null;
    }

    // ✅ Fix: Added getter for flights to prevent direct access
    public List<Flight> getFlights() {
        return flights;
    }
}
