package hotBack;

import java.util.Arrays;

/**
 * @author fouthed
 * @date 2023/6/9
 * 在排序数组中查找元素出现前后坐标
 * 使用二分查找即可
 */
public class SearchRange {
    public static void main(String[] args) {
        int[] nums = new int[]{5, 7, 8, 8, 10};
        int target = 8;
        int left = 0;
        int right = nums.length - 1;
        int index = -1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                index = mid;
                break;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        System.out.println(index);
        int i = index;
        while (i > 0 && nums[i] == nums[index]){
            i--;
        }

        int j = index;
        while (j < nums.length && nums[j] == nums[index]){
            j++;
        }

        System.out.println(Arrays.toString(Arrays.asList(i+1, j-1).toArray()));

    }

}
