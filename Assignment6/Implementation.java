import java.util.*;

public class Implementation {
    public static int uniquePathsWithObstacles(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[m][n];
        for (int[] a : dp) Arrays.fill(a, -1);
        return f(m - 1, n - 1, grid, dp);
    }

    private static int f(int i, int j, int[][] g, int[][] dp) {
        if (i < 0 || j < 0 || g[i][j] == 1) return 0;
        if (i == 0 && j == 0) return 1;
        if (dp[i][j] != -1) return dp[i][j];
        return dp[i][j] = f(i - 1, j, g, dp) + f(i, j - 1, g, dp);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Unique Paths II");
        System.out.print("Enter m and n: ");
        int m = sc.nextInt(), n = sc.nextInt();
        int[][] grid = new int[m][n];
        System.out.println("Enter grid (0/1):");
        for (int i = 0; i < m; i++) for (int j = 0; j < n; j++) grid[i][j] = sc.nextInt();
        System.out.println("Unique Paths = " + uniquePathsWithObstacles(grid));
    }
}


class DungeonGame {
    static int[][] dp;
    public static int calculateMinimumHP(int[][] d) {
        int m = d.length, n = d[0].length;
        dp = new int[m][n];
        for (int[] a : dp) Arrays.fill(a, -1);
        return solve(0, 0, d);
    }
    static int solve(int i, int j, int[][] d) {
        int m = d.length, n = d[0].length;
        if (i == m - 1 && j == n - 1) return Math.max(1, 1 - d[i][j]);
        if (i >= m || j >= n) return (int) 1e9;
        if (dp[i][j] != -1) return dp[i][j];
        int right = solve(i, j + 1, d);
        int down = solve(i + 1, j, d);
        int need = Math.min(right, down) - d[i][j];
        return dp[i][j] = Math.max(1, need);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Dungeon Game");
        int m = sc.nextInt(), n = sc.nextInt();
        int[][] d = new int[m][n];
        for (int i = 0; i < m; i++) for (int j = 0; j < n; j++) d[i][j] = sc.nextInt();
        System.out.println("Minimum Health = " + calculateMinimumHP(d));
    }
}


class TwoFingerTyping {
    static Integer[][][] dp;
    static int dist(int a, int b) {
        if (a == 26 || b == 26) return 0;
        return Math.abs(a / 6 - b / 6) + Math.abs(a % 6 - b % 6);
    }
    static int f(int i, int l, int r, String s) {
        if (i == s.length()) return 0;
        if (dp[i][l][r] != null) return dp[i][l][r];
        int c = s.charAt(i) - 'A';
        int left = dist(l, c) + f(i + 1, c, r, s);
        int right = dist(r, c) + f(i + 1, l, c, s);
        return dp[i][l][r] = Math.min(left, right);
    }
    public static int minimumDistance(String s) {
        dp = new Integer[s.length() + 1][27][27];
        return f(0, 26, 26, s);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Minimum Distance Typing");
        String s = sc.next();
        System.out.println("Min Distance = " + minimumDistance(s));
    }
}


class FallingPathSumII {
    static int[][] dp;
    static int f(int i, int j, int[][] g) {
        int n = g.length;
        if (j < 0 || j >= n) return (int) 1e9;
        if (i == n - 1) return g[i][j];
        if (dp[i][j] != -1) return dp[i][j];
        int min = (int) 1e9;
        for (int k = 0; k < n; k++) if (k != j) min = Math.min(min, f(i + 1, k, g));
        return dp[i][j] = g[i][j] + min;
    }
    public static int minFallingPathSum(int[][] g) {
        int n = g.length;
        dp = new int[n][n];
        for (int[] a : dp) Arrays.fill(a, -1);
        int ans = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++) ans = Math.min(ans, f(0, j, g));
        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Minimum Falling Path Sum II");
        int n = sc.nextInt();
        int[][] g = new int[n][n];
        for (int i = 0; i < n; i++) for (int j = 0; j < n; j++) g[i][j] = sc.nextInt();
        System.out.println("Min Sum = " + minFallingPathSum(g));
    }
}


class OptimalDivision {
    public static String optimalDivision(int[] a) {
        if (a.length == 1) return a[0] + "";
        if (a.length == 2) return a[0] + "/" + a[1];
        StringBuilder s = new StringBuilder(a[0] + "/(");
        for (int i = 1; i < a.length; i++) {
            s.append(a[i]);
            if (i != a.length - 1) s.append("/");
        }
        return s.append(")").toString();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Optimal Division");
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = sc.nextInt();
        System.out.println("Result = " + optimalDivision(a));
    }
}
