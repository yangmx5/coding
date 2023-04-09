package hotOneHundred.dp;

import java.util.Arrays;

/**
 * @date 2023/4/6
 */
public class DifferentPathSum {

    public static void main(String[] args) {
        System.out.println(dp(3,3));

    }

    public static int dp(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 1;
        }
        for (int j = 0; j < dp[0].length; j++) {
            dp[0][j] = 1;
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        for (int[] subDp : dp) {
            System.out.println(Arrays.toString(subDp));
        }

        return dp[m - 1][n - 1];
    }
}
