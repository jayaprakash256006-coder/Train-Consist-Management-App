import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Train Consist Management App
 * Use Case 7: Sort Bogies by Capacity (Comparator)
 * Author: Developer
 * Version: 7.0
 */
public class TrainConsistManagementAppUC8 {

    // Inner Bogie class to model passenger bogies
    static class Bogie {
        String name;
        int capacity;

        Bogie(String name, int capacity) {
            this.name = name;
            this.capacity = capacity;
        }

        @Override
        public String toString() {
            return name + " -> " + capacity;
        }
    }

    public static void main(String[] args) {

        System.out.println("======================================");
        System.out.println("UC7 Sort Bogies by Capacity (Comparator)");
        System.out.println("======================================");

        // Create list of passenger bogies
        List<Bogie> bogies = new ArrayList<>();

        // Add bogies with capacities
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 56));
        bogies.add(new Bogie("First Class", 24));
        bogies.add(new Bogie("General", 90));

        // Display before sorting
        System.out.println("\nBefore Sorting:");
        for (Bogie b : bogies) {
            System.out.println(b);
        }

        // Sort using Comparator based on capacity
        List<Bogie> filteredBogies = bogies.stream()
                .filter(b -> b.capacity > 70)
                .collect(Collectors.toList());

        // Display after sorting
        System.out.println("\nAfter Sorting by Capacity:");
        for (Bogie b : bogies) {
            System.out.println(b);
        }

        System.out.println("\nUC7 sorting completed...");
    }
}