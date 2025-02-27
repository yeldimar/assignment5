package Airport;
class Passenger implements Observer {
    private String name;

    public Passenger(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        System.out.println("📢 Passenger " + name + " received update: " + message);
    }
}
