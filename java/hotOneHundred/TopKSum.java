package hotOneHundred;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author fouthed
 * @date 2023/5/12
 */
public class TopKSum {
    public static void main(String[] args) {

    }

    public static List<Integer> resolve(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer tmp = map.getOrDefault(nums[i], 0);
            tmp++;
            map.put(nums[i], tmp);
        }

        List<Integer>[] ret = new List[nums.length + 1];
        for (int key : map.keySet()) {
            Integer value = map.get(key);
            if (ret[value] == null) {
                ret[value] = new ArrayList<>();
            }
            ret[value].add(key);
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = nums.length; i >= 0 && ans.size() < k; i--) {
            if(ret[i] == null) {
                continue;
            }
            ans.addAll(ret[i]);
        }
        return ans;
    }
}
