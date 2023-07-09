package hotBack;

import java.util.Arrays;

/**
 * @author fouthed
 * @date 2023/6/19
 * 乘积最大的子数组
 */
public class MaxMultiArray {

    public static void main(String[] args) {
        int[] arr = new int[]{2, 3, -2, 4};
        int[] dp = new int[arr.length];
        dp[0] = arr[0];
        int maxn = arr[0];
        int minn = arr[0];
        int ret = 0;
        for (int i = 1; i < arr.length; i++) {
            int n = arr[i];
            maxn = Math.max(maxn * n, Math.max(minn * n, n));
            minn = Math.min(minn * n, Math.min(minn * n, n));
            ret = Math.max(maxn, ret);
            dp[i] = maxn;
        }
        System.out.println(Arrays.toString(dp));
        System.out.println(ret);
    }


}
