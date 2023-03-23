package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

//打靶计算分数，参考leetcode 的 burstBallon
public class CountScore {

	public void test() {

	
		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> score1 = new ArrayList<>();
		while (sc.hasNextInt()) {
			int temp = sc.nextInt();
			score1.add(temp);
		}

		
		Integer[] score = new Integer[score1.size()];
		score = score1.toArray(score);

		// Integer [] score = {4,2,3,0,3};
		int[] countScore = new int[score.length];

		for (int i = 0; i < score.length; i++) {
			if (score[i] == 0)
				countScore[i] = 0;
			else {
				int left = 0;
				int right = 0;
				if (i - 1 < 0 || score[i - 1] == 0)
					left = 1;
				else
					left = score[i - 1];
				if (i + 1 >= score.length || score[i + 1] == 0)
					right = 1;
				else
					right = score[i + 1];
				countScore[i] = score[i] * left * right;
			}
		}

		Arrays.sort(countScore);

		System.out.println(countScore[countScore.length - 1]);

	}

	public static void main(String[] args) {

//		Scanner sc = new Scanner(System.in);
//		ArrayList<Integer> score1 = new ArrayList<>();
//		while (sc.hasNextInt()) {
//			int temp = sc.nextInt();
//			score1.add(temp);
//		}

		Integer[] score = {3,1,5,8};
		
		System.out.println(maxCoins(score));
		
	}

	public static int maxCoins(Integer[] score) {
		int[] nums = new int[score.length + 2];
		int n = 1;
		for (int x : score)
			if (x > 0)
				nums[n++] = x;
		nums[0] = nums[n++] = 1;

		int[][] dp = new int[n][n];
		for (int k = 2; k < n; ++k)
			for (int l = 0; l < n - k; ++l) {
				int r = l + k;
				for (int m = l + 1; m < r; ++m)
					dp[l][r] = Math.max(dp[l][r], nums[l] * nums[m] * nums[r] + dp[l][m] + dp[m][r]);
			}

		for(int i = 0 ; i < dp.length; i++){
		
			for(int j = 0 ; j < dp[i].length; j++)
				System.out.print(dp[i][j] + " ");
			System.out.println("");
		}
		
		return dp[0][n - 1];
	}
}
