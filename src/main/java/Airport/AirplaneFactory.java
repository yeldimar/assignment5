package Airport;

class AirplaneFactory {
    public static Airplane createAirplane(String type) {
        switch (type) {
            case "Passenger":
                return new PassengerPlane();
            case "Cargo":
                return new CargoPlane();
            case "Private":
                return new PrivateJet();
            default:
                throw new IllegalArgumentException("Unknown airplane type: " + type);
        }
    }
}
