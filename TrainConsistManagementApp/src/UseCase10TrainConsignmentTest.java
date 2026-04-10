import org.junit.jupiter.api.Test;
import java.util.*;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

public class UseCase10TrainConsignmentTest {

    // Reusing Bogie class
    static class Bogie {
        String name;
        int capacity;

        public Bogie(String name, int capacity) {
            this.name = name;
            this.capacity = capacity;
        }

        public int getCapacity() {
            return capacity;
        }
    }

    // Helper method for reduce operation
    private int calculateTotalSeats(List<Bogie> bogies) {
        return bogies.stream()
                .map(b -> b.getCapacity())
                .reduce(0, Integer::sum);
    }

    @Test
    void testReduce_TotalSeatCalculation() {
        List<Bogie> bogies = Arrays.asList(
                new Bogie("Sleeper", 72),
                new Bogie("AC Chair", 56),
                new Bogie("First Class", 24),
                new Bogie("Sleeper", 70)
        );

        int total = calculateTotalSeats(bogies);

        assertEquals(222, total);
    }

    @Test
    void testReduce_MultipleBogiesAggregation() {
        List<Bogie> bogies = Arrays.asList(
                new Bogie("Sleeper", 50),
                new Bogie("AC Chair", 30),
                new Bogie("First Class", 20)
        );

        int total = calculateTotalSeats(bogies);

        assertEquals(100, total);
    }

    @Test
    void testReduce_SingleBogieCapacity() {
        List<Bogie> bogies = Collections.singletonList(
                new Bogie("Sleeper", 80)
        );

        int total = calculateTotalSeats(bogies);

        assertEquals(80, total);
    }

    @Test
    void testReduce_EmptyBogieList() {
        List<Bogie> bogies = new ArrayList<>();

        int total = calculateTotalSeats(bogies);

        assertEquals(0, total);
    }

    @Test
    void testReduce_CorrectCapacityExtraction() {
        List<Bogie> bogies = Arrays.asList(
                new Bogie("Sleeper", 10),
                new Bogie("AC Chair", 20)
        );

        // Extract capacities manually
        List<Integer> expectedCapacities = Arrays.asList(10, 20);

        List<Integer> actualCapacities = bogies.stream()
                .map(Bogie::getCapacity)
                .collect(Collectors.toList());

        assertEquals(expectedCapacities, actualCapacities);
    }

    @Test
    void testReduce_AllBogiesIncluded() {
        List<Bogie> bogies = Arrays.asList(
                new Bogie("Sleeper", 10),
                new Bogie("Sleeper", 20),
                new Bogie("Sleeper", 30)
        );

        int total = calculateTotalSeats(bogies);

        assertEquals(60, total);
    }

    @Test
    void testReduce_OriginalListUnchanged() {
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 56));

        int originalSize = bogies.size();

        calculateTotalSeats(bogies);

        // Verify original list unchanged
        assertEquals(originalSize, bogies.size());
        assertEquals(2, bogies.size());
    }
}