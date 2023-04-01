package forwardoffer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TheMaxAdd {

	
	/*
	 * 子数组最大连续和
	 *
	 */
	
	public static int FindGreatestSumOfSubArray(int [] array){
		int a = 1 ;
		int count  = array[0];
		List<Integer> result = new ArrayList<Integer>();
	
		result.add(count);
		for(int i = a ; i < array.length ; i++){
			int temp = 0 ;
			if(count > 0){
				temp = count + array[i];
			}
			else
				temp = array[i];
			if(temp <= 0){
				a= i+1;
				result.add(count);
				count = temp;
			}
			else{
				count = temp;
				result.add(count);
			}
		}
		if(result.size() > 0 )
			return Collections.max(result);
		else
			return 0;
		
	}

	
	public static int maxSum(int[] arr) {
		if (arr == null || arr.length == 0) {
			return 0;
		}
		int max = Integer.MIN_VALUE;
		int cur = 0;
		for (int i = 0; i != arr.length; i++) {
			cur += arr[i];
			max = Math.max(max, cur);
			cur = cur < 0 ? 0 : cur;
		}
		return max;
	}
	
	public static void main(String[] args) {
		
		int [] temp = {1, 5, -1 ,3};
		int [] temp1 = {-1};
		System.out.println(maxSum(temp1));
		
		
	}
	
}
