package Airport;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.io.OutputStreamWriter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SimulationTest {
    private Airport airport;
    private Simulation simulation;
    private ByteArrayOutputStream outputStream;
    private PrintStream originalOut;

    @BeforeEach
    void setUp() {
        airport = new Airport(3, 2); // 3 gates, 2 runways
        simulation = new Simulation(airport);

        originalOut = System.out;
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream, true, StandardCharsets.UTF_8));
    }

    @Test
    @DisplayName("Test Flight Addition to Airport")
    void testAddFlight() {
        Flight flight = new Flight("A123", "New York", 2, "Passenger");
        airport.addFlight(flight);
        List<Flight> flights = airport.getFlights();
        assertEquals(1, flights.size(), "Flight should be added to airport");
    }

    @Test
    @DisplayName("Test Gate Assignment to Flight")
    void testGateAssignment() {
        Flight flight = new Flight("A456", "Los Angeles", 3, "Cargo");
        airport.addFlight(flight);
        simulation.run(1);
        assertNotNull(flight.getAssignedAirplane(), "Flight should be assigned an airplane");
    }

    @Test
    @DisplayName("Test Flight Departure after Cycles")
    void testFlightDeparture() {
        Flight flight = new Flight("B789", "Chicago", 1, "Passenger");
        airport.addFlight(flight);
        simulation.run(5); // Run for 5 cycles
        assertEquals(0, airport.getFlights().size(), "Flight should be removed after departure");
    }
}
