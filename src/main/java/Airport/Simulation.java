package Airport;

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

            for (Flight flight : airport.getFlights()) { // ✅ Fix: Use getter method
                if (flight.getAssignedAirplane() == null) { // ✅ Fix: Use getter method
                    Gate gate = airport.getAvailableGate();
                    if (gate != null) {
                        gate.assignAirplane(AirplaneFactory.createAirplane(flight.getAirplaneType())); // ✅ Fix: Use getter method
                    }
                }
            }

            System.out.println("🔄 Cycle " + cycleCount + " completed\n");
        }
    }
}
