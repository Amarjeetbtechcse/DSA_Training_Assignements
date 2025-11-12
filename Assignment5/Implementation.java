import java.util.*;

public class Implementation {
    public static long nCr(int n, int r) {
        int mod = 1000000007;
        if (r > n) return 0;
        long[][] dp = new long[n + 1][r + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= Math.min(i, r); j++) {
                if (j == 0 || j == i)
                    dp[i][j] = 1;
                else
                    dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j]) % mod;
            }
        }
        return dp[n][r];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("nCr Calculation");
        System.out.print("Enter n and r: ");
        int n = sc.nextInt();
        int r = sc.nextInt();
        System.out.println("nCr = " + nCr(n, r));
    }
}


class TribonacciSolution {
    static int[] dp;

    public static int tribonacci(int n) {
        dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return solve(n);
    }

    private static int solve(int n) {
        if (n == 0) return 0;
        if (n == 1 || n == 2) return 1;
        if (dp[n] != -1) return dp[n];
        return dp[n] = solve(n - 1) + solve(n - 2) + solve(n - 3);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Q2: Tribonacci Number");
        System.out.print("Enter n: ");
        int n = sc.nextInt();
        System.out.println("Tribonacci = " + tribonacci(n));
    }
}


class MinCostStairs {
    static int[] dp;

    public static int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        dp = new int[n];
        Arrays.fill(dp, -1);
        return Math.min(helper(cost, n - 1), helper(cost, n - 2));
    }

    private static int helper(int[] cost, int i) {
        if (i < 0) return 0;
        if (i == 0 || i == 1) return cost[i];
        if (dp[i] != -1) return dp[i];
        return dp[i] = cost[i] + Math.min(helper(cost, i - 1), helper(cost, i - 2));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Min Cost Climbing Stairs");
        System.out.print("Enter number of steps: ");
        int n = sc.nextInt();
        int[] cost = new int[n];
        System.out.println("Enter step costs:");
        for (int i = 0; i < n; i++) cost[i] = sc.nextInt();
        System.out.println("Min Cost = " + minCostClimbingStairs(cost));
    }
}


class Boredom {
    public static long solveBoredom(int[] arr) {
        int max = 0;
        for (int x : arr) max = Math.max(max, x);

        long[] freq = new long[max + 1];
        for (int x : arr) freq[x]++;

        long[] dp = new long[max + 1];
        dp[0] = 0;
        dp[1] = freq[1];

        for (int i = 2; i <= max; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + freq[i] * i);
        }
        return dp[max];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Boredom Problem");
        System.out.print("Enter size of array: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter elements:");
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
        System.out.println("Max Sum = " + solveBoredom(arr));
    }
}
