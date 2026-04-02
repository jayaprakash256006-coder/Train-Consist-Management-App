import java.util.HashSet;
import java.util.Set;

/**
 * Train Consist Management App
 * Use Case 3: Track Unique Bogie IDs
 * Author: Developer
 * Version: 3.0
 */
public class TrainConsistManagementAppUC3 {

    public static void main(String[] args) {

        System.out.println("======================================");
        System.out.println("UC3 Track Unique Bogie IDs");
        System.out.println("======================================");

        // Create a Set to store unique bogie IDs
        // HashSet stores only unique values
        Set<String> bogies = new HashSet<>();

        // Add bogie IDs (including duplicates intentionally)
        bogies.add("BG101");
        bogies.add("BG102");
        bogies.add("BG103");
        bogies.add("BG104");

        // Duplicate entries - these will be ignored automatically
        bogies.add("BG101");
        bogies.add("BG102");

        // Display final unique bogie IDs
        System.out.println("\nBogie IDs After Insertion:");
        System.out.println(bogies);

        System.out.println("\nNote:");
        System.out.println("Duplicates are automatically ignored by HashSet.");

        System.out.println("\nUC3 uniqueness validation completed...");
    }
}