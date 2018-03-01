package Com.sougou;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class dp {
	public static void main(String[] args) {
		BufferedReader buf = null;
		buf = new BufferedReader(new InputStreamReader(System.in));
		String str = null;
		try {
			int a = Integer.parseInt(buf.readLine());
			double[] array = new double[a];
			double[] dp = new double[a + 1];
			dp[0] = 0;
			double max = 0;
			for (int i = 0; i < a; i++) {
				array[i] = Double.parseDouble(buf.readLine());
			}
			int begin = 0;
			for (int i = 1; i < a; i++) {
				dp[i] = dp[i - 1] + array[i] - array[i - 1];
				if (dp[i] == 180) {
					max = 180;
					System.out.println(String.format("%.8f", max) + "\n");
					return;
				} else if (dp[i] > 180) {
					if (360 - dp[i] > max)
						max = 360 - dp[i];
					while (dp[i] > 180) {
						if (360 - dp[i] > max)
							max = 360 - dp[i];
						dp[i] = dp[i] - (array[begin + 1] - array[begin]);
						begin++;
					}
					if (dp[i] == 180) {
						max = 180;
						System.out.println(String.format("%.8f", max) + "\n");
						return;
					} else if (dp[i] < 180) {
						if (dp[i] > max)
							max = dp[i];
					}
				} else if (dp[i] < 180) {
					if (dp[i] > max)
						max = dp[i];
				}
			}

			System.out.println(String.format("%.8f", max) + "\n");

		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println();

	}

}
