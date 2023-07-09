package hotBack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author fouthed
 * @date 2023/6/27
 */
public class AllPailie {

    public static List<List<Integer>> ret = new ArrayList<>();

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        List<Integer> subList = new ArrayList<>();
        for (int n : nums) {
            subList.add(n);
        }

        resolve(nums.length, subList, 0);

        for (List<Integer> l : ret) {
            System.out.printf(Arrays.toString(l.toArray()));
        }
    }

    public static void resolve(int n, List<Integer> subList, int first) {
        if (first == n) {
            ret.add(new ArrayList<>(subList));
        }
        for (int i = first; i < subList.size(); i++) {
            Collections.swap(subList, first, i);
            resolve(n, subList, first + 1);
            Collections.swap(subList, first, i);
        }
    }
}
