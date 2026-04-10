import org.junit.jupiter.api.Test;
import java.util.*;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

public class TrainConsistManagementAppUC8Test {

    // Reusing Bogie class
    static class Bogie {
        String name;
        int capacity;

        Bogie(String name, int capacity) {
            this.name = name;
            this.capacity = capacity;
        }
    }

    // Method to filter bogies (common method for all tests)
    private List<Bogie> filterBogies(List<Bogie> bogies, int threshold) {
        return bogies.stream()
                .filter(b -> b.capacity > threshold)
                .collect(Collectors.toList());
    }

    @Test
    void testFilter_CapacityGreaterThanThreshold() {
        List<Bogie> bogies = Arrays.asList(
                new Bogie("S1", 80),
                new Bogie("S2", 60)
        );

        List<Bogie> result = filterBogies(bogies, 70);

        assertEquals(1, result.size());
        assertEquals("S1", result.get(0).name);
    }

    @Test
    void testFilter_CapacityEqualToThreshold() {
        List<Bogie> bogies = Arrays.asList(
                new Bogie("S1", 70)
        );

        List<Bogie> result = filterBogies(bogies, 70);

        assertTrue(result.isEmpty());
    }

    @Test
    void testFilter_CapacityLessThanThreshold() {
        List<Bogie> bogies = Arrays.asList(
                new Bogie("S1", 50)
        );

        List<Bogie> result = filterBogies(bogies, 70);

        assertTrue(result.isEmpty());
    }

    @Test
    void testFilter_MultipleBogiesMatching() {
        List<Bogie> bogies = Arrays.asList(
                new Bogie("S1", 80),
                new Bogie("S2", 75),
                new Bogie("S3", 60)
        );

        List<Bogie> result = filterBogies(bogies, 70);

        assertEquals(2, result.size());
    }

    @Test
    void testFilter_NoBogiesMatching() {
        List<Bogie> bogies = Arrays.asList(
                new Bogie("S1", 50),
                new Bogie("S2", 60)
        );

        List<Bogie> result = filterBogies(bogies, 70);

        assertTrue(result.isEmpty());
    }

    @Test
    void testFilter_AllBogiesMatching() {
        List<Bogie> bogies = Arrays.asList(
                new Bogie("S1", 80),
                new Bogie("S2", 90)
        );

        List<Bogie> result = filterBogies(bogies, 70);

        assertEquals(2, result.size());
    }

    @Test
    void testFilter_EmptyBogieList() {
        List<Bogie> bogies = new ArrayList<>();

        List<Bogie> result = filterBogies(bogies, 70);

        assertTrue(result.isEmpty());
    }

    @Test
    void testFilter_OriginalListUnchanged() {
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("S1", 80));
        bogies.add(new Bogie("S2", 60));

        int originalSize = bogies.size();

        List<Bogie> result = filterBogies(bogies, 70);

        // Original list should remain unchanged
        assertEquals(originalSize, bogies.size());
        assertEquals(2, bogies.size());
    }
}