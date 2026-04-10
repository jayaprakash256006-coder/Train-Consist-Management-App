import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UseCase14TrainConsistMgantTest {

    // ✔ Valid Capacity
    @Test
    void testException_ValidCapacityCreation() throws UseCase14TrainConsistMgant.InvalidCapacityException {
        UseCase14TrainConsistMgant.PassengerBogie bogie =
                new UseCase14TrainConsistMgant.PassengerBogie("AC", 50);

        assertNotNull(bogie);
    }

    // ✔ Negative Capacity
    @Test
    void testException_NegativeCapacityThrowsException() {
        Exception exception = assertThrows(
                UseCase14TrainConsistMgant.InvalidCapacityException.class,
                () -> new UseCase14TrainConsistMgant.PassengerBogie("Sleeper", -10)
        );

        assertEquals("Capacity must be greater than zero", exception.getMessage());
    }

    // ✔ Zero Capacity
    @Test
    void testException_ZeroCapacityThrowsException() {
        Exception exception = assertThrows(
                UseCase14TrainConsistMgant.InvalidCapacityException.class,
                () -> new UseCase14TrainConsistMgant.PassengerBogie("General", 0)
        );

        assertEquals("Capacity must be greater than zero", exception.getMessage());
    }

    // ✔ Exception Message Validation
    @Test
    void testException_ExceptionMessageValidation() {
        Exception exception = assertThrows(
                UseCase14TrainConsistMgant.InvalidCapacityException.class,
                () -> new UseCase14TrainConsistMgant.PassengerBogie("AC", 0)
        );

        assertEquals("Capacity must be greater than zero", exception.getMessage());
    }

    // ✔ Object Integrity
    @Test
    void testException_ObjectIntegrityAfterCreation() throws UseCase14TrainConsistMgant.InvalidCapacityException {
        UseCase14TrainConsistMgant.PassengerBogie bogie =
                new UseCase14TrainConsistMgant.PassengerBogie("AC", 60);

        assertEquals("AC", bogie.getType());
        assertEquals(60, bogie.getCapacity());
    }

    // ✔ Multiple Valid Bogies
    @Test
    void testException_MultipleValidBogiesCreation() throws UseCase14TrainConsistMgant.InvalidCapacityException {
        UseCase14TrainConsistMgant.PassengerBogie b1 =
                new UseCase14TrainConsistMgant.PassengerBogie("AC", 40);

        UseCase14TrainConsistMgant.PassengerBogie b2 =
                new UseCase14TrainConsistMgant.PassengerBogie("Sleeper", 60);

        UseCase14TrainConsistMgant.PassengerBogie b3 =
                new UseCase14TrainConsistMgant.PassengerBogie("General", 80);

        assertNotNull(b1);
        assertNotNull(b2);
        assertNotNull(b3);
    }
}