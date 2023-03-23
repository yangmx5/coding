package base.copy;

import java.util.Arrays;

public class BinarySearch {
	
	//二分查找递归方法
	public static int BinarySearchInRecurise(int [] arr , int start , int end,int num){
		
		if(start <= end){
			int mid = (start +end)/2;
			if(num == arr[mid])
				return mid;
			else if(num < arr[mid])
				return BinarySearchInRecurise(arr, start, mid, num);
			else
				return BinarySearchInRecurise(arr, mid+1, end, num);
				
		}else
			return -1;
		
	}
	
	public static int BinarySearchInWhile(int [] arr,int num){
		int low = 0 ; 
		int high = arr.length;
		while(low <= high){
			int mid = (low + high)/2;
			if(arr[mid] == num)
				return mid;
			else if(arr[mid] < num)
				low = mid+1;
			else
				high = mid-1;
		}
		return -1;
	}
	
	public static void main(String[] args) {
		int [] arr = {2,34,511,2, 3,5,6};
		Arrays.sort(arr);
		
		System.out.println(Arrays.toString(arr));
		
		System.out.println(BinarySearchInWhile(arr, 1));
		
	}
	
}
