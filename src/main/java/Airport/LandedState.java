package Airport;

class LandedState implements AirplaneState {
    @Override
    public void handleState(AirplaneContext context) {
        System.out.println("🛬 Airplane has landed and is taxiing to the gate.");
        context.setState(new AtGateState());
    }
}
    