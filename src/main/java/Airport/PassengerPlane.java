package Airport;

class PassengerPlane extends Airplane {
    public PassengerPlane() {
        this.type = "Passenger Plane";
        this.capacity = 200;
        this.fuelEfficiency = 5;
    }

    @Override
    public void showDetails() {
        System.out.println("🛫 Passenger Plane - Capacity: " + capacity + ", Fuel Efficiency: " + fuelEfficiency);
    }
}
