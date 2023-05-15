package hotOneHundred;

/**
 * @author fouthed
 * @date 2023/5/8
 */
public class SearchMatrix {

    public static void main(String[] args) {
        String str = "abcced";
        char[][] matrix = new char[][]{{'a', 'b', 'c','e'},{'s','f','c','s'},{'a','d','e','e'}};
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        boolean ret = false;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (check(matrix, visited, str, i, j, 0)) {
                    ret = true;
                    break;
                }
            }
        }
        System.out.println(ret);
    }

    public static boolean check(char[][] matrix, boolean[][] vistied, String str, int i, int j, int k) {
        if (matrix[i][j] != str.charAt(k)) {
            return false;
        } else if (k == str.length() - 1) {
            return true;
        }
        boolean ret = false;
        int[][] search = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        vistied[i][j] = true;
        for (int[] l : search) {
            int newi = i + l[0];
            int newj = j + l[1];
            if (newi >= 0 && newi < matrix.length && newj >= 0 && newj < matrix[0].length) {
                if (!vistied[newi][newj]) {
                    boolean tmp = check(matrix, vistied, str, newi, newj, k + 1);
                    if (tmp) {
                        ret = true;
                        break;
                    }
                }
            }
        }
        vistied[i][j] = false;
        return ret;

    }
}
