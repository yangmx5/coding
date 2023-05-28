package hotOneHundred.backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 回溯法
 */
public class AllPaiLie {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        List<List<Integer>> ret = permuteCopy(nums);
        StringBuffer buffer = new StringBuffer();
        for (List<Integer> list : ret) {
            for (Integer n : list) {
                buffer.append(n);
                buffer.append(",");
            }
            buffer.append("\n");
        }
        System.out.println(buffer.toString());
    }

    public static List<List<Integer>> permuteCopy(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        List<Integer> subList = new ArrayList<>();
        for (int n : nums) {
            subList.add(n);
        }

        dfs(nums.length, 0, ret, subList);
        return ret;
    }

    public static void dfs(int n, int first, List<List<Integer>> output, List<Integer> ret) {
        if (first == n) {
            output.add(new ArrayList<>(ret));
        }
        for (int i = first; i < n; i++) {
            Collections.swap(ret, i, first);
            dfs(n, first + 1, output, ret);
            Collections.swap(ret, i, first);
        }
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        List<Integer> output = new ArrayList<Integer>();
        for (int num : nums) {
            output.add(num);
        }
        resolve(nums.length, ret, output, 0);
        return ret;
    }

    public static void resolve(int n, List<List<Integer>> ret, List<Integer> output, int first) {
        if (first == n) {
            ret.add(new ArrayList<Integer>(output));
        }

        for (int i = first; i < n; i++) {
            Collections.swap(output, first, i);
            resolve(n, ret, output, first + 1);
            Collections.swap(output, first, i);
        }
    }

}
