import java.util.*;

public class Main {

    public static boolean canFinish(int[] piles, int k, int h) {

        long hrs = 0;

        for (int pile : piles) {

            hrs += (pile + k - 1) / k;

            if (hrs > h)
                return false;
        }

        return true;
    }

    public static int minEatingSpeed(int[] piles, int h) {

        int low = 1;
        int high = 0;

        for (int pile : piles)
            high = Math.max(high, pile);

        int ans = high;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (canFinish(piles, mid, h)) {

                ans = mid;
                high = mid - 1;

            } else {

                low = mid + 1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] piles = new int[n];

        for (int i = 0; i < n; i++)
            piles[i] = sc.nextInt();

        int h = sc.nextInt();

        System.out.println(minEatingSpeed(piles, h));
    }
}
