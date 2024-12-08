import java.util.*;

public class CandyFlavourFinder {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();

        if (n < 3 || n > 50) {
            System.out.println("INVALID INPUT");
            return;
        }

        String[] flavours = new String[n];
        for (int i = 0; i < n; i++) {
            flavours[i] = sc.nextLine();
        }

        Map<String, Integer> flavourCount = new LinkedHashMap<>();
        for (String flavour : flavours) {
            flavourCount.put(flavour, flavourCount.getOrDefault(flavour, 0) + 1);
        }

        for (String flavour : flavours) {
            if (flavourCount.get(flavour) % 2 != 0) {
                System.out.println(flavour);
                return;
            }
        }

        System.out.println("All are even");
    }
}