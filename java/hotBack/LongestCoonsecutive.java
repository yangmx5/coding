package hotBack;

import java.util.HashSet;
import java.util.Set;

/**
 * @author fouthed
 * @date 2023/6/14
 */
public class LongestCoonsecutive {

    public static void main(String[] args) {
        int[] nums = new int[]{100, 3, 200, 1, 2, 4};
        System.out.println(resolve(nums));
    }

    public static int resolve(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for (int n : nums) {
            numSet.add(n);
        }
        int max = 1;
        int currentNum = nums[0];
        int[] ret = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            currentNum = nums[i];
            int tmp = 1;
            if(!numSet.contains(currentNum-1)) {
                while (numSet.contains(currentNum + 1)) {
                    tmp++;
                    currentNum++;
                }
                max = Math.max(tmp, max);
            }
        }
        return max;
    }
}
