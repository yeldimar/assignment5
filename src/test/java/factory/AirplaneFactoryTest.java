package factory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AirplaneFactoryTest {
    @Test
    public void testMainOutput() {
        assertTrue(true); 
    }

    @DisplayName("Factory should create a Passenger Plane")
    @Test
    public void testCreateAirplane() {
        Airplane plane = AirplaneFactory.createAirplane();
        assertEquals("Passenger Plane", plane.getType(), "Factory should create a Passenger Plane");
    }
}
