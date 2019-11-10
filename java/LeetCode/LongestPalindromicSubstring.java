package LeetCode;

public class LongestPalindromicSubstring {

	public static String longestPalindrome(String s) {

		boolean dp[][] = new boolean[s.length()][s.length()];
		
		for (int i = 0; i < dp.length; i++) {
			for (int j = i; j < dp[0].length; j++) {
				if (i == j) {
					dp[i][j] = true;
					continue;
				}
				if (i+1 == j && s.charAt(i) == s.charAt(j)) {
					dp[i][j] = true;
					continue;
				}
			}
		}
		
		for (int i = 0; i < dp.length-1; i++) {
			for (int j = i+2; j < dp[0].length; j++) {
				dp[i][j] = dp[i+1][j-1] && s.charAt(i) == s.charAt(j);
			}
		}

		for(int i = 0 ; i < dp.length ; i++){
			for(int j = 0 ; j < dp[0].length ; j++){
				System.out.print(dp[i][j] + " ");
			}
			System.out.println("");
		}
		
		String max = "";
		
		for(int i = 0 ; i < dp.length ; i++){
			for(int j = i ; j < dp[0].length ; j++){
				if(dp[i][j] && j-i >= max.length()){
					max = s.substring(i, j+1);
				} 
			}
		}
		
		
		return max;

	}
	
	public static String longestPalindromeL(String s) {
		  int n = s.length();
		  String res = null;
		    
		  boolean[][] dp = new boolean[n][n];
		    
		  for (int i = n - 1; i >= 0; i--) {
		    for (int j = i; j < n; j++) {
		      dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i < 3 || dp[i + 1][j - 1]);
		            
		      if (dp[i][j] && (res == null || j - i + 1 > res.length())) {
		        res = s.substring(i, j + 1);
		      }
		    }
		  }
		  
		  for(int i = 0 ; i < dp.length ; i++){
				for(int j = 0 ; j < dp[0].length ; j++){
					System.out.print(dp[i][j] + " ");
				}
				System.out.println("");
			}
		  
		  return res;
		}

	public static void main(String[] args) {

		System.out.println(longestPalindrome("abcab"));
	
		System.out.println(longestPalindromeL("12-1-2-3"));
		
	}

}
