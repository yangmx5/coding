package Com.wangyi;

import java.util.Arrays;
import java.util.Scanner;

public class QuireNum {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long k = sc.nextLong();

		long[] dp = new long[n];

		Arrays.fill(dp, 0);

		if (n >= 3) {
			dp[0] = 0;
			dp[1] = k;
			dp[2] = getNum(k, 2);

			for (int i = 3; i <= n; i++) {
				dp[i] = 2 * dp[i - 1];
			}
			System.out.println(dp[n]);
		}else if(n ==0){
			System.out.println(0);
		}else if(n ==1){
			System.out.println(k);
		}else if(n ==2){
			System.out.println(getNum(k, 2));
		}
	}

	public static int getNum(long k, int num) {
		int count = 0;

		for (int i = 1; i < num; i++) {
			if (num % i == 0)
				count++;
		}

		return (int) (count + (k - num + 1));
	}

}
