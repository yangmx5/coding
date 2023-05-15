package hotOneHundred;

import java.util.HashSet;
import java.util.Set;

/**
 * @author fouthed
 * @date 2023/5/9
 */
public class LongestConsecutive {

    public static void main(String[] args) {
        int[] nums = new int[]{100, 4, 200, 1, 3, 2};
        System.out.println(resolve(nums));
    }

    public static int resolve(int[] nums) {
        int currentNum = nums[0];
        int longestBreak = 1;
        Set<Integer> set = new HashSet<>();
        for (int n : nums) {
            set.add(n);
        }

        for (int i = 0; i < nums.length; i++) {
            currentNum = nums[i];
            int tmp = 1;
            if (!set.contains(currentNum - 1)) {
                while (set.contains(currentNum + 1)) {
                    currentNum++;
                    tmp++;
                }
                longestBreak = Math.max(tmp, longestBreak);
            }
        }
        return longestBreak;
    }

}
