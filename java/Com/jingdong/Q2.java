package Com.jingdong;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class Q2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		Map<Integer, Integer> map = new HashMap<>();

		int result = 0;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				int temp = superPow(i, Integer.valueOf(j).toString().toCharArray());
				if (map.containsKey(temp)) {
					map.put(temp, (Integer) map.get(temp) + 1);
				} else
					map.put(temp, 1);
			}
		}

		for (Entry<Integer, Integer> entry : map.entrySet()) {

			System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());

			// result += (entry.getValue()) * ((Integer)
			// entry.getValue()==1?1:((Integer) entry.getValue()-1));
			result += (entry.getValue()) * (entry.getValue());
			result %= 1000000007;

		}
		System.out.println(result);
		
	}

	private static int pow(int a, int b, int mod) {
		int ret = 1;
		int x = a % mod;
		while (b != 0) {
			if ((b & 1) == 1) {
				ret = ret * x % mod;
			}

			x = x * x % mod;

			b >>= 1;
		}

		return ret;
	}

	public static int superPow(int a, char[] j) {
		int ans = 1;
		int mod = 1000000007;

		for (int i = 0; i < j.length; i++) {
			ans = pow(ans, 10, mod) * pow(a, j[i] - '0', mod) % mod;
		}

		return ans;
	}

}
