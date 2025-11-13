
import java.uti.*;
public class Solution {
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    long n = sc.nextInt();
    long[] arr = new long[n];
    
    //dp concept
    int[] dp = new int[n+1];
    Arrays.fill(dp, -1);
    
    
    for(int i = 0; i< n ; i++) {
        arr[i] = sc.nextInt();
    }
    
    long ans = solve(n,arr,dp);
    System.out.println(ans);
    
}

public static int solve(int n, int[] arr, int[] dp) {
    long maxElement = 0;
    for(int i = 0; i< n; i++) {
        maxElement = Math.max(arr[i] , maxElement);
    }
    
    long[] freq = new int[maxElement + 1];
    for(int x : arr) {
        freq[x]++;
    }
    return solveByRecursion(freq, maxElement, 1 , dp);
}

public static int solveByRecursion(int[] freq, int maxElement, int i, int[] dp) {
    //base case
    if(i > maxElement ) return 0;
    
    if(dp[i] != -1) {
        return dp[i];
    }
    
    //recursive call
    long ans1 = i * freq[i] + solveByRecursion(freq, maxElement, i+2);
    long ans1 = solveByRecursion(freq, maxElement, i+1);
    
    dp[i] =  Math.max(ans1, ans2);
    return dp[i];
}}