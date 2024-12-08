import java.util.*;

public class BeesBetweenFlowers {

    public static List<Integer> countBees(String s, int[] startIndex, int[] endIndex) {
        List<Integer> result = new ArrayList<>();

        List<Integer> flowerPositions = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '\'') {
                flowerPositions.add(i);
            }
        }

        for (int i = 0; i < startIndex.length; i++) {
            int start = startIndex[i] - 1;
            int end = endIndex[i] - 1;

            int leftFlower = -1;
            int rightFlower = -1;

            for (int pos : flowerPositions) {
                if (pos >= start && leftFlower == -1) {
                    leftFlower = pos;
                }
                if (pos > end) {
                    break;
                }
                rightFlower = pos;
            }

            if (leftFlower == -1 || rightFlower == -1 || leftFlower >= rightFlower) {
                result.add(0);
                continue;
            }

            int beeCount = 0;
            for (int j = leftFlower + 1; j < rightFlower; j++) {
                if (s.charAt(j) == '*') {
                    beeCount++;
                }
            }

            result.add(beeCount);
        }

        return result;
    }

    public static void main(String[] args) {

        String s = "|*|**|";
        int[] startIndex = { 1, 2 };
        int[] endIndex = { 5, 6 };

        List<Integer> result = countBees(s, startIndex, endIndex);
        for (int count : result) {
            System.out.println(count);
        }
    }
}
