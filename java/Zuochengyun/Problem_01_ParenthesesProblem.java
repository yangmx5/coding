package Zuochengyun;

public class Problem_01_ParenthesesProblem {

	public static boolean isValid(String str) {
		if (str == null || str.equals("")) {
			return false;
		}
		char[] chas = str.toCharArray();
		int status = 0;
		for (int i = 0; i < chas.length; i++) {
			if (chas[i] != ')' && chas[i] != '(') {
				return false;
			}
			if (chas[i] == ')' && --status < 0) {
				return false;
			}
			if (chas[i] == '(') {
				status++;
			}
		}
		return status == 0;
	}

	public static int maxLength(String str) {
		if (str == null || str.equals("")) {
			return 0;
		}
		char[] chas = str.toCharArray();
		int[] dp = new int[chas.length];
		int pre = 0;
		int res = 0;
		for (int i = 1; i < chas.length; i++) {
			if (chas[i] == ')') {
				pre = i - dp[i - 1] - 1;
				if (pre >= 0 && chas[pre] == '(') {
					dp[i] = dp[i - 1] + 2 + (pre > 0 ? dp[pre - 1] : 0);
				}
			}
			res = Math.max(res, dp[i]);
		}
		for(int i = 0 ; i< dp.length ; i++)
			System.out.print(dp[i] + " ");
		return res;
	}
	
	//leetcode
	 public static int longestValidParentheses(String str) {
	       if(str == null || str.equals(""))
	           return 0;
	        int [] dp = new int[str.length()];
	        int pre = 0;
	        int res = 0;
	        for(int i = 1 ; i < str.length(); i++){
	            if(str.charAt(i) == ')'){
	                pre = i-dp[i-1]-1;
	                if(pre >= 0 && str.charAt(pre) == '('){
	                    dp[i] = dp[i-1] + 2 +(pre>0?dp[pre-1]:0);
	                }
	            }
	            res = Math.max(res,dp[i]);
	        }
	        for(int i = 0 ; i< dp.length ; i++)
				System.out.print(dp[i] + " ");
	        return res;
	    }
	 
	public static void main(String[] args) {
		String str1 = "()";
		System.out.println(isValid(str1));
		System.out.println(maxLength(str1));
		System.out.println(longestValidParentheses(str1));

		String str2 = "(())(()(()))";
		System.out.println(isValid(str2));
		System.out.println(maxLength(str2));

		String str3 = "()(()()(";
		System.out.println(isValid(str3));
		System.out.println(maxLength(str3));

	}
}
