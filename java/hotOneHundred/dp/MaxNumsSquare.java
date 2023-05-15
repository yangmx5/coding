package hotOneHundred.dp;

/**
 * @author fouthed
 * @date 2023/4/10
 */
public class MaxNumsSquare {

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1, 0, 1, 0, 0},
                {1, 0, 1, 1, 1},
                {1, 1, 1, 1, 1},
                {1, 0, 0, 1, 0}
        };

        printArray(matrix);

        System.out.println(resolve(matrix));

    }

    public static int resolve(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];

        int max = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 1) {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    }
                    max = Math.max(max, dp[i][j]);
                }
            }
        }
        printArray(dp);

        return max * max;
    }

    public static void printArray(int[][] array) {
        StringBuffer buffer = new StringBuffer();
        for (int[] arr : array) {
            for (int num : arr) {
                buffer.append(num + ",");
            }
            buffer.append("\n");
        }
        System.out.println(buffer.toString());

    }
}
