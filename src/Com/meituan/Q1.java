package Com.meituan;

import java.util.Scanner;

public class Q1 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n, k, i, j;
		n = scanner.nextInt();

		long [] a = new long[n+1];
		long [] dp = new long[n+1];
		
		int res;
		dp[0] = 0;
		res = 0;
		for (i = 1; i <= n; i++) {
			a[i] = scanner.nextInt();
			dp[i] = dp[i - 1] + a[i];
		}
		
		k = scanner.nextInt();
		for (i = 0; i <= n; i++) {
			for (j = 0; j <= n - i; j++) {
				if ((dp[j + i] - dp[i]) % k == 0)
					res = Math.max(res, j);
			}
		}
		
		System.out.println(res);
	}
}
