package factory;

public class AirplaneFactory {
    public static Airplane createAirplane() {
        return new Airplane("Passenger Plane"); // Always returns a Passenger Plane for now
    }
}
