package LeetCode;

public class RegularExpressionMatches {

    public static void main(String[] args) {

        System.out.println("zbc".length());
        System.out.println(isMatchInDp("abccc", ".*."));

    }

	/*
	 * 1, If p.charAt(j) == s.charAt(i) :  dp[i][j] = dp[i-1][j-1];
	 * 2, If p.charAt(j) == '.' : dp[i][j] = dp[i-1][j-1];
	 * 3, If p.charAt(j) == '*': 
	 * 		here are two sub conditions:
	 * 			1   if p.charAt(j-1) != s.charAt(i) : dp[i][j] = dp[i][j-2]  //in this case, a* only counts as empty
	 * 			2   if p.charAt(i-1) == s.charAt(i) or p.charAt(i-1) == '.':
                              dp[i][j] = dp[i-1][j]    //in this case, a* counts as multiple a 
                           or dp[i][j] = dp[i][j-1]   // in this case, a* counts as single a
                           or dp[i][j] = dp[i][j-2]   // in this case, a* counts as empty
	 * 
	 */

    public static boolean isMatachInDP(String s, String p) {
        if (s == null || p == null) {
            return false;
        }
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;

        for (int j = 0; j < p.length(); j++) {
            if (p.charAt(j) == '*' && dp[0][j - 1]) {
                dp[0][j + 1] = true;
            }
        }

        for (int i = 0; i <= s.length(); i++) {
            for (int j = 0; j <= p.length(); j++) {
                if (s.charAt(i) == p.charAt(j)) {
                    dp[i + 1][j + 1] = dp[i][j];
                }
                if (p.charAt(j) == '.') {
                    dp[i + 1][j + 1] = dp[i][j];
                }
                if (p.charAt(j) == '*') {
                    if (p.charAt(j - 1) != s.charAt(i) && p.charAt(j - 1) != '.') {
                        dp[i+1][j + 1] = dp[i+1][j - 1];
                    } else {
                        dp[i + 1][j + 1] = dp[i + 1][j] || dp[i][j + 1] || dp[i + 1][j - 1];
                    }
                }
            }
        }
        return dp[s.length()][p.length()];
    }

    //AC
    public static boolean isMatchInDp(String s, String p) {

        if (s == null || p == null) {
            return false;
        }
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];


//	    for(int i = 0 ; i < s.length()+1; i++){
//	    	for(int j = 0 ; j < p.length()+1; j++)
//	    		System.out.print(dp[i][j] +" ");
//	    	System.out.println("");
//	    }
//	    

        dp[0][0] = true;
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '*' && dp[0][i - 1]) {
                dp[0][i + 1] = true;
            }
        }
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < p.length(); j++) {
                if (p.charAt(j) == '.') {
                    dp[i + 1][j + 1] = dp[i][j];
                }
                if (p.charAt(j) == s.charAt(i)) {
                    dp[i + 1][j + 1] = dp[i][j];
                }
                if (p.charAt(j) == '*') {
                    if (p.charAt(j - 1) != s.charAt(i) && p.charAt(j - 1) != '.') {
                        dp[i + 1][j + 1] = dp[i + 1][j - 1];
                    } else {
                        dp[i + 1][j + 1] = (dp[i + 1][j] || dp[i][j + 1] || dp[i + 1][j - 1]);
                    }
                }
            }
        }

//	    System.out.println("--");
//	    for(int i = 0 ; i < s.length()+1; i++){
//	    	for(int j = 0 ; j < p.length()+1; j++)
//	    		System.out.print(dp[i][j] +" ");
//	    	System.out.println("");
//	    }


        return dp[s.length()][p.length()];
    }


    public static boolean isMatch(String s, String p) {

        int i, j;
        for (i = 0, j = 0; i < s.length() && j < p.length(); ) {
            if (j + 1 < p.length() && p.charAt(j + 1) == '*') {
                char ch1 = p.charAt(j);
                if (ch1 == '*')
                    j += 2;
                if (ch1 == '.') {
                    for (int m = i; m < s.length(); m++) {
                        if (p.substring(j + 2).equals(""))
                            return true;
                        if (isMatch(s.substring(m), p.substring(j + 2)))
                            return true;
                    }
                    return false;
                } else {
                    char ch2 = s.charAt(i);
                    while (getChar(s, i) == ch2 && ch2 == ch1) {
                        i++;
                    }
                    j += 2;
                }
            } else {
                if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.') {
                    j++;
                    i++;
                    continue;
                } else
                    return false;
            }
        }

        while (getChar(p, j + 1) == '*')
            j += 2;

        if (i >= s.length() && j >= p.length())
            return true;
        else
            return false;

    }

    private static char getChar(String s, int i) {
        try {
            return s.charAt(i);
        } catch (Exception err) {
            return Character.MIN_VALUE;
        }

    }
}
