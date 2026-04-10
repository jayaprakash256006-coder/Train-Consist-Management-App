import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UseCase15TrainConsistMgantTest {

    // ✔ Safe Cargo Assignment
    @Test
    void testCargo_SafeAssignment() {
        UseCase15TrainConsistMgant.GoodsBogie bogie =
                new UseCase15TrainConsistMgant.GoodsBogie("Cylindrical");

        assertDoesNotThrow(() -> bogie.assignCargo("Petroleum"));
    }

    // ✔ Unsafe Assignment Handling
    @Test
    void testCargo_UnsafeAssignmentHandled() {
        UseCase15TrainConsistMgant.GoodsBogie bogie =
                new UseCase15TrainConsistMgant.GoodsBogie("Rectangular");

        // Exception is handled inside method, so no exception should propagate
        assertDoesNotThrow(() -> bogie.assignCargo("Petroleum"));
    }

    // ✔ Cargo NOT assigned after failure
    @Test
    void testCargo_CargoNotAssignedAfterFailure() {
        UseCase15TrainConsistMgant.GoodsBogie bogie =
                new UseCase15TrainConsistMgant.GoodsBogie("Rectangular");

        bogie.assignCargo("Petroleum");

        // cargo should remain null due to failure
        assertNull(bogie.cargo);
    }

    // ✔ Program continues after exception
    @Test
    void testCargo_ProgramContinuesAfterException() {
        UseCase15TrainConsistMgant.GoodsBogie b1 =
                new UseCase15TrainConsistMgant.GoodsBogie("Rectangular");

        UseCase15TrainConsistMgant.GoodsBogie b2 =
                new UseCase15TrainConsistMgant.GoodsBogie("Cylindrical");

        // First will fail, second should still execute
        assertDoesNotThrow(() -> {
            b1.assignCargo("Petroleum");
            b2.assignCargo("Coal");
        });

        assertEquals("Coal", b2.cargo);
    }

    // ✔ Finally block execution (indirect check)
    @Test
    void testCargo_FinallyBlockExecution() {
        UseCase15TrainConsistMgant.GoodsBogie bogie =
                new UseCase15TrainConsistMgant.GoodsBogie("Rectangular");

        // We cannot directly test finally, but method must complete execution
        assertDoesNotThrow(() -> bogie.assignCargo("Petroleum"));
    }
}