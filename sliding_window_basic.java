import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Input number of hours
        int n = sc.nextInt();

        // Input songs listened each hour
        int[] arr = new int[n];

        for(int i = 0; i < n; i++)
        {
            arr[i] = sc.nextInt();
        }

        // Input K
        int k = sc.nextInt();

        int windowSum = 0;

        // First window
        for(int i = 0; i < k; i++)
        {
            windowSum += arr[i];
        }

        int maxSum = windowSum;

        // Sliding Window
        for(int i = k; i < n; i++)
        {
            windowSum = windowSum + arr[i] - arr[i-k];

            if(windowSum > maxSum)
            {
                maxSum = windowSum;
            }
        }

        System.out.println("Maximum songs listened in any " + k + " consecutive hours: " + maxSum);
    }
}
