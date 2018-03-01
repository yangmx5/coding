package LeetCode;

public class EditDistance {

	public static int minDistance(String word1, String word2) {

		int[][] dp = new int[word1.length() + 1][word2.length() + 1];

		for (int i = 0; i <= word1.length(); i++)
			dp[i][0] = i;
		for (int i = 0; i <= word2.length(); i++)
			dp[0][i] = i;

		for (int i = 0; i < word1.length(); i++) {
			for (int j = 0; j < word2.length(); j++) {
				if (word1.charAt(i) == word2.charAt(j))
					dp[i + 1][j + 1] =  dp[i][j];
				else
					dp[i + 1][j + 1] = 1 + Math.min(Math.min(dp[i][j + 1], dp[i + 1][j]), dp[i][j]);
			}
		}

		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp[0].length; j++) { 
				System.out.print(dp[i][j] + " ");
			}
			System.out.println("");
		}

		return dp[word1.length()][word2.length()];
	}

	public static void main(String[] args) {

		System.out.println(minDistance("b", "b"));

	}
}
