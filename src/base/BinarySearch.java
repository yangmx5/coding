package base;

import java.util.Arrays;

public class BinarySearch {

	public static void main(String[] args) {
		
		int [] arr = {1,2,3,4,5,6,7};
		System.out.println(Arrays.toString(arr));
		System.out.println(binarySearch(arr, 3));
		
		System.out.println(binarySearch_2(arr, 0 , arr.length-1,3));
		
	}
	
	//二分查找非递归方法
	public static int binarySearch(int [] arr , int num){
		
		int low = 0; 
		int high = arr.length-1;
		while(low <= high){
			int mid = low+((high-low)/2);
			if(num == arr[mid])
				return mid;
			else if(num < arr[mid]){
				high=mid-1;
			}else
				low = mid +1;
		}		
		return -1;
	}
	
	//二分查找递归方法
	public static int binarySearch_2(int [] arr ,int low, int high, int num){
		if(low <= high){
			int mid = (low+high)/2;
			if(num == arr[mid])
				return mid;
			else if(num < arr[mid])
				return binarySearch_2(arr, low, mid-1, num);
			else
				return binarySearch_2(arr, mid+1, high, num);
		}
		else
			return -1;
	}
}
