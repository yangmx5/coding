package hotOneHundred.dp;

import javax.swing.*;

/**
 * 现在给你输入一个二维数组 grid，其中的元素都是非负整数，现在你站在左上角，只能向右或者向下移动，需要到达右下角。现在请你计算，经过的路径和最小是多少？
 */
public class minPathSum {

    public static void main(String[] args) {
        int[][] grid = new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};

        printDp(grid);


        System.out.println(minPathSum(grid));

    }

    public static int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < dp[0].length; i++) {
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        }
        for (int i = 1; i < dp.length; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        //dp[i][j] = Math.min(dp[i-1][j],dp[i][j-1]);
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                int count = grid[i][j];
                dp[i][j] = Math.min(dp[i - 1][j] + count, dp[i][j - 1] + count);
            }
        }
        printDp(dp);
        return dp[m - 1][n - 1];
    }

    public static void printDp(int[][] dp) {
        StringBuffer str = new StringBuffer();
        for (int[] i : dp) {
            for (int j : i) {
                str.append(j + ",");
            }
            str.append("\n");
        }
        System.out.println(str.toString());
    }

}
