import java.util.ArrayList;
import java.util.List;

/**
 * Train Consist Management App
 * Use Case 2: Add Passenger Bogies to Train
 * Author: Developer
 * Version: 2.0
 */
public class TrainConsistManagementAppUC2 {

    public static void main(String[] args) {

        // Display UC2 heading
        System.out.println("======================================");
        System.out.println("UC2 Add Passenger Bogies to Train");
        System.out.println("======================================");

        // Create an ArrayList to hold passenger bogies
        List<String> passengerBogies = new ArrayList<>();

        // CREATE (Add bogies)
        passengerBogies.add("Sleeper");
        passengerBogies.add("AC Chair");
        passengerBogies.add("First Class");

        // READ (Display after adding)
        System.out.println("\nAfter Adding Bogies:");
        System.out.println("Passenger Bogies: " + passengerBogies);

        // DELETE (Remove one bogie)
        passengerBogies.remove("AC Chair");

        // READ (Display after removing)
        System.out.println("\nAfter Removing \"AC Chair\":");
        System.out.println("Passenger Bogies: " + passengerBogies);

        // CHECK existence using contains()
        System.out.println("\nChecking if 'Sleeper' exists:");
        System.out.println("Contains Sleeper?: " + passengerBogies.contains("Sleeper"));

        // Final consist
        System.out.println("\nFinal Train Passenger Consist:");
        System.out.println(passengerBogies);

        System.out.println("\nUC2 operations completed successfully...");
    }
}