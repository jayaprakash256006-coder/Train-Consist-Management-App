import java.util.Arrays;

public class UseCase17TrainConsistMgant {

    // Method for sorting (IMPORTANT for test cases)
    public static String[] sortBogieNames(String[] bogieNames) {
        Arrays.sort(bogieNames);
        return bogieNames;
    }

    public static void main(String[] args) {

        System.out.println("==============================================");
        System.out.println("UC17 Sort Bogie Names Using Arrays.sort()");
        System.out.println("==============================================");

        String[] bogieNames = {
                "Sleeper", "AC Chair", "First Class", "General", "Luxury"
        };

        System.out.println("Original Bogie Names:");
        System.out.println(Arrays.toString(bogieNames));

        sortBogieNames(bogieNames);

        System.out.println("\nSorted Bogie Names (Alphabetical):");
        System.out.println(Arrays.toString(bogieNames));

        System.out.println("\nUC17 sorting completed...");
    }
}