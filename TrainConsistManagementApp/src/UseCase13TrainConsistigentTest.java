import org.junit.jupiter.api.Test;
import java.util.*;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

public class UseCase13TrainConsistigentTest {

    // Reusing Bogie class
    static class Bogie {
        String type;
        int capacity;

        public Bogie(String type, int capacity) {
            this.type = type;
            this.capacity = capacity;
        }

        public int getCapacity() {
            return capacity;
        }
    }

    // Loop-based filtering
    private List<Bogie> filterUsingLoop(List<Bogie> bogies) {
        List<Bogie> result = new ArrayList<>();
        for (Bogie b : bogies) {
            if (b.getCapacity() > 60) {
                result.add(b);
            }
        }
        return result;
    }

    // Stream-based filtering
    private List<Bogie> filterUsingStream(List<Bogie> bogies) {
        return bogies.stream()
                .filter(b -> b.getCapacity() > 60)
                .collect(Collectors.toList());
    }

    @Test
    void testLoopFilteringLogic() {
        List<Bogie> bogies = Arrays.asList(
                new Bogie("Sleeper", 72),
                new Bogie("AC Chair", 56),
                new Bogie("First Class", 24)
        );

        List<Bogie> result = filterUsingLoop(bogies);

        assertEquals(1, result.size());
        assertTrue(result.get(0).getCapacity() > 60);
    }

    @Test
    void testStreamFilteringLogic() {
        List<Bogie> bogies = Arrays.asList(
                new Bogie("Sleeper", 72),
                new Bogie("AC Chair", 56),
                new Bogie("First Class", 24)
        );

        List<Bogie> result = filterUsingStream(bogies);

        assertEquals(1, result.size());
        assertTrue(result.get(0).getCapacity() > 60);
    }

    @Test
    void testLoopAndStreamResultsMatch() {
        List<Bogie> bogies = Arrays.asList(
                new Bogie("Sleeper", 72),
                new Bogie("Sleeper", 70),
                new Bogie("AC Chair", 56)
        );

        List<Bogie> loopResult = filterUsingLoop(bogies);
        List<Bogie> streamResult = filterUsingStream(bogies);

        assertEquals(loopResult.size(), streamResult.size());
    }

    @Test
    void testExecutionTimeMeasurement() {
        List<Bogie> bogies = Arrays.asList(
                new Bogie("Sleeper", 72),
                new Bogie("AC Chair", 56)
        );

        long start = System.nanoTime();
        filterUsingLoop(bogies);
        long end = System.nanoTime();

        long duration = end - start;

        assertTrue(duration > 0);
    }

    @Test
    void testLargeDatasetProcessing() {
        List<Bogie> bogies = new ArrayList<>();

        // Create large dataset
        for (int i = 0; i < 100000; i++) {
            bogies.add(new Bogie("Sleeper", 70));
            bogies.add(new Bogie("AC Chair", 50));
        }

        List<Bogie> result = filterUsingStream(bogies);

        // Only bogies with capacity > 60 should remain
        assertTrue(result.size() > 0);

        for (Bogie b : result) {
            assertTrue(b.getCapacity() > 60);
        }
    }
}