package Airport;

class PrivateJet extends Airplane {
    public PrivateJet() {
        this.type = "Private Jet";
        this.capacity = 10;
        this.fuelEfficiency = 8;
    }

    @Override
    public void showDetails() {
        System.out.println("🛩 Private Jet - Capacity: " + capacity + ", Fuel Efficiency: " + fuelEfficiency);
    }
}
