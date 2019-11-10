package Com.threesixzero;

import java.util.Scanner;
import java.util.Stack;

public class Q3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}

		n = sc.nextInt();
		int [] arr2 = new int[n];
		for(int i = 0 ; i < arr2.length ; i++){
			arr2[i] = sc.nextInt();
		}
		
		int [][] dp = new int[arr.length][arr2.length];
		int count = 0;
		int count2 =0;
		for(int i =0 ; i< arr.length; i++){
			count += arr[i];
		}
		
		for(int i =0 ; i< arr2.length; i++){
			count2 += arr2[i];
		}
		int min = Integer.MAX_VALUE;
		for(int i = 0 ; i < dp.length ; i++){
			for(int j = 0 ; j < dp[0].length; j++){
				dp[i][j] = (count -arr[i] + arr2[j] ) - (count2 -arr2[j] + arr[i]);
				min = Math.min(dp[i][j], min);
			}
		}
		
		System.out.println(0);
	}
}
