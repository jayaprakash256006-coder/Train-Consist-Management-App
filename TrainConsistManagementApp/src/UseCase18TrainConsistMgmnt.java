public class UseCase18TrainConsistMgmnt {

    // Method for Linear Search (useful for testing)
    public static boolean searchBogieId(String[] bogieIds, String searchId) {

        for (String id : bogieIds) {
            if (id.equals(searchId)) {
                return true; // found → early termination
            }
        }

        return false; // not found
    }

    public static void main(String[] args) {

        System.out.println("======================================");
        System.out.println("UC18 Linear Search for Bogie ID");
        System.out.println("======================================");

        // Create array of bogie IDs
        String[] bogieIds = {"BG101", "B6205", "B6309", "B6412", "B6550"};

        // Bogie ID to search
        String searchId = "B6309";

        // Display all bogie IDs
        System.out.println("Available Bogie IDs:");
        for (String id : bogieIds) {
            System.out.println(id);
        }

        // Perform search
        boolean found = searchBogieId(bogieIds, searchId);

        // Display result
        if (found) {
            System.out.println("\nBogie " + searchId + " found in train consist.");
        } else {
            System.out.println("\nBogie " + searchId + " NOT found in train consist.");
        }

        System.out.println("UC18 search completed...");
    }
}