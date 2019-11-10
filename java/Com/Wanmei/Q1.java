package Com.Wanmei;

import java.util.Scanner;

public class Q1 {
/*
 *
3
3
-2 -3 3 -5 -10 1 0 30 -5
 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n  = sc.nextInt();
		int m = sc.nextInt();
		
		int [][] dp = new int[n][m];
		for(int i =0 ; i< dp.length ; i++){
			for(int j = 0 ; j < dp[i].length ; j++){
				dp[i][j] = sc.nextInt();
			}
		}
	
		int count = 0;
		int min = Integer.MAX_VALUE;
		for(int i = 0 ,j = 0; i < dp.length && j < dp[0].length ;){
			count += dp[i][j];
			if(count <= 0)
				min = Math.min(min, count);
			if(i+1 >= dp.length){
				j++;continue;
			}
			if(j+1 >= dp[0].length){
				i++;continue;
			}
			if(dp[i+1][j] >= dp[i][j+1]){
				i++;continue;
			}
			if(dp[i+1][j] < dp[i][j+1]){
				j++;continue;
			}
			
		}
//		count += dp[n-1][m-1];
//		System.out.println(count);
//		if(count <= 0)
//			min = Math.min(min, count);
//		System.out.println(min);
		
		System.out.println(min==Integer.MAX_VALUE?1:1-min);
		
	}
	
}
