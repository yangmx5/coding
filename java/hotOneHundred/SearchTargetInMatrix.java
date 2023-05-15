package hotOneHundred;

/**
 * @author fouthed
 * @date 2023/5/12
 */
public class SearchTargetInMatrix {

    public static void main(String[] args) {
        int [][] matrix = new int [][]{{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
        System.out.println(search(matrix,100));
    }

    public static boolean search(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        if (matrix[0][0] > target) {
            return false;
        }
        int i = 0 ;
        int j = matrix[0].length - 1;
        while(i < matrix.length && j > 0){
            if(matrix[i][j] == target){
                return true;
            }else if(matrix[i][j] > target){
                j--;
            }else{
                i++;
            }
        }
        return false;
    }
}
