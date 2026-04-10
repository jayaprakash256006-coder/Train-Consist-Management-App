import java.util.*;
import java.util.stream.Collectors;

public class UseCase13TrainConsistigent {

    // Bogie model
    static class Bogie {
        String type;
        int capacity;

        public Bogie(String type, int capacity) {
            this.type = type;
            this.capacity = capacity;
        }

        public String getType() {
            return type;
        }

        public int getCapacity() {
            return capacity;
        }
    }

    public static void main(String[] args) {

        System.out.println("==============================================");
        System.out.println("UC13 Performance Comparison (Loops vs Streams)");
        System.out.println("==============================================");

        // Create large dataset
        List<Bogie> bogies = new ArrayList<>();
        for (int i = 0; i < 100000; i++) {
            bogies.add(new Bogie("Sleeper", 70 + (i % 10)));
            bogies.add(new Bogie("AC Chair", 50 + (i % 5)));
            bogies.add(new Bogie("First Class", 20 + (i % 3)));
        }

        // -------------------------------
        // Loop-based filtering
        // -------------------------------
        long loopStart = System.nanoTime();

        List<Bogie> loopResult = new ArrayList<>();
        for (Bogie b : bogies) {
            if (b.getCapacity() > 60) {
                loopResult.add(b);
            }
        }

        long loopEnd = System.nanoTime();
        long loopTime = loopEnd - loopStart;

        // -------------------------------
        // Stream-based filtering
        // -------------------------------
        long streamStart = System.nanoTime();

        List<Bogie> streamResult = bogies.stream()
                .filter(b -> b.getCapacity() > 60)
                .collect(Collectors.toList());

        long streamEnd = System.nanoTime();
        long streamTime = streamEnd - streamStart;

        // Display results
        System.out.println("\nLoop Execution Time (ns): " + loopTime);
        System.out.println("Stream Execution Time (ns): " + streamTime);

        System.out.println("\nUC13 performance benchmarking completed...");
    }
}