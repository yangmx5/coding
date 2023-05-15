package hotOneHundred;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author fouthed
 * @date 2023/5/15
 */
public class FindAnagrams {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(resovle("cbaebabacd", "abc").toArray()));
    }

    public static List<Integer> resovle(String s, String p) {
        if (s.length() < p.length()) {
            return new ArrayList<>();
        }

        List<Integer> ans = new ArrayList<>();

        int[] sCount = new int[26];
        int[] pCount = new int[26];
        for (int i = 0; i < p.length(); i++) {
            ++sCount[s.charAt(i) - 'a'];
            ++pCount[p.charAt(i) - 'a'];
        }

        if (Arrays.equals(sCount, pCount)) {
            ans.add(0);
        }

        for (int i = 0; i < s.length() - p.length(); i++) {
            --sCount[s.charAt(i) - 'a'];
            ++sCount[s.charAt(i + p.length()) - 'a'];
            if (Arrays.equals(sCount, pCount)) {
                ans.add(i + 1);
            }
        }
        return ans;
    }
}
