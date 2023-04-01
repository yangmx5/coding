package hotOneHundred.dp;

import common.CommonUtil;

/**
 * @date 2023/3/27
 * 最长递增子序列
 */
public class LongestChildSequence {

    public static void main(String[] args) {
        int[] arr = new int[]{2, 3, 4, 1, 5};

        //dp[i] 表示以 i 为结尾的最长子序列的长度
        int[] dp = new int[arr.length];

        //basecase 第一位最长长度为1
        dp[0] = 1;

        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        CommonUtil.printArray(dp);
    }

}
