package Com.zhubajie;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

public class Q1 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = Integer.valueOf(sc.nextLine());
		int[] input = new int[n];
		for (int i = 0; i < n; i++) {
			input[i] = Integer.valueOf(sc.nextLine());
		}
		int[] temp = input;
		Arrays.sort(temp);
		int max = temp[n - 1];
		
		
		BigInteger [] dp = new BigInteger[max];

		if (max > 2) {
			dp[0] = new BigInteger("1");
			dp[1] = new BigInteger("2");
			for (int i = 2; i < max; i++) {
				dp[i] = dp[i - 1].multiply(new BigInteger("2")).add(dp[i-2]);
				
			}
		} else if (max == 1) {
			dp[0] = new BigInteger("1");
		} else if (max == 2) {
			dp[0] = new BigInteger("1");
			dp[1] = new BigInteger("2");
		}
		for (int i = 0; i < input.length; i++) {
			System.out.println(dp[input[i]-1].mod(new BigInteger("32767")));
		}

	}

}
