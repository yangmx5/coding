package hotOneHundred;

import common.CommonUtil;

import java.util.Arrays;

/**
 * @date 2023/3/27
 * 数组整体翻转， 将 3,4,5,6,9,8 从 k 位翻转
 *  k = 1 时
 *  输出:5,6,9,8,3,4
 */
public class ReverseArr {

    public static void main(String[] args) {
        int[] arr = new int[]{3, 4, 5, 6, 9, 8};
        arr = resolve(arr, 1);

        CommonUtil.printArray(arr);
    }

    public static int[] resolve(int[] arr, int target) {
        reverse(arr, 0, target);
        reverse(arr, target + 1, arr.length - 1);
        reverse(arr, 0, arr.length - 1);
        return arr;
    }

    public static int[] reverse(int[] arr, int left, int right) {
        while (left < right) {
            int tmp = arr[left];
            arr[left] = arr[right];
            arr[right] = tmp;
            left++;
            right--;
        }
        return arr;
    }

}
