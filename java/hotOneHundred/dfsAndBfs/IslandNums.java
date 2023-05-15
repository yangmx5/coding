package hotOneHundred.dfsAndBfs;

/**
 * @author fouthed
 * @date 2023/5/10
 */
public class IslandNums {

    public static void main(String[] args) {
        int[][] sea = new int[][]{{1, 1, 0, 0, 0}, {1, 1, 0, 0, 0}, {0, 0, 1, 0, 0}, {0, 0, 0, 1, 1}};

        int num = 0;
        for (int i = 0; i < sea.length; i++) {
            for (int j = 0; j < sea[0].length; j++) {
                if (sea[i][j] == 1) {
                    num++;
                    dfs(sea, i, j);
                }
            }
        }
        System.out.println(num);

    }

    public static void dfs(int[][] sea, int i, int j) {
        if (i < 0 || i > sea.length - 1 || j < 0 || j > sea[0].length - 1) {
            return;
        }
        if(sea[i][j]==0){
            return;
        }
        sea[i][j] = 0;
        dfs(sea, i + 1, j);
        dfs(sea, i - 1, j);
        dfs(sea, i, j + 1);
        dfs(sea, i, j - 1);

    }
}
