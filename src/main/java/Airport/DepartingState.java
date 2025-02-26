package Airport;

class DepartingState implements AirplaneState {
    @Override
    public void handleState(AirplaneContext context) {
        System.out.println("✈ Airplane is departing.");
    }
}
    