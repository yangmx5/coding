package hotOneHundred.dp;

/**
 * @date 2023/3/27
 * <p>
 * 给定一个数组，数组前每位可以添加 加减号
 * [1,2,-3,4,5]
 * 给定一个 target = 4 ，计算有多少中组合可以达到 4
 */
public class SumEqualsTarget {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 1, 1, 1, 1};
        int target = 3;
        int n = resolve(arr, 0, target);
        System.out.println(n);
        int sum = 0;
        for (int num : arr) {
            sum += num;
        }

        int m = sum < target || ((target & 1) ^ (sum & 1)) != 0 ? 0 : findByDP(arr, (sum + target) >> 1);
        System.out.println(m);
    }

    /**
     * 普通递归解法
     */
    public static int resolve(int[] arr, int i, int target) {
        if (i == arr.length) {
            return target == 0 ? 1 : 0;
        }

        return resolve(arr, i + 1, target + arr[i]) + resolve(arr, i + 1, target - arr[i]);
    }

    /**
     * 优化思路
     * 1。target 绝对值大于 sum 累加返回 0
     * 2。sum 累加奇偶性和 target 不一致返回 0
     * 3。P - N = target
     * 3.1 P - N + P + N = target + P + N
     * 3.2 2P = target + sum
     * 3.3 P = (target + sum)/2
     * 4。动态规划、0-1 背包问题，挑选几个数累加为 P
     * 4.1 找状态：第i个数，累加和容量
     * 4.2 给定义 dp[i][sum] 代表前 i 个数累加和等于的组合方法个数
     * 4.3 状态转移方程
     * dp[i][sum] = dp[i-1][sum]  第i个数不妨入组合
     * + dp[i-1][sum - arr[i-1]]; 第i个数放入组合
     * 5。动态规划二维数组空间压缩
     * 5.1 dp[sum] = dp[sum] + dp[sum - arr[i-1]];
     * 5.2 dp[i] = dp[i] + dp[i - n]
     */
    public static int findByDP(int[] arr, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int n : arr) {
            for (int i = target; i >= n; i--) {
                dp[i] += dp[i - n];
            }
        }
        return dp[target];
    }

    public static int findByDpAgain(int[] arr, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int n : arr) {
            for (int i = target; i >= n; i--) {
                dp[i] = dp[i] + dp[i - n];
            }
        }
        return dp[target];
    }
}
