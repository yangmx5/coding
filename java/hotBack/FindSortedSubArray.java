package hotBack;

/**
 * @author fouthed
 * @date 2023/6/20
 */
public class FindSortedSubArray {

    public static void main(String[] args) {
        int[] nums = new int[]{2, 6, 4, 8, 10, 9, 15};
        System.out.println(resolve(nums));
    }

    public static int resolve(int[] nums) {
        int len = nums.length;
        int max = nums[0];
        int min = nums[len - 1];
        int begin = 0;
        int end = -1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < max) {
                end = i;
            } else {
                max = nums[i];
            }

            if (nums[len - i - 1] > min) {
                begin = len - i - 1;
            } else {
                min = nums[len - i - 1];
            }
        }
        return end - begin + 1;
    }
}
