package Com.threesixzero;

import java.util.Scanner;

public class Q1 {

	
	private static int getMoney(int m , int n , int a , int b , int c ,int d , int x ,int y ,int z){
		
//		int m = 5 , n =5;
//		int a = 1, b=2 ,c =3,d=3;
//		int x = 2,y=1,z=3;
		
		int [][] dp = new int[m+Math.max(b, c)+1][n+Math.max(a, d)+1];
		
		dp[0][0] = 0;
		for(int i= 0 ; i < dp.length && i+Math.max(b, c) < dp.length; i++){
			for(int j = 0 ; j < dp[0].length && j + Math.max(a,d) < dp[0].length; j++){
				dp[i+b][j+a] =Math.max(dp[i][j] + x,dp[i+b][j+a]);			
				dp[i+c][j] = Math.max(dp[i][j] + y,dp[i+c][j]);
				dp[i][j+d] = Math.max(dp[i][j] + z,dp[i][j+d]);
			}
		}
		
		for(int i = 0 ; i < dp.length;i++){
			for(int j = 0 ; j < dp[0].length;j++)
				System.out.print(dp[i][j] + " ");
			System.out.println("");
		}
		
		return dp[m][n];
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt() ;
		int m =sc.nextInt();
		int a = sc.nextInt();
		int b=sc.nextInt();
		int c =sc.nextInt();
		int d=sc.nextInt();
		int x = sc.nextInt();
		int y=sc.nextInt();
		int z=sc.nextInt();
		
		System.out.println(getMoney(m, n, a, b, c, d, x, y, z));
	}
}
