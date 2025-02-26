package Airport;

class AirplaneContext {
    private AirplaneState state;

    public AirplaneContext() {
        this.state = new LandedState(); // Default state
    }

    public void setState(AirplaneState state) {
        this.state = state;
    }

    public void proceed() {
        state.handleState(this);
    }
}
