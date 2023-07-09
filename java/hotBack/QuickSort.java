package hotBack;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = new int[]{2, 5, 1, 4, 6, 8, 1, 2};

        quickSort(arr, 0, arr.length - 1);

        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] nums, int start, int end) {
        if (start < end) {
            int mid = partition(nums, start, end);
            quickSort(nums, start, mid);
            quickSort(nums, mid + 1, end);
        }
    }

    public static int partition(int[] nums, int start, int end) {
        int key = nums[start];
        int i = start;
        int j = end;
        while (i < j) {
            while (i < j && key <= nums[j]) {
                j--;
            }
            if (i < j) {
                nums[i] = nums[j];
                i++;
            }
            while (i < j && key >= nums[i]) {
                i++;
            }
            if (i < j) {
                nums[j] = nums[i];
                j--;
            }
        }
        nums[i] = key;
        return i;
    }
}
