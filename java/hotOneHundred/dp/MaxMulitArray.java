package hotOneHundred.dp;

import java.util.Arrays;

/**
 * @author fouthed
 * @date 2023/4/6
 */
public class MaxMulitArray {

    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, -2, 4};
        int[] nums2 = new int[]{-2, 0, -1};
        System.out.println(dp(nums));
        System.out.println(dp(nums2));

    }

    public static int dp(int[] nums) {
        int[] dp = new int[nums.length];
        int max = nums[0];
        dp[0] = nums[0];
        for (int i = 1; i < dp.length; i++) {
            dp[i] = Math.max(nums[i], dp[i - 1] * nums[i]);
            max = Math.max(max, dp[i]);
        }
        System.out.println(Arrays.toString(dp));
        return max;
    }
}
