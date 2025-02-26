package Airport;

class CargoPlane extends Airplane {
    public CargoPlane() {
        this.type = "Cargo Plane";
        this.capacity = 5000;
        this.fuelEfficiency = 3;
    }

    @Override
    public void showDetails() {
        System.out.println("📦 Cargo Plane - Capacity: " + capacity + ", Fuel Efficiency: " + fuelEfficiency);
    }
}
