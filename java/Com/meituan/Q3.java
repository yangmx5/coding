package Com.meituan;

import java.util.Scanner;

public class Q3 {
	public static void main(String[] args) {
		Scanner sca = new Scanner(System.in);
		int len = sca.nextInt();
		int[] a = new int[len];
		for (int i = 0; i < len; i++) {
			a[i] = sca.nextInt();
		}
		
		System.out.println(getTheLengthInDP(a));
		System.out.println(getTheLength(a));
	}
	
	//遍历解法
	public static int getTheLength(int [] a){
		
		int length = 1;
		
		for(int i = 1 ; i < a.length ; i++){
			if((a[i-1] ^ a[i]) == 1){
				length++;
			}
		}
		
		return length;
	}
	
	//交错序列dp解法
	public static int getTheLengthInDP(int [] a){
		int sum = 1;
		int len = a.length;
		int[] temp = new int[len];
		for (int i = 0; i < len; i++) {
			temp[i] = 1;
		}
		for (int i = 1; i < len; i++) {
			int j = i - 1;
			while (j >= 0 && a[i] == a[j])
				--j;
			if (j >= 0) {
				temp[i] += temp[j];
			}

		}
		int max = 1;
		for (int i = 0; i < len; ++i) {
			max = Math.max(max, temp[i]);
		}
		return max;
	} 
	
}