package hotBack;

import java.io.OutputStream;

/**
 * @author fouthed
 * @date 2023/6/7
 * 最长回文字符子串
 */
public class LongestPalindrome {

    public static void main(String[] args) {
        String c1 = "babad";
        String c2 = "cbbd";
        System.out.println(resolve(c1));
        System.out.println(resolve(c2));

    }

    public static String resolve(String str) {
        String ret = "";
        for (int i = 0; i < str.length(); i++) {
            int len1 = expend(str, i, i);
            int len2 = expend(str, i - 1, i);
            int len = Math.max(len1, len2);
            if (len > ret.length()) {
                ret = str.substring(i - (len - 1) / 2, i + len / 2);
            }
        }
        return ret;
    }

    public static int expend(String str, int left, int right) {
        while (left >= 0 && right < str.length() && str.charAt(left) == str.charAt(right)) {
            ++right;
            --left;
        }
        return right - left;
    }
}
