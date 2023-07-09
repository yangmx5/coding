package hotBack;

/**
 * @author fouthed
 * @date 2023/6/19
 * 打家劫舍
 */
public class CashRob {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 1};
        int[] arr2 = new int[]{2, 7, 9, 3, 1};
        System.out.println(resovle(arr));
        System.out.println(resovle(arr2));

    }

    public static int resovle(int[] arr) {
        int[] dp = new int[arr.length];
        dp[0] = arr[0];
        dp[1] = Math.max(arr[0], arr[1]);
        for (int i = 2; i < arr.length; i++) {
            dp[i] = Math.max(dp[i - 2] + arr[i], dp[i - 1]);
        }
        return dp[arr.length - 1];
    }
}
