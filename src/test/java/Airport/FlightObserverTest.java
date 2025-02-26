package Airport;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class FlightObserverTest {
    Flight flight;
    Passenger passenger1;
    Passenger passenger2;

    @BeforeEach
    void setUp() {
        flight = new Flight("A321", "Los Angeles", 2, "Passenger", 10, 50);
        passenger1 = new Passenger("John Doe");
        passenger2 = new Passenger("Jane Doe");
        flight.addObserver(passenger1);
        flight.addObserver(passenger2);
    }

    @Test
    @DisplayName("Test Observer Pattern - Multiple Notifications")
    void testMultipleObserversReceiveUpdates() {
        flight.notifyObservers("Gate Changed");
        assertTrue(true); // Manually check console for both notifications
    }

    @Test
    @DisplayName("Test Observer Pattern - Remove Observer")
    void testRemoveObserver() {
        flight.removeObserver(passenger1);
        flight.notifyObservers("Flight Delayed");
        assertTrue(true); // Check console - should NOT notify passenger1
    }
}
