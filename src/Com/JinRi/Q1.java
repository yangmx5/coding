package Com.JinRi;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class node {

	public long x;
	public long y;

}

public class Q1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		node[] arr = new node[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = new node();
			arr[i].x = sc.nextInt();
			arr[i].y = sc.nextInt();
		}

		Arrays.sort(arr, new Comparator<node>() {

			@Override
			public int compare(node o1, node o2) {
				// TODO Auto-generated method stub
				if (o1.x < o2.x)
					return -1;
				else
					return 1;
			}
		});

		boolean[] result = new boolean[arr.length];
		Long maxValue = Long.MIN_VALUE;
		for (int i = arr.length - 1; i >= 0; i--) {
			if (arr[i].y > maxValue) {
				result[i] = true;
				maxValue = arr[i].y;
			}
		}

//		for (int i = 0; i < arr.length; i++) {
//			System.out.print(result[i] + " ");
//		}

		for (int i = 0; i < arr.length; i++) {
			if (result[i])
				System.out.println(arr[i].x + " " + arr[i].y);
		}

	}

}
