package hotBack;

import java.util.HashSet;
import java.util.Set;

/**
 * @author fouthed
 * @date 2023/6/7
 * 字符串中最长不重复字符子串的长度
 * 使用 set + 滑动窗口的办法
 */
public class LengthOfLongestSubString {

    public static void main(String[] args) {
//        String str = "abcabcbb";
        String str = "abbbbcabcbb";
        String tmp = "qwekeeeweklqww";
        String value = "abcabcabccc";

        System.out.println(resolve(value));
        System.out.println(resolve(tmp));

        System.out.println(resolve(str));
    }

    public static int resolve(String str) {
        Set<Character> charSet = new HashSet<>();
        int max = 0;
        for (int right = 0, left = 0; right < str.length(); right++) {
            while (charSet.contains(str.charAt(right))) {
                charSet.remove(str.charAt(left));
                left++;
            }
            charSet.add(str.charAt(right));
            max = Math.max(max, right - left + 1);
        }
        return max;
    }


}
