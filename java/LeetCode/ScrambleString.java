package LeetCode;

public class ScrambleString {
	public static boolean isScramble(String s1, String s2) {

		if (s1 == null || s2 == null || s1.length() != s2.length())
			return false;
		if (s1.length() == 0)
			return true;

		boolean[][][] dp = new boolean[s1.length()][s2.length()][s1.length() + 1];

		for (int i = 0; i < s1.length(); i++) {
			for (int j = 0; j < s2.length(); j++)
				dp[i][j][1] = s1.charAt(i) == s2.charAt(j);
		}

		for (int len = 2; len <= s1.length(); len++) {
			for (int i = 0; i < s1.length() - len + 1; i++) {
				for (int j = 0; j < s2.length() - len + 1; j++) {
					for (int k = 1; k < len; k++) {
						dp[i][j][len] |= dp[i][j][k] && dp[i + k][j + k][len - k]
								|| dp[i][j + len - k][k] && dp[i + k][j][len - k];
					}
				}
			}
		}
		
		//输出三维dp矩阵
		for(int i = 0 ; i < dp[0][0].length ; i++){
			for(int j = 0 ; j  <dp[0].length ; j++){
				for(int m = 0 ; m < dp.length ; m++){
					System.out.print(dp[m][j][i] + " ");
				}
				System.out.println("");
			}
			System.out.println("");
		}
		
		return dp[0][0][s1.length()];
	}

	public static void main(String[] args) {
		System.out.println(isScramble("ge", "eg"));
	}
}
