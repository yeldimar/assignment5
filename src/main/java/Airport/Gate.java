package Airport;

class Gate {
    private int gateNumber;
    private boolean isOccupied;

    public Gate(int gateNumber) {
        this.gateNumber = gateNumber;
        this.isOccupied = false;
    }

    public boolean isAvailable() {
        return !isOccupied;
    }

    public void assignAirplane(Airplane airplane) {
        if (isOccupied) {
            System.out.println("🚦 Gate " + gateNumber + " is occupied!");
        } else {
            isOccupied = true;
            System.out.println("🛬 Airplane " + airplane.getType() + " assigned to Gate " + gateNumber);
        }
    }

    public void releaseGate() {
        isOccupied = false;
        System.out.println("🛫 Gate " + gateNumber + " is now available.");
    }
}
