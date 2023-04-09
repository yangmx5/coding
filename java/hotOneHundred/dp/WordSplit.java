package hotOneHundred.dp;

import java.util.Arrays;
import java.util.List;

/**
 * @author fouthed
 * @date 2023/4/6
 */
public class WordSplit {
    public static void main(String[] args) {
        String s = "leetcode";
        System.out.println(s.substring(4, s.length()));
        List<String> dict = Arrays.asList("leet", "code");
        System.out.println(resolve(s, dict));
    }

    public static boolean resolve(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        //dp[i] = dp[j] && wordDict.contains(s.subString(i,j);
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        System.out.println(Arrays.toString(dp));

        return dp[s.length()];

    }
}
