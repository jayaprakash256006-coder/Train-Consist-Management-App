import java.util.*;

public class UseCase14TrainConsistMgant {

    // CUSTOM EXCEPTION
    static class InvalidCapacityException extends Exception {
        public InvalidCapacityException(String message) {
            super(message);
        }
    }

    // Passenger Bogie model with validation
    static class PassengerBogie {
        String type;
        int capacity;

        // Constructor with validation
        public PassengerBogie(String type, int capacity) throws InvalidCapacityException {
            if (capacity <= 0) {
                throw new InvalidCapacityException("Capacity must be greater than zero");
            }
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

        System.out.println("=================================");
        System.out.println("UC14 Handle Invalid Bogie Capacity");
        System.out.println("=================================");

        List<PassengerBogie> bogies = new ArrayList<>();

        try {
            // Valid bogie
            PassengerBogie b1 = new PassengerBogie("Sleeper", 72);
            bogies.add(b1);
            System.out.println("Created Bogie: " + b1.getType() + " -> " + b1.getCapacity());

            // Invalid bogie (will throw exception)
            PassengerBogie b2 = new PassengerBogie("AC Chair", 0);
            bogies.add(b2); // This line will not execute

        } catch (InvalidCapacityException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("\nUC14 exception handling completed...");
    }
}