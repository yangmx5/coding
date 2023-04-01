package Com.JinRi;

import java.util.Arrays;
import java.util.Scanner;

/*
 * n 长数组内  k 区间中最小值乘区间和的最大值
 * 
 * dp[i][j] := 下标为i的j长区间内的最小值
 * dp[i][j] = min{dp[i][j-1] , arr[i+j-1]}
 * 
 * result[i] := 下标为i开始的区间内最大积
 * result[i] = max(dp[i][j]*sum(arr,i,i+j-1))
 *   
 */
public class Q2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		int [] arr = new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		
//		O(n^2) 20%
//		long count = 0;
//		Long minValue = Long.MAX_VALUE;
//		Long maxValue = Long.MIN_VALUE;
//		int flag = 0;
//		
//		for (int i = 0; i < arr.length && flag < arr.length; i++) {
//			count += arr[i];
//			if(arr[i] < minValue)
//				minValue = arr[i];
//			if(count * minValue >= maxValue){
//				maxValue = count*minValue;
//			}else{
//				count = arr[i];
//				minValue = arr[i];
//				flag += 1;
//				i = flag;
//				
//			}
//		}
//		if(maxValue < arr[arr.length-1]*arr[arr.length-1])
//			maxValue = arr[arr.length-1]*arr[arr.length-1];
//		
//		System.out.println(maxValue);

		int[][] dp = new int[arr.length][arr.length];
		
		for(int i = 0 ; i< dp.length ; i++){
			for(int j = 0 ; j < dp[0].length ; j++){
				dp[i][j] = Integer.MAX_VALUE;
			}
		}
		
		for(int i = 0 ; i< dp.length ; i++){
			for(int j = 1 ; j < dp[0].length && i+j-1 < arr.length; j++){
				dp[i][j] = Math.min(dp[i][j-1], arr[i+j-1]);
			}
		}
		
		//打印dp
		for(int i = 0 ; i < dp.length ; i ++){
			for(int j = 0 ; j <dp[0].length ; j++)
				System.out.print(dp[i][j] + " ");
			System.out.println(" ");
		}
		
		System.out.println("-----");
		
		int[] result = new int[arr.length];
		for(int i = 0 ; i< result.length ; i++){
			result[i] = Integer.MIN_VALUE;
			for(int j = 0 ; j < dp[i].length && i+j-1 <arr.length; j++){
				result[i] = Math.max(result[i], dp[i][j]*sum(arr,i,i+j-1));
			}
		}
		
		//打印result
		for(int i = 0 ; i< result.length ;i++){
			System.out.print(result[i] +" ");
		} 
		
		int max = Integer.MIN_VALUE;
		for(int i = 0 ; i < result.length; i++){
			max = Math.max(max, result[i]);
		}
		System.out.println("");
		System.out.println("--");
		System.out.println(max);
	}

	private static int sum(int[] arr, int i, int j) {
		// TODO Auto-generated method stub
		int result = 0;
		for(int m = i ; m <= j ; m++){
			result += arr[m];
		}
		return result;
	}

}
