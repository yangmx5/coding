package hotOneHundred;

import common.CommonUtil;

/**
 * @date 2023/3/27
 * 数组整体翻转， 将 3,4,5,6,9,8 从 k 位翻转
 * k = 1 时
 * 输出:5,6,9,8,3,4
 */
public class ZeroOneBag {

    public static void main(String[] args) {
        int[] weight = new int[]{2, 1, 3};
        int[] val = new int[]{4, 2, 3};
        int bagWeight = 4;

        int length = weight.length;

        int[][] dp = new int[length][bagWeight];
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 0;
        }

        for (int i = 0; i < dp[0].length; i++) {
            dp[0][i] = 0;
        }

        for (int i = 1; i < length; i++) {
            for (int j = 1; j < bagWeight; j++) {
                if (j - weight[i - 1] >= 0) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i - 1]] + val[i - 1]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        printDp(dp);

        System.out.println(dp[length - 1][bagWeight - 1]);

        int[][] dp2 = tryAgain(weight, val, bagWeight);
        printDp(dp2);

    }

    public static int[][] tryAgain(int[] weight, int[] val, int bagWeight) {
        int n = weight.length;
        int m = bagWeight;
        int[][] dp = new int[n][m];
        for (int i = 0; i < m; i++) {
            dp[0][i] = 0;
        }

        for (int i = 0; i < n; i++) {
            dp[i][0] = 0;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (j - weight[i-1] < 0) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i - 1]] + val[i - 1]);
                }
            }
        }
        return dp;
    }

    public static void printDp(int[][] dp) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                builder.append(dp[i][j] + ",");
            }
            builder.append("\n");
        }

        System.out.println(builder.toString());
    }

}
