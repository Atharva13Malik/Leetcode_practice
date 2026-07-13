import java.util.*;

public class Main {
    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int arr[] = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // LIS ending at every index
        int lis[] = new int[n];
        Arrays.fill(lis, 1);

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    lis[i] = Math.max(lis[i], lis[j] + 1);
                }
            }
        }

        // LDS starting from every index
        int lds[] = new int[n];
        Arrays.fill(lds, 1);

        for (int i = n - 2; i >= 0; i--) {
            for (int j = n - 1; j > i; j--) {
                if (arr[i] > arr[j]) {
                    lds[i] = Math.max(lds[i], lds[j] + 1);
                }
            }
        }

        int maxMountain = 0;

        for (int i = 1; i < n - 1; i++) {

            // Peak ke left aur right dono side hona chahiye
            if (lis[i] > 1 && lds[i] > 1) {
                maxMountain = Math.max(maxMountain,
                        lis[i] + lds[i] - 1);
            }
        }

        int ans = n - maxMountain;

        System.out.println(ans);

        sc.close();
    }
}
