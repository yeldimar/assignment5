package Airport;

class AtGateState implements AirplaneState {
    @Override
    public void handleState(AirplaneContext context) {
        System.out.println("🛑 Airplane is at the gate, passengers are boarding.");
        context.setState(new DepartingState());
    }
}
