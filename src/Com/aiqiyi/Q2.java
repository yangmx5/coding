package Com.aiqiyi;

import java.util.Scanner;

public class Q2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String str = sc.nextLine();
		char[] arr = str.toCharArray();

		int count = 0;
		int max = 0;

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == '(') {
				count++;
				max = Math.max(max, count);
			}else{
				count--;
			}
		}
		
		System.out.println(max);

	}
}
