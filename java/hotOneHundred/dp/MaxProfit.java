package hotOneHundred.dp;

import java.util.Arrays;

/**
 * @author fouthed
 * @date 2023/4/11
 */
public class MaxProfit {

    public static void main(String[] args) {
        int[] price = new int[]{1, 2, 3, 0, 2};

        System.out.println(resolve(price));
        // ret = 3
    }

    public static int resolve(int[] price) {
        int n = price.length;
        if (n <= 1) {
            return 0;
        }
        int[][] dp = new int[n][3];
        //dp[i][0] 第i天持有股票的收益
        //dp[i][1] 第i天卖出处于冷冻期的收益
        //dp[i][2] 第i天卖出不处于冷冻期的收益
        dp[0][0] = -price[0];
        dp[0][1] = 0;
        dp[0][2] = 0;
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][2] - price[i]);
            dp[i][1] = dp[i - 1][0] + price[i];
            dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][1]);
        }
        int max = Math.max(dp[n - 1][1], dp[n - 1][2]);

        printArray(dp);

        return max;
    }

    public static void printArray(int[][] dp) {
        StringBuilder builder = new StringBuilder();
        for (int[] list : dp) {
            for (int n : list) {
                builder.append(n + ",");
            }
            builder.append("\n");
        }
        System.out.println(builder.toString());
    }
}
