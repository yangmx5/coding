package hotBack;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author fouthed
 * @date 2023/6/15
 * 字符串是否可以由 dict 中的单词组成
 */
public class WorkBreak {

    public static void main(String[] args) {
        String str = "leetcode";
        List<String> wordDict = Arrays.asList("leet", "code");
        System.out.println(isValid(str, wordDict));
    }

    public static boolean isValid(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && dict.contains(s.substring(j, i))) {
                    dp[i] = true;
                }
            }
        }
        return dp[s.length()];
    }
}
