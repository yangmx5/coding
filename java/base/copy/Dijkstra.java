package base.copy;

public class Dijkstra {
    public static  void main(String [] args){

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
/*
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
        matrix[4][3] = 30;*/

        matrix[0][1] = 1;
        matrix[0][2] = 12;
        matrix[1][2] = 9;
        matrix[1][3] = 3;
        matrix[2][4] = 5;
        matrix[3][2] = 4;
        matrix[3][4] = 13;
        matrix[3][5] = 15;
        matrix[4][5] = 4;

        int [] dist = matrix[0];
        boolean [] s = new boolean[dist.length];
        for(int i = 0 ; i < s.length ; i++){
            s[i] = false;
        }
        s[0] = true;

        while(true){
            int index = -1;
            int min = Integer.MIN_VALUE;
            for(int i = 0 ; i < dist.length ; i++){
                if(!s[i] && dist[i] < min){
                    index = i ;
                    min = dist[i];
                }
            }
            if(index == -1)break;
            for(int j = 0 ; j < dist.length; j++){
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
