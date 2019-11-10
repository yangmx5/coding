package Com.didi;

import java.util.Scanner;

public class WQ1 {

	public static void main(String[] args) {

		 Scanner sc = new Scanner(System.in);
		 int n = sc.nextInt();
		
		 int[] arr = new int[n];
		 for (int i = 0; i < n; i++) {
		 arr[i] = sc.nextInt();
		 }
//		int[] arr = {0, 0, 1, 0 };
//		int n = arr.length;

		int temp = arr[0];
		int left = 0;
		int max = 0;

		for (int i = 1; i < n; i++) {
			for (int j = i; j < n; j++) {
				temp ^= arr[j];
				if (j == n - 1 && temp != 0 && i + 1 < n) {
					temp = arr[i + 1];
					left = i + 1;
				}
				if (temp == 0 && j < n-1) {
					max++;
					temp = arr[j + 1];
					left = j + 1;
					i = j;
				}
				
			}
		}
		System.out.println(max);
	}
}
