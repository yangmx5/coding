package hotBack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author fouthed
 * @date 2023/6/9
 * 组合总和
 * 从一个无重复元素的数组中找出和目标值为 target 的所有组合
 * 元素可重复选取 范围list
 */
public class CombineSum {

    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, 6, 7};
        backtrack(nums, 0, new ArrayList<>(), 7);
        for (List<Integer> list : ret) {
            System.out.println(Arrays.toString(list.toArray()));
        }
    }

    public static List<List<Integer>> ret = new ArrayList<>();

    public static void backtrack(int[] nums, int index, List<Integer> subList, int sum) {
        if (sum < 0 || index >= nums.length) {
            return;
        }
        if (sum == 0) {
            ret.add(new ArrayList<>(subList));
            return;
        }
        subList.add(nums[index]);
        backtrack(nums, index, subList, sum - nums[index]);
        subList.remove(subList.size() - 1);
        backtrack(nums, index + 1, subList, sum);
    }
}
