package hotOneHundred.dp;

import java.util.Arrays;

public class JumpGame {

    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, 1, 1, 4};
        System.out.println(canJump(nums));
    }

    public static boolean canJump(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (i <= max) {
                max = Math.max(nums[i] + i, max);
                if (max >= nums.length - 1) {
                    return true;
                }
            }
        }
        return false;
    }

    //不用dp ,上述贪心可解
    public static boolean wrongDp(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 0);
        dp[0] = 1;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                if (i - j <= nums[j]) {
                    dp[i] += dp[j];
                }
            }
        }

        System.out.println(Arrays.toString(dp));

        return dp[nums.length - 1] > 0;
    }


}
