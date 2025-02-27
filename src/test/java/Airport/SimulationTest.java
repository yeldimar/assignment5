package Airport;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.List;

import javax.swing.JTextArea;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SimulationTest {
    private Airport airport;
    private Simulation simulation;
    private ByteArrayOutputStream outputStream;
    private PrintStream originalOut;
    private JTextArea logArea;

    @BeforeEach
    void setUp() {
        airport = new Airport(3, 2); 
        simulation = new Simulation(airport);
        
        originalOut = System.out;
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream, true, StandardCharsets.UTF_8));
    
        logArea = new JTextArea(); 
    }
    

    @Test
    @DisplayName("Test Flight Addition to Airport")
    void testAddFlight() {
        Flight flight = new Flight("A123", "New York", 2, "Passenger", 20, 100);
        airport.addFlight(flight);
        List<Flight> flights = airport.getFlights();
        assertEquals(1, flights.size(), "Flight should be added to airport");
    }

    @Test
    @DisplayName("Test Gate Assignment to Flight")
    void testGateAssignment() {
        Flight flight = new Flight("A456", "Los Angeles", 3, "Cargo", 5, 30);
        airport.addFlight(flight);
        simulation.run(1);
        assertNotNull(flight.getAssignedAirplane(), "Flight should be assigned an airplane");
    }
    @Test
    void testRunwayAssignment() {
        Flight flight1 = new Flight("F300", "Paris", 2, "Cargo", 0, 0);
        Flight flight2 = new Flight("F400", "Tokyo", 4, "Passenger", 3, 180);
    
        airport.addFlight(flight1);
        airport.addFlight(flight2);
    
        logArea = new JTextArea(); 
        simulation.run(logArea);
    
        assertNotNull(flight1.getAssignedAirplane(), "Flight 1 should be assigned an airplane");
        assertNotNull(flight2.getAssignedAirplane(), "Flight 2 should be assigned an airplane");
    }
    
    @Test
    void testEmergencyLanding() {
        logArea = new JTextArea(); 
        simulation.run(logArea);
        assertTrue(logArea.getText().contains("Emergency Landing"), "Should simulate an emergency landing");
    }

    @Test
    @DisplayName("Test Flight Departure after Cycles")
    void testFlightDeparture() {
        Flight flight = new Flight("B789", "Chicago", 1, "Passenger", 15, 120);
        airport.addFlight(flight);
        simulation.run(5); 
        assertEquals(0, airport.getFlights().size(), "Flight should be removed after departure");
    }
    @Test
    void testRefuelingEvent() {
        logArea = new JTextArea(); 
        simulation.run(logArea);
        assertTrue(logArea.getText().contains("refueling"), "Should simulate an airplane refueling event");
    }
}
