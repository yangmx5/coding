package LeetCode;


/*
 * 最长的有效括号
 */
public class LongestValidParentheses {
	//AC
	public static int longestValidParentheses(String str) {
		if (str == null || str.equals(""))
			return 0;
		int[] dp = new int[str.length()];
		int pre = 0;
		int res = 0;
		for (int i = 1; i < str.length(); i++) {
			if (str.charAt(i) == ')') {
				pre = i - dp[i - 1] - 1;
				if (pre >= 0 && str.charAt(pre) == '(') {
					dp[i] = dp[i - 1] + 2 + (pre > 0 ? dp[pre - 1] : 0);
				}
			}
			res = Math.max(res, dp[i]);
		}
		return res;
	}
	
	public static void main(String[] args) {
		String str1 = "()";
		
		System.out.println(longestValidParentheses(str1));

	}
}
