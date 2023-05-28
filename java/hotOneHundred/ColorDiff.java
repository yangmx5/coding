package hotOneHundred;

import java.util.Arrays;

/**
 * @author fouthed
 * @date 2023/5/6
 * 三个颜色，将颜色进行分类，分成 0，0，1，1，2，2 的结果
 * 思路：双指针，分别从前后进行遍历，将 0 全部置换到左侧，将 2全部置换到右侧
 */
public class ColorDiff {

    public static void main(String[] args) {
        int[] nums = new int[]{0, 2, 0, 1, 2, 1, 2, 1};
        sort(nums);

        System.out.println(Arrays.toString(nums));
    }

    public static void sort(int[] nums) {
        int p1 = 0, p2 = nums.length - 1;
        for (int i = 0; i <= p2; i++) {
            if (nums[i] == 0) {
                int temp = nums[i];
                nums[i] = nums[p1];
                nums[p1] = temp;
                p1++;
            }
            while (i < p2 && nums[i] == 2) {
                int temp = nums[i];
                nums[i] = nums[p2];
                nums[p2] = temp;
                p2--;
            }
        }
    }

}
