package hotOneHundred.dp;

/**
 * @date 2023/4/4
 */
public class MaxSubArray {

    public static void main(String[] args) {
        int[] nums = new int[]{-2, 1 - 3, 4, -1, 2, 1, -5, 4};
        //返回连续子数组的最大和
        // 4, -1 , 2, 1  = 6 return 6

        System.out.println(resolve(nums));
        System.out.println(refactorResolve(nums));

    }

    public static int refactorResolve(int [] nums){
        int pre = 0 ; int max = nums[0];
        for(int i : nums){
            pre = Math.max(i, pre + i);
            max = Math.max(max, pre);
        }
        return max;
    }

    public static int resolve(int[] nums) {
        int[] dp = new int[nums.length + 1];

        dp[0] = 0;
        int max = dp[0];
        for (int i = 0; i < nums.length; i++) {
            dp[i + 1] = Math.max(dp[i] + nums[i], nums[i]);
            max = Math.max(max, dp[i + 1]);
        }

        printArray(dp);

        return max;
    }

    public static void printArray(int[] nums) {
        StringBuffer buffer = new StringBuffer();
        for (int i : nums) {
            buffer.append(i + ",");
        }
        System.out.println(buffer.toString());
    }

}
