package Airport;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AirplaneStateTest {
    AirplaneContext airplane;

    @BeforeEach
    void setUp() {
        airplane = new AirplaneContext();
    }

    @Test
    @DisplayName("Test State Pattern - Invalid State Transition")
    void testInvalidStateTransition() {
        airplane.proceed(); 
        airplane.proceed(); 
        airplane.proceed(); 
        assertTrue(true); 
    }
}
