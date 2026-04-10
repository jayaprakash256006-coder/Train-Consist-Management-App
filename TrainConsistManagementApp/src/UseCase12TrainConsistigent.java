import java.util.*;

public class UseCase12TrainConsistigent {

    // Goods Bogie model
    static class GoodsBogie {
        String type;
        String cargo;

        public GoodsBogie(String type, String cargo) {
            this.type = type;
            this.cargo = cargo;
        }

        public String getType() {
            return type;
        }

        public String getCargo() {
            return cargo;
        }
    }

    public static void main(String[] args) {

        System.out.println("==========================================");
        System.out.println("UC12 Safety Compliance Check for Goods Bogies");
        System.out.println("==========================================");

        // Create goods bogie list
        List<GoodsBogie> goodsBogies = new ArrayList<>();

        goodsBogies.add(new GoodsBogie("Cylindrical", "Petroleum"));
        goodsBogies.add(new GoodsBogie("Open", "Coal"));
        goodsBogies.add(new GoodsBogie("Box", "Grain"));
        goodsBogies.add(new GoodsBogie("Cylindrical", "Coal")); // ❌ Unsafe

        // Display goods bogies
        System.out.println("\nGoods Bogies in Train:");
        for (GoodsBogie g : goodsBogies) {
            System.out.println(g.getType() + " -> " + g.getCargo());
        }

        // SAFETY VALIDATION USING allMatch()
        boolean isSafe = goodsBogies.stream()
                .allMatch(g ->
                        // Rule: Cylindrical → only Petroleum allowed
                        !g.getType().equalsIgnoreCase("Cylindrical")
                                || g.getCargo().equalsIgnoreCase("Petroleum")
                );

        // Display result
        System.out.println("\nSafety Compliance Status: " + isSafe);

        if (isSafe) {
            System.out.println("Train formation is SAFE.");
        } else {
            System.out.println("Train formation is NOT SAFE.");
        }

        System.out.println("\nUC12 safety validation completed...");
    }
}