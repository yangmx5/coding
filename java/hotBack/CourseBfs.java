package hotBack;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author fouthed
 * @date 2023/6/19
 */
public class CourseBfs {

    public static void main(String[] args) {
        int num = 2;
        int[][] pre = new int[][]{{1, 0}, {0, 1}};
        int[][] pre2 = new int[][]{{1, 0}};

        System.out.println(canFinish(num, pre2));

    }

    public static boolean canFinish(int num, int[][] arr) {
        List<List<Integer>> edges = new ArrayList<>();
        int[] visited = new int[num];
        for (int i = 0; i < num; i++) {
            edges.add(new ArrayList<>());
        }

        for (int[] tmp : arr) {
            edges.get(tmp[1]).add(tmp[0]);
            visited[tmp[0]]++;
        }
        Deque<Integer> queue = new LinkedList<>();
        for (int i = 0 ; i < visited.length; i++) {
            if(visited[i] == 0) {
                queue.offer(i);
            }
        }
        int ret = 0;
        while (!queue.isEmpty()) {
            int n = queue.poll();
            ret++;
            for (int m : edges.get(n)) {
                visited[m]--;
                if (visited[m] == 0) {
                    queue.offer(m);
                }
            }
        }
        return ret == num;

    }
}
