package hotBack;

/**
 * @author fouthed
 * @date 2023/6/9
 * 搜索旋转数组，使用二分查找法
 * 二分后，判断目标值是否在顺序数组内，否则对乱序数组进行二分
 * 若在顺序数据组内，就对顺序数组进行二分
 */
public class SearchRotateArray {

    public static void main(String[] args) {
        int[] nums = new int[]{4, 5, 6, 7, 0, 1, 2};
        System.out.println(resolve(nums, 1));
    }

    public static int resolve(int[] nums, int target) {
        return search(nums, 0, nums.length - 1, target);
    }

    public static int search(int[] nums, int start, int end, int target) {
        int mid = (start + end) / 2;
        if (nums[mid] == target) {
            return mid;
        }
        if (target > nums[mid] && target <= nums[end]) {
            return search(nums, mid + 1, end, target);
        }
        if (target < nums[mid] && target >= nums[start]) {
            return search(nums, start, mid - 1, target);
        }

        if (nums[start] > nums[mid]) {
            return search(nums, start, mid - 1, target);
        }
        if (nums[mid] > nums[end]) {
            return search(nums, mid + 1, end, target);
        }
        return -1;
    }
}
