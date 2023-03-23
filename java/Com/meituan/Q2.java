package Com.meituan;

import java.util.Arrays;
import java.util.Scanner;

public class Q2 {

	/*
	 *
K的倍数
sum[i] 表示前i项和，sum[i]%=k后，找sum[i] 在左边出现过没有，出现过的最左的位置，就是最远的距离



改试卷：
贪心：
首先第一个必选 最大数！否则肯定中间会不够用。

如果最大数超过一个，yes，因为，可以按照从最大到最小依次访问
如果最大数只有一个，小于最大数的数的和大于等于最大数，yes，否则 no
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int [] arr = new int[n];
		
		int sum = 0;
		for(int i = 0 ; i < arr.length; i++){
			arr[i]  = sc.nextInt();
			sum+= arr[i];
		} 
		
		Arrays.sort(arr);
//		System.out.println(sum);
		boolean result = false;
		
		if(arr[arr.length-1] == arr[arr.length-2])
			result = true;
		else{
			if(sum-arr[arr.length-1] >= arr[arr.length-1])
				result = true;
		}
		
//		System.out.println(sum);
		
		if(result)
			System.out.println("Yes");
		else
			System.out.println("No");
	}
	
}
