package hotBack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author fouthed
 * @date 2023/6/8
 * 三数之和  = 0
 */
public class ThreeSum {

    public static void main(String[] args) {
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
        List<List<Integer>> ret = new ArrayList<>();
        ret = resolve(nums);
        for (List<Integer> str : ret) {
            System.out.println(Arrays.toString(str.toArray()));
        }
    }

    public static List<List<Integer>> resolve(int[] nums) {
        if (nums == null || nums.length < 3) {
            return new ArrayList<>();
        }
        List<List<Integer>> ret = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0) {
                break;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int l = i + 1;
            int r = nums.length - 1;
            while (l < r) {
                int val = nums[i] + nums[l] + nums[r];
                if (val == 0) {
                    ret.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    while (l < r && nums[l] == nums[++l]) ;
                    while (l < r && nums[r] == nums[--r]) ;
                } else if (val > 0) {
                    while (l < r && nums[l] == nums[++l]) ;
                } else {
                    while (l < r && nums[r] == nums[--r]) ;
                }
            }
        }
        return ret;
    }
}
