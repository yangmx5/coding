package Com.Lianjia;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Q1 {

	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		int a, b;

		a = cin.nextInt();
		long[] group = new long[a];
		for (int i = 0; i < a; i++) {
			group[i] = cin.nextInt();
		}
		b = cin.nextInt();
		long [] q = new long[b];
		for (int i = 0; i < b; i++) {
			q[i] = cin.nextInt();
		}

		long[] temp_q = Arrays.copyOfRange(q, 0, q.length);
		Arrays.sort(temp_q);
		HashMap<Long, Integer> temp = new HashMap<Long, Integer>();
		long count = 0;
		for (int i = 0, j = 0; i < group.length && j < temp_q.length; i++) {
			count += group[i];
			if (count >= temp_q[j]) {
				temp.put(temp_q[j], i + 1);
				j++;
			}
		}
		for (int m = 0; m < q.length; m++) {
			System.out.println(temp.get(q[m]));
		}

	}
}
