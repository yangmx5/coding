package Com.aiqiyi;

import java.util.Scanner;

public class Q1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int x1 = sc.nextInt();
		int k1 = sc.nextInt();
		int x2 = sc.nextInt();
		int k2 = sc.nextInt();

		int v1b = getBit(x1) * k1;
		int v2b = getBit(x2) * k2;

		if (v1b == v2b) {

			char[] arr1 = Integer.valueOf(x1).toString().toCharArray();
			char[] arr2 = Integer.valueOf(x2).toString().toCharArray();

			int flag = 0;

			for (int i = 0, j = 0, m = 0; m < v1b; m++) {
				if (arr1[i] - '0' > arr2[j] - '0') {
					flag = 1;
					break;
				} else if (arr1[i] - '0' < arr2[j] - '0') {
					flag = 2;
					break;
				}

				i = i < arr1.length-1 ? i + 1 : 0;
				j = j < arr1.length-1 ? j + 1 : 0;

			}

			if (flag == 0) {
				System.out.println("Equal");
			} else if (flag == 1) {
				System.out.println("Greater");
			} else
				System.out.println("Less");

		} else if (v1b > v2b) {
			System.out.println("Greater");
		} else
			System.out.println("Less");

	}

	private static int getBit(int x) {
		int num = 0;
		while (x != 0) {
			num++;
			x /= 10;
		}
		return num;
	}

}
