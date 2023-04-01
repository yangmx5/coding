package hotOneHundred;

import common.CommonUtil;

/**
 * @date 2023/3/27
 * 一个数组中只有 'a','b' 两种字符
 * 想将所有的'a'放左侧，所有的'b'放右侧
 * 或者将所有的'b'放左侧，所有的'a'放右侧
 */
public class JudgeArr {

    public static void main(String[] args) {
        char[] arr = new char[]{'a', 'b', 'a', 'a', 'a'};
        int n = resolve2(arr);
        System.out.println(n);
    }

    /**
     * 只能相邻字符交换, 最少交换多少次?
     *
     * @param arr
     * @return
     */
    public static int resolve2(char[] arr) {
        int ai = 0, bi = 0;
        int aret = 0, bret = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 'a') {
                aret = aret + (i - ai);
                ai++;
            } else {
                bret = bret + (i - bi);
                bi++;
            }
        }
        System.out.println("aret:" + aret);
        System.out.println("bret:" + bret);
        return Math.min(aret, bret);
    }

    /**
     * 假设不相邻字符也可以交换
     *
     * @param arr
     * @return
     */
    public static int resolve(char[] arr) {
        int left = 0, right = 0;
        int ret = 0;
        while (right < arr.length) {
            if (arr[right] == 'a' && left != right) {
                while (arr[left] == 'a' && left < right) {
                    left++;
                }
                char tmp = arr[left];
                arr[left] = arr[right];
                arr[right] = tmp;
                left++;
                ret++;
            }
            right++;
        }
        return ret;
    }
}
