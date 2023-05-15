package hotOneHundred;

import java.util.Arrays;

/**
 * @author fouthed
 * @date 2023/5/11
 */
public class NumMultiArray {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4};

        System.out.println(Arrays.toString(resovle(nums)));
    }

    public static int[] resovle(int[] nums) {

        int[] ans = new int[nums.length];
        ans[0] = 1;
        for (int i = 1; i < ans.length; i++) {
            ans[i] = ans[i - 1] * nums[i-1];
        }

        int R = 1;
        for (int i = ans.length - 1; i >= 0; i--) {
            ans[i] = ans[i] * R;
            R = R * nums[i];
        }
        return ans;
    }
}
