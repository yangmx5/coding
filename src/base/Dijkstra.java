package base;


public class Dijkstra {



    /*
    http://blog.csdn.net/luoshixian099/article/details/51918844
    */
    public static void main(String[] args) {

        char[] vextex = {'A', 'B', 'C', 'D', 'E', 'F'};
        int[][] matrix = new int[6][6];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (i == j)
                    matrix[i][j] = 0;
                else
                    matrix[i][j] = Integer.MAX_VALUE;
            }
        }

        matrix[0][1] = 50;
        matrix[0][2] = 10;
        matrix[0][4] = 45;
        matrix[1][2] = 15;
        matrix[1][4] = 10;
        matrix[2][0] = 20;
        matrix[2][3] = 15;
        matrix[3][1] = 20;
        matrix[3][4] = 35;
        matrix[3][5] = 3;
        matrix[4][3] = 30;


        int[] dist = matrix[0];
        boolean[] s = {true, false, false, false, false, false};

        for (; ; ) {
            int min = Integer.MAX_VALUE;
            int index = -1;
            for (int i = 0; i < dist.length; i++) {
                if (!s[i] && dist[i] < min) {
                    min = dist[i];
                    index = i;
                }
            }
            if (index == -1) break;
            for (int j = 0; j < matrix[index].length; j++) {
                if (matrix[index][j] != Integer.MAX_VALUE) {
                    dist[j] = Math.min(matrix[index][j] + min, dist[j]);
                }
            }
            s[index] = true;
        }

        for (int i = 0; i < dist.length; i++) {
            System.out.print(dist[i] + " ");
        }


    }


}
