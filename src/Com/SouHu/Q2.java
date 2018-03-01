package Com.SouHu;

import java.util.Arrays;
import java.util.Scanner;

public class Q2 {

	private static int left = 0;
	private static int right = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		int result = 0;

		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
			result += arr[i];

		}

		int[] temp = longestPalindromeL(arr);
		if (temp.equals(arr)) {
			System.out.println(result);
		} else {
			for (int i = 0; i < left; i++) {
				result += arr[i];
			}
			for (int i = arr.length - 1; i > right; i--) {
				result += arr[i];
			}
			System.out.println(result);
		}
	}

	public static int[] longestPalindromeL(int[] s) {
		int n = s.length;
		int[] res = null;

		boolean[][] dp = new boolean[n][n];

		for (int i = n - 1; i >= 0; i--) {
			for (int j = i; j < n; j++) {
				dp[i][j] = s[i] == s[j] && (j - i < 3 || dp[i + 1][j - 1]);

				if (dp[i][j] && (res == null || j - i + 1 > res.length)) {
					res = Arrays.copyOfRange(s, i, j + 1);
					left = i;
					right = j + 1;
				}
			}
		}
		return res;
	}
}
