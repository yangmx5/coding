package Com.Lianjia;

import java.util.Arrays;
import java.util.Scanner;

public class Q6 {

	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		int n = cin.nextInt();
		int [] arr = new int[n];
		int  m = cin.nextInt();
		int k = cin.nextInt();
		for(int i = 0 ; i < arr.length ; i++){
			arr[i] = cin.nextInt();
		}
		
		int count = 0;
		int [] maxValue = new int[arr.length];
		for(int i = 0 ; i< arr.length; i++){
			int max = Integer.MIN_VALUE;
			int cur = arr[i];
			int temp = m;
			for(int j = i+k ; j < arr.length && temp > 0; j+= k,temp--){
				cur += arr[j];
				max = Math.max(max, cur);
				cur = cur < 0 ? 0 : cur;
			}
			maxValue[i] = max;
		}
		Arrays.sort(maxValue);
		
		System.out.println(maxValue[maxValue.length-1]);
	}
	
}
