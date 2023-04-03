package hotOneHundred.dp;

import java.util.Arrays;

/**
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。
 * 如果没有任何一种硬币组合能组成总金额，返回 -1。
 * <p>
 * 你可以认为每种硬币的数量是无限的。
 */
public class LowestCoinSum {

    public static void main(String[] args) {
        int[] coins = new int[]{1, 2, 5};
        int amount = 11;
        System.out.println(dp(coins, amount));
    }


    public static void printArr(int[] arr) {
        StringBuffer buffer = new StringBuffer();
        for (int n : arr) {
            buffer.append(n).append(",");
        }
        System.out.println(buffer.toString());
    }

    /**
     * @param coins
     * @param amount
     * @return
     */
    public static int dp(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount+1);
        dp[0] = 0;
        for (int i = 0; i < dp.length; i++) {
            for (int coin : coins) {
                if (i < coin) {
                    continue;
                } else {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

}
