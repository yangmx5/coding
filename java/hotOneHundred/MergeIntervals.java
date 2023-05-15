package hotOneHundred;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author fouthed
 * @date 2023/4/25
 */
public class MergeIntervals {

    public static void main(String[] args) {
        int[][] intervals = new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] ret = merge(intervals);
        for (int[] l : ret) {
            StringBuffer buffer = new StringBuffer();
            for (int num : l) {
                buffer.append(num);
                buffer.append(",");
            }
            System.out.println(buffer.toString());
        }
    }

    public static int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {
            return new int[0][2];
        }
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        List<int[]> merged = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            int L = intervals[i][0];
            int R = intervals[i][1];
            if (merged.size() == 0 || merged.get(merged.size() - 1)[1] < L) {
                merged.add(new int[]{L, R});
            } else {
                merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], R);
            }
        }
        return merged.toArray(new int[merged.size()][]);

    }

    public static void run(int[][] intervals) {
        int[] pre = intervals[0];
        List<List<Integer>> ret = new ArrayList<>();
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= pre[1]) {
                pre[1] = intervals[i][1];
            } else {
                List<Integer> tmp = Arrays.stream(pre).boxed().collect(Collectors.toList());
                ret.add(tmp);
                pre = intervals[i];
            }
        }
        List<Integer> end = Arrays.stream(pre).boxed().collect(Collectors.toList());
        ret.add(end);
        System.out.println(ret.toString());

        int[][] retArr = new int[ret.size()][2];
        int i = 0;
        for (List<Integer> list : ret) {
            System.out.println(list);
            Object[] tmp = list.toArray();
            retArr[i][0] = (int) tmp[0];
            retArr[i][1] = (int) tmp[1];
            i++;
        }
        for (int[] row : retArr) {
            for (int num : row) {
                System.out.println(num);
            }
        }
    }


}
