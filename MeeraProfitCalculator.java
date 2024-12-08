import java.util.Scanner;

public class MeeraProfitCalculator {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();

        int[] prices = new int[n];
        for (int i = 0; i < n; i++) {
            prices[i] = in.nextInt();
        }

        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price;
            } else {
                maxProfit = Math.max(maxProfit, price - minPrice);
            }
        }

        System.out.println(maxProfit);
    }
}