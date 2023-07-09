import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeArrays {

    public static void main(String[] args) {
        int[][] intervals = new int[][]{{2, 6}, {1, 3}, {8, 10}, {15, 18}};
//        输出：[[1,6],[8,10],[15,18]]

        List<List<Integer>> ret = resolve(intervals);
        for (List<Integer> l : ret) {
            System.out.println(Arrays.toString(l.toArray()));
        }

    }

    public static List<List<Integer>> resolve(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return new ArrayList<>();
        }
        Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[0]));
        List<List<Integer>> ret = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            int L = intervals[i][0];
            int R = intervals[i][1];
            if (ret.size() == 0 || ret.get(ret.size() - 1).get(1) < L) {
                ret.add(Arrays.asList(L, R));
            } else {
                ret.get(ret.size() - 1).set(1, Math.max(R, ret.get(ret.size() - 1).get(1)));
            }
        }
        return ret;
    }


}
