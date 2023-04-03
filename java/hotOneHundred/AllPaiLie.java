package hotOneHundred;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 回溯法
 */
public class AllPaiLie {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        List<Integer> output = new ArrayList<Integer>();
        for (int num : nums) {
            output.add(num);
        }
        resolve(nums.length, ret, output, 0);
        return ret;
    }

    public void resolve(int n, List<List<Integer>> ret, List<Integer> output , int first){
        if(first == n){
            ret.add(new ArrayList<Integer>(output));
        }

        for(int i = first; i < n ; i ++){
            Collections.swap(output, first, i);
            resolve(n,ret,output, first+1);
            Collections.swap(output, first, i);
        }
    }

}
