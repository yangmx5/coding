package hotOneHundred.sort;

import java.util.Arrays;

/**
 * @author fouthed
 * @date 2023/5/18
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] nums = new int[]{2, 5, 1, 2, 3};
        sort(nums, 0, nums.length - 1);

        System.out.println(Arrays.toString(nums));
    }

    public static void sort(int[] nums, int left, int right) {
        if (left < right) {
            int key = nums[left];
            int i = left;
            int j = right;
            while (i < j) {
                while (i < j && nums[j] > key) {
                    j--;
                }
                if (i < j) {
                    swap(nums, i, j);
                    i++;
                }
                while (i < j && nums[i] < key) {
                    i++;
                }
                if (i < j) {
                    swap(nums, i, j);
                    j--;
                }
            }
            sort(nums, left, i - 1);
            sort(nums, i + 1, right);
        }
    }

    public static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
