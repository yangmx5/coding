package hotOneHundred.dp;

import java.util.Arrays;

public class CountSubstrings {

    public static void main(String[] args) {
        String s = "abc";
        String s1 = "aaa";
        System.out.println(resolve(s));
        System.out.println(resolve(s1));
    }

    public static int resolve(String s) {
        int n = s.length();
        int ret = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= 1; j++) {
                int l = i;
                int r = i + j;
                while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
                    ret++;
                    l--;
                    r++;
                }
            }
        }
        return ret;
    }


}
