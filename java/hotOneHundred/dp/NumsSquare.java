package hotOneHundred.dp;

import java.util.Arrays;

public class NumsSquare {
    public static void main(String[] args) {
        System.out.println(numSquares(3));
    }

    public static int numSquares(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;

        for (int i = 1; i < dp.length; i++) {
            dp[i] = i;
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }

        System.out.println(Arrays.toString(dp));

        return dp[n];
    }


}
