import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Train Consist Management App
 * Use Case 5: Preserve Insertion Order of Bogies
 * Author: Developer
 * Version: 5.0
 */
public class TrainConsistManagementAppUC5 {

    public static void main(String[] args) {

        System.out.println("======================================");
        System.out.println("UC5 Preserve Insertion Order of Bogies");
        System.out.println("======================================");

        // LinkedHashSet preserves order and ensures uniqueness
        Set<String> formation = new LinkedHashSet<>();

        // Attach bogies in sequence
        formation.add("Engine");
        formation.add("Sleeper");
        formation.add("Cargo");
        formation.add("Guard");

        // Attempt duplicate insertion
        formation.add("Sleeper");

        // Display final train formation
        System.out.println("\nFinal Train Formation:");
        System.out.println(formation);

        System.out.println("\nNote:");
        System.out.println("LinkedHashSet preserves insertion order and removes duplicates automatically.");

        System.out.println("\nUC5 formation setup completed...");
    }
}