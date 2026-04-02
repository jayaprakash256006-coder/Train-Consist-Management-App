import java.util.HashMap;
import java.util.Map;

/**
 * Train Consist Management App
 * Use Case 6: Map Bogie to Capacity (HashMap)
 * Author: Developer
 * Version: 6.0
 */
public class TrainConsistManagementAppUC6 {

    public static void main(String[] args) {

        System.out.println("======================================");
        System.out.println("UC6 Map Bogie to Capacity (HashMap)");
        System.out.println("======================================");

        // HashMap stores data in key-value format
        Map<String, Integer> capacityMap = new HashMap<>();

        // Insert bogie capacities
        capacityMap.put("Sleeper", 72);
        capacityMap.put("AC Chair", 56);
        capacityMap.put("First Class", 24);
        capacityMap.put("Cargo", 120);

        // Display capacity details
        System.out.println("\nBogie Capacity Details:");
        for (Map.Entry<String, Integer> entry : capacityMap.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        System.out.println("\nUC6 bogie-capacity mapping completed...");
    }
}