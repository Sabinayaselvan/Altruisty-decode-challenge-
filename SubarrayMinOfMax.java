import java.util.*;

public class SubarrayMinOfMax {

    public static int findMinOfMax(int[] arr, int k) {
        int n = arr.length;
        if (k > n) {
            throw new IllegalArgumentException("Segment length k cannot be greater than array size n.");
        }

        Deque<Integer> deque = new ArrayDeque<>();
        List<Integer> maxInSubarrays = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            while (!deque.isEmpty() && arr[deque.peekLast()] <= arr[i]) {
                deque.pollLast();
            }
            deque.offerLast(i);
        }

        for (int i = k; i < n; i++) {

            maxInSubarrays.add(arr[deque.peekFirst()]);

            while (!deque.isEmpty() && deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }

            while (!deque.isEmpty() && arr[deque.peekLast()] <= arr[i]) {
                deque.pollLast();
            }

            deque.offerLast(i);
        }

        maxInSubarrays.add(arr[deque.peekFirst()]);

        return maxInSubarrays.stream().min(Integer::compareTo).orElseThrow();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        if (k <= 0 || n <= 0) {
            System.out.println("INVALID INPUT");
            return;
        }

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        try {
            int result = findMinOfMax(arr, k);
            System.out.println(result);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
