package Airport;

abstract class Airplane {
    protected String type;
    protected int capacity;
    protected int fuelEfficiency;

    public abstract void showDetails();

    public String getType() {
        return type;
    }

    public int getCapacity() { 
        return capacity;
    }

    public int getFuelEfficiency() {  
        return fuelEfficiency;
    }
}
