package base;

public class KMP {

    public static int kmp(String s, String p) {

        if (s == null || p == null || p.length() < 1 || s.length() < p.length()) {
            return -1;
        }
        char[] arr_s = s.toCharArray();
        char[] arr_p = p.toCharArray();
        int i = 0;
        int j = 0;
        // 计算 模式串 的 next 数组，以供 KMP 比较时进行跳跃
        int[] next = getNextArray(arr_p);

        while (i < arr_s.length && j < arr_p.length) {
            if (arr_s[i] == arr_p[j]) {
                // 当两个字符相等时，两个指针同时向后移动
                i++;
                j++;
            } else if (next[j] == -1) {
                // 当 next[j]=-1 说明，j已经跳跃到模式串p的起始位置了，无法再次进行跳跃。
                // 说明 arr_s[i] 与 模式串p 无法进行匹配，因此将 i 移动到下一个位置
                i++;
            } else {
                // 当两个字符不想等，则依据模式串p的 next[],我们可以将指针 j 向前跳跃到 next[j] 处，
                // 相当于将 模式串 右移 j-next[j]，然后继续将 arr_s[i] 与 arr_p[j] 进行匹配
                j = next[j];
            }
        }

        // 如果 j 能够成功遍历到 arr_p 的结束位置，说明能够在字符串 s 中匹配到模式串p.
        // 匹配的结束为止为 i,因此起始位置为 i-j. 否则说明无法匹配，返回-1.
        return j == arr_p.length ? i - j : -1;
    }


    public static int[] getNextArray(char[] arr) {
        if (arr.length == 1) {
            return new int[]{-1};
        }
        int[] next = new int[arr.length];

        // 根据定义初始化next数组，0位置为-1，1位置为0.
        next[0] = -1;
        next[1] = 0;
        int pos = 2;    // 当前位置
        int cn = 0;     // 当前位置前一个字符的 next[] 值(最长相等前后缀的长度)
        while (pos < next.length) {
            if (arr[pos - 1] == arr[cn]) {
                // 当字符串的 pos-1 位置与 pos-1 位置字符所对应的最长相同前后缀的下一个字符 arr[next[pos-1]] 相等时
                // 我们就能确定 next[pos] 的值为 pos-1 位置所对应的 next[pos-1] + 1,即 ++cn.
                next[pos++] = ++cn;
            } else if (cn > 0) {
                // 当着两个字符 不相等 时，cn向前跳跃到 next[cn] 的位置，去寻找长度更短的相同前后缀。
                cn = next[cn];
            } else {
                // cn<=0; 此时说明前面已经没有相同前后缀了，即 cn 已经没办法再跳跃了，
                // 此时 pos 对应的 next[pos] 值为 0 （无相同前后缀）
                next[pos++] = 0;
            }
        }

        return next;

    }

    public static void main(String[] args) {

        System.out.println(kmp("1234", "123"));
    }

}
