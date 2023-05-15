package hotOneHundred.dfsAndBfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author fouthed
 * @date 2023/5/10
 */
public class CourseBfs {
    public static void main(String[] args) {
        int num = 2;
        int [][] pre = new int[][]{{1,0},{0,1}};

        System.out.println(canFinish(num,pre));

    }

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> edges = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        int[] visited = new int[numCourses];


        for (int i = 0; i < numCourses; i++) {
            edges.add(new ArrayList<>());
        }

        for (int[] list : prerequisites) {
            edges.get(list[1]).add(list[0]);
            visited[list[0]]++;
        }
        for(int i = 0 ; i <  visited.length; i++){
            if(visited[i] == 0){
                queue.offer(i);
            }
        }
        int ret = 0;
        while(!queue.isEmpty()){
            int u = queue.poll();
            ret++;
            for(Integer m : edges.get(u)){
                visited[m] --;
                if(visited[m] == 0){
                    queue.offer(m);
                }
            }
        }
        return ret == numCourses;

    }
}
