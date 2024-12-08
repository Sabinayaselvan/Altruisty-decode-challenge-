import java.util.*;

public class ZSCSStrengthTest {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int trainees = 4;
        int rounds = 3;
        int[][] strength = new int[rounds][trainees];
        boolean invalidInput = false;

        for (int i = 0; i < rounds; i++) {
            for (int j = 0; j < trainees; j++) {
                int value = sc.nextInt();
                if (value < 1 || value > 200) {
                    System.out.println("INVALID INPUT");
                    invalidInput = true;
                    break;
                }
                strength[i][j] = value;
            }
            if (invalidInput)
                return;
        }

        int[] averages = new int[trainees];
        for (int j = 0; j < trainees; j++) {
            int sum = 0;
            for (int i = 0; i < rounds; i++) {
                sum += strength[i][j];
            }
            averages[j] = (int) Math.round(sum / (double) rounds);
        }

        int maxAverage = Arrays.stream(averages).max().orElse(0);

        if (maxAverage < 100) {
            System.out.println("All trainees are unfit.");
            return;
        }

        System.out.println("Trainee Number:");
        for (int j = 0; j < trainees; j++) {
            if (averages[j] == maxAverage) {
                System.out.println(j + 1);
            }
        }
    }
}
