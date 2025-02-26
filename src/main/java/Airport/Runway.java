package Airport;

class Runway {
    private int runwayNumber;
    private boolean isOccupied;

    public Runway(int runwayNumber) {
        this.runwayNumber = runwayNumber;
        this.isOccupied = false;
    }

    public boolean isAvailable() {
        return !isOccupied;
    }

    public void assignAirplane(Airplane airplane) {
        if (isOccupied) {
            System.out.println("⛔ Runway " + runwayNumber + " is currently in use!");
        } else {
            isOccupied = true;
            System.out.println("🛫 Airplane " + airplane.getType() + " is now taking off from Runway " + runwayNumber);
        }
    }

    public void releaseRunway() {
        isOccupied = false;
        System.out.println("🛬 Runway " + runwayNumber + " is now available.");
    }
}
