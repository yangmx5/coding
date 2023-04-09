package hotOneHundred.dp;

import java.util.Arrays;

/**
 * @author fouthed
 * @date 2023/4/6
 */
public class NumsTree {

    public static void main(String[] args) {
        System.out.println(resolve(3));
    }

    public static int resolve(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }


        System.out.println(Arrays.toString(dp));
        return dp[n];
    }
}
