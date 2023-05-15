package hotOneHundred;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author fouthed
 * @date 2023/5/6
 */
public class ChildSet {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        List<List<Integer>> result = resolve(nums);

        StringBuffer buffer = new StringBuffer();
        for (List<Integer> l : result) {
            buffer.append("[");
            for (Integer n : l) {
                buffer.append(n.toString());
                buffer.append(",");
            }
            buffer.append("],");
        }
        System.out.println(buffer.toString());
    }

    private static List<Integer> ret = new ArrayList<>();
    private static List<List<Integer>> ans = new ArrayList<>();

    public static List<List<Integer>> resolve(int[] nums) {
        dfs(0, nums);
        return ans;
    }

    public static void dfs(int curr, int[] nums) {
        if (curr == nums.length) {
            ans.add(new ArrayList<>(ret));
            return;
        }
        ret.add(nums[curr]);
        dfs(curr + 1, nums);
        ret.remove(ret.size() - 1);
        dfs(curr + 1, nums);
    }

}
