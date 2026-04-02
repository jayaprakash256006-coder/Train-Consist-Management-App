import java.util.LinkedList;

/**
 * Train Consist Management App
 * Use Case 4: Maintain Ordered Bogie Consist
 * Author: Developer
 * Version: 4.0
 */
public class TrainConsistManagementAppUC4 {

    public static void main(String[] args) {

        System.out.println("======================================");
        System.out.println("UC4 Maintain Ordered Bogie Consist");
        System.out.println("======================================");

        // Create LinkedList
        // LinkedList maintains insertion order and allows fast inserts/removals
        LinkedList<String> trainConsist = new LinkedList<>();

        // Add bogies in sequence
        trainConsist.add("Engine");
        trainConsist.add("Sleeper");
        trainConsist.add("AC");
        trainConsist.add("Cargo");
        trainConsist.add("Guard");

        // Display initial consist
        System.out.println("\nInitial Train Consist:");
        System.out.println(trainConsist);

        // Insert Pantry Car at position 2
        trainConsist.add(2, "Pantry Car");

        System.out.println("\nAfter Inserting 'Pantry Car' at position 2:");
        System.out.println(trainConsist);

        // Remove first and last bogie
        trainConsist.removeFirst();
        trainConsist.removeLast();

        System.out.println("\nAfter Removing First and Last Bogie:");
        System.out.println(trainConsist);

        System.out.println("\nUC4 ordered consist operations completed....");
    }
}