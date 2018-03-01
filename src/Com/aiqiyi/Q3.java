package Com.aiqiyi;

import java.text.DecimalFormat;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Q3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		int result = 0;
	
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
//				if(dp[j][i])
//					break;
				
//				Double temp = ;
//				System.out.print(Math.round(temp));
//				Integer copy = ;
//				System.out.println("--" + copy);
				if (Math.abs((int) Math.round(Math.sqrt(i) * Math.sqrt(j)) - Math.sqrt(i) * Math.sqrt(j)) < 0.0000001) {
					result++;
				}
			}
		}
		
//		for(int i = 0 ; i < dp.length ; i++){
//			for(int j = 0 ; j < dp[0].length ; j++){
//				System.out.print(dp[i][j] + " ");
//			}
//			System.out.println("");
//		}

		System.out.println(result);
	}
}
