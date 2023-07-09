package hotBack;

import java.util.Arrays;

/**
 * @author fouthed
 * @date 2023/6/9
 * 下一个排列
 * - [ ]  1,2,3  -> 1, 3, 2 -> 2,1,3 -> 2, 3, 1 -> 3,1,2 -> 3, 2 ,1 -> 1,2,3
 * - [ ] 4,5,2,6,3,1 -> 4,5,3,1,2,6 -> 4,5,3,1,6,2 -> 4,5,3,2,1,6 -> 4,5,3,2,6,1 - > 4,5,3,6,1,2
 */
public class NextPermutation {

    public static void main(String[] args) {
        int[] nums = new int[]{4, 5, 2, 6, 3, 1};
        int k = nums.length - 2;
        while (k >= 0 && nums[k] >= nums[k + 1]) {
            k--;
        }
        if (k >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[k] >= nums[j]) {
                j--;
            }
            swap(nums, k, j);
        }
        reverse(nums, k + 1);

        System.out.println(Arrays.toString(nums));
    }

    public static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void reverse(int[] nums, int i) {
        int left = i, right = nums.length - 1;
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }
}
