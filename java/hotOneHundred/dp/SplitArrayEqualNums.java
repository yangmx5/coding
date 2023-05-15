package hotOneHundred.dp;

import java.util.Arrays;

/**
 * @author fouthed
 * @date 2023/4/12
 */
public class SplitArrayEqualNums {

    public static void main(String[] args) {

//        int[] nums = {1, 5, 11, 5};
//        int[] nums = {1,1, 2, 3, 5};
        int [] nums = {100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100};
        int sum = 0;
        for (int n : nums) {
            sum += n;
        }
        if (sum % 2 != 0) {
            System.out.println("wrong false");
            return;
        }
        int target = sum / 2;
        System.out.println(resolve(nums, target));

    }

    public static boolean resolve(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int n : nums) {
            for (int i = target; i >= n; i--) {
                dp[i] = dp[i] + dp[i - n];
            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[target] != 0;
    }
}
