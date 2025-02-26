package Airport;

import java.util.Iterator;
import javax.swing.JTextArea;

class Simulation {
    private Airport airport;
    private int cycleCount = 0;

    public Simulation(Airport airport) {
        this.airport = airport;
    }

    // CLI Version (Supports Tests)
    public void run(int totalCycles) {
        for (int i = 0; i < totalCycles; i++) {
            cycleCount++;
            System.out.println("\n🔄 Cycle " + cycleCount + " started");

            for (Flight flight : airport.getFlights()) {
                if (flight.getAssignedAirplane() == null) {
                    Gate gate = airport.getAvailableGate();
                    if (gate != null) {
                        Airplane airplane = AirplaneFactory.createAirplane(flight.getAirplaneType());
                        gate.assignAirplane(airplane);
                        flight.assignAirplane(airplane);
                        System.out.println("✅ Flight " + flight.getFlightNumber() + " assigned to Gate " + gate.getGateNumber());
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
                        System.out.println("✈ Flight " + flight.getFlightNumber() + " departed from Runway " + runway.getRunwayNumber());
                        iterator.remove();
                    } else {
                        System.out.println("⛔ No available runways for Flight " + flight.getFlightNumber());
                    }
                }
            }
            System.out.println("🔄 Cycle " + cycleCount + " completed");
        }
    }

    // GUI Version
    public void run(JTextArea logArea) {
        for (int i = 0; i < 10; i++) {
            cycleCount++;
            logArea.append("\n🔄 Cycle " + cycleCount + " started\n");

            for (Flight flight : airport.getFlights()) {
                if (flight.getAssignedAirplane() == null) {
                    Gate gate = airport.getAvailableGate();
                    if (gate != null) {
                        Airplane airplane = AirplaneFactory.createAirplane(flight.getAirplaneType());
                        gate.assignAirplane(airplane);
                        flight.assignAirplane(airplane);
                        logArea.append("✅ Flight " + flight.getFlightNumber() + " assigned to Gate " + gate.getGateNumber() + "\n");
                    } else {
                        logArea.append("⚠ No available gates for Flight " + flight.getFlightNumber() + "\n");
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
                        logArea.append("✈ Flight " + flight.getFlightNumber() + " departed from Runway " + runway.getRunwayNumber() + "\n");
                        iterator.remove();
                    } else {
                        logArea.append("⛔ No available runways for Flight " + flight.getFlightNumber() + "\n");
                    }
                }
            }
            logArea.append("🔄 Cycle " + cycleCount + " completed\n");
            try {
                Thread.sleep(1000); // Simulate real-time delay
            } catch (InterruptedException ignored) {
            }
        }
        logArea.append("✅ Simulation Completed!\n");
    }
}
