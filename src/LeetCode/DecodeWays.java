package LeetCode;

public class DecodeWays {
	public static int numDecodings(String s) {

		int n = s.length();
		if (n <= 0)
			return 0;

		int[] dp = new int[n + 1];
		dp[0] = 1;
		dp[1] = s.charAt(0) == '0' ? 0 : 1;
		for (int i = 2; i < n + 1; i++) {
			if (s.charAt(i - 1) == '0')
				continue;
			dp[i] = dp[i - 1];
			if (Integer.valueOf(s.substring(i - 2, i)) <= 26) {
				dp[i] += dp[i - 2];

			}
		}

		for (int i = 0; i < dp.length; i++)
			System.out.print(dp[i] + " ");
		System.out.println("");
		return dp[n];

	}

	//ac
	public static int numDecodingsReverse(String s) {
		int n = s.length();
		if (n == 0)
			return 0;

		int[] memo = new int[n + 1];
		memo[n] = 1;
		memo[n - 1] = s.charAt(n - 1) != '0' ? 1 : 0;

		for (int i = n - 2; i >= 0; i--)
			if (s.charAt(i) == '0')
				continue;
			else
				memo[i] = (Integer.parseInt(s.substring(i, i + 2)) <= 26) ? memo[i + 1] + memo[i + 2] : memo[i + 1];

		return memo[0];
	}

	public static void main(String[] args) {
		System.out.println(numDecodings("01"));

		System.out.println(numDecodingsReverse("0111"));
		
	}
}
