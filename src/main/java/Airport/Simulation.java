package Airport;

import java.util.Iterator;

class Simulation {
    private Airport airport;
    private int cycleCount = 0;

    public Simulation(Airport airport) {
        this.airport = airport;
    }

    public void run(int totalCycles) {
        for (int i = 0; i < totalCycles; i++) {
            cycleCount++;
            System.out.println("\n🔄 Cycle " + cycleCount + " started");

            // Process Arrivals & Gate Assignments
            for (Flight flight : airport.getFlights()) {
                if (flight.getAssignedAirplane() == null) {
                    Gate gate = airport.getAvailableGate();
                    if (gate != null) {
                        Airplane airplane = AirplaneFactory.createAirplane(flight.getAirplaneType());
                        gate.assignAirplane(airplane);
                        flight.assignAirplane(airplane);
                        System.out.println("✅ Flight " + flight.getFlightNumber() + " has been assigned a gate.");
                    } else {
                        System.out.println("⚠ No available gates for Flight " + flight.getFlightNumber());
                    }
                }
            }

            // Process Departures
            Iterator<Flight> iterator = airport.getFlights().iterator();
            while (iterator.hasNext()) {
                Flight flight = iterator.next();
                if (flight.getAssignedAirplane() != null && cycleCount - flight.getExpectedTakeoffTime() >= 3) {
                    Runway runway = airport.getAvailableRunway();
                    if (runway != null) {
                        runway.assignAirplane(flight.getAssignedAirplane());
                        System.out.println("✈ Flight " + flight.getFlightNumber() + " is departing.");
                        iterator.remove(); // Remove flight from the system after departure
                    } else {
                        System.out.println("⛔ No available runways for Flight " + flight.getFlightNumber());
                    }
                }
            }

            System.out.println("🔄 Cycle " + cycleCount + " completed\n");
        }
    }
}
