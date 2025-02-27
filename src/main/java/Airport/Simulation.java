package Airport;

import java.util.Iterator;
import java.util.Random;

import javax.swing.JTextArea;

class Simulation {
    private Airport airport;
    private int cycleCount = 0;
    private Random random = new Random();

    public Simulation(Airport airport) {
        this.airport = airport;
    }

    // CLI Version
    public void run(int totalCycles) {
        for (int i = 0; i < totalCycles; i++) {
            cycleCount++;
            System.out.println("\n=== 🕒 Time Cycle: " + cycleCount + " ===");

            for (Flight flight : airport.getFlights()) {
                System.out.println("✈ Flight " + flight.getFlightNumber() + " → " + flight.getDestination() +
                        " (State: " + flight.getState() + ")");
                
                if (flight.getAssignedAirplane() == null) {
                    Gate gate = airport.getAvailableGate();
                    if (gate != null) {
                        flight.setState("BOARDING");
                        Airplane airplane = AirplaneFactory.createAirplane(flight.getAirplaneType());
                        gate.assignAirplane(airplane);
                        flight.assignAirplane(airplane);
                        System.out.println("   ✅ Passengers boarding at Gate " + gate.getGateNumber());
                        System.out.println("   👤 Business: " + flight.getBusinessPassengers() +
                                           " | 🧑‍🤝‍🧑 Economy: " + flight.getEconomyPassengers());
                        System.out.println("   🏷 Plane Type: " + flight.getAirplaneType());
                    } else {
                        System.out.println("   ⏳ No available gates! Flight delayed.");
                        flight.setState("DELAYED");
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
                        flight.setState("TAKING_OFF");
                        runway.assignAirplane(flight.getAssignedAirplane());
                        System.out.println("   🛫 Flight " + flight.getFlightNumber() + " departed from Runway " + runway.getRunwayNumber());
                        iterator.remove();
                    } else {
                        System.out.println("   ⛔ No available runways! Flight delayed.");
                        flight.setState("DELAYED");
                    }
                }
            }

            // Display Gate Status
            System.out.println("\n🏠 Gate Status:");
            for (Gate gate : airport.getGates()) {
                System.out.println("   - Gate " + gate.getGateNumber() + " | Available: " + (gate.isAvailable() ? "✅ Yes" : "❌ No"));
            }

            // Display Runway Status
            System.out.println("\n🏁 Runway Status:");
            for (Runway runway : airport.getRunways()) {
                System.out.println("   - Runway " + runway.getRunwayNumber() + " | Occupied: " + (runway.isOccupied() ? "🛬 In Use" : "🟢 Free"));
            }

            // Random emergency events
            if (random.nextDouble() < 0.10) { 
                System.out.println("\n⚠ Emergency Landing! A plane is returning unexpectedly!");
            }
            if (random.nextDouble() < 0.10) { 
                System.out.println("🛠 Maintenance in progress on a random airplane!");
            }
            if (random.nextDouble() < 0.10) {
                System.out.println("⛽ A plane is refueling!");
            }

            System.out.println("\n=== ✅ End of Cycle " + cycleCount + " ===");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ignored) {

            }
        }
        System.out.println("\n✅ Simulation Completed!");
    }

    // GUI Version
    public void run(JTextArea logArea) {
        for (int i = 0; i < 10; i++) { 
            cycleCount++;
            logArea.append("\n=== 🕒 Time Cycle: " + cycleCount + " ===\n");
    
            for (Flight flight : airport.getFlights()) {
                logArea.append("✈ Flight " + flight.getFlightNumber() + " → " + flight.getDestination() +
                               " (State: " + flight.getState() + ")\n");
    
                if (flight.getAssignedAirplane() == null) {
                    Gate gate = airport.getAvailableGate();
                    if (gate != null) {
                        flight.setState("BOARDING");
                        Airplane airplane = AirplaneFactory.createAirplane(flight.getAirplaneType());
                        gate.assignAirplane(airplane);
                        flight.assignAirplane(airplane);
                        
                        logArea.append("   ✅ Passengers boarding at Gate " + gate.getGateNumber() + "\n");
                        logArea.append("   🏷 Plane Type: " + flight.getAirplaneType() + "\n");
                        logArea.append("   👤 Business: " + flight.getBusinessPassengers() +
                                       " | 🧑‍🤝‍🧑 Economy: " + flight.getEconomyPassengers() + "\n");
                        logArea.append("   ⏳ Expected Takeoff Time: " + flight.getExpectedTakeoffTime() + "\n");
                    } else {
                        logArea.append("   ⏳ No available gates! Flight delayed.\n");
                        flight.setState("DELAYED");
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
                        flight.setState("TAKING_OFF");
                        runway.assignAirplane(flight.getAssignedAirplane());
                        logArea.append("   🛫 Flight " + flight.getFlightNumber() + " departed from Runway " + runway.getRunwayNumber() + "\n");
                        iterator.remove();
                    } else {
                        logArea.append("   ⛔ No available runways! Flight delayed.\n");
                        flight.setState("DELAYED");
                    }
                }
            }
    
            // Display Gate Status
            logArea.append("\n🏠 Gate Status:\n");
            for (Gate gate : airport.getGates()) {
                logArea.append("   - Gate " + gate.getGateNumber() + " | Available: " + (gate.isAvailable() ? "✅ Yes" : "❌ No") + "\n");
            }
    
            // Display Runway Status
            logArea.append("\n🏁 Runway Status:\n");
            for (Runway runway : airport.getRunways()) {
                logArea.append("   - Runway " + runway.getRunwayNumber() + " | Occupied: " + (runway.isOccupied() ? "🛬 In Use" : "🟢 Free") + "\n");
            }
    
            // Random Events (Refueling, Maintenance, Emergency Landing)
            if (Math.random() < 0.10) {
                logArea.append("\n⚠ Emergency Landing! A plane is returning unexpectedly!\n");
            }
            if (Math.random() < 0.10) {
                logArea.append("🛠 Maintenance in progress on a random airplane!\n");
            }
            if (Math.random() < 0.10) {
                logArea.append("⛽ A plane is refueling!\n");
            }
    
            logArea.append("\n=== ✅ End of Cycle " + cycleCount + " ===\n");
    
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ignored) {

            }
        }
    
        logArea.append("\n✅ Simulation Completed!\n");
    }
}    