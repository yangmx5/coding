package Com.Xiecheng;

import java.util.Arrays;
import java.util.Scanner;

public class Q2 {

	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int [] arr1 = new int[n];
		for(int i= 0 ; i < n ; i++){
			arr1[i] = sc.nextInt();
		}
		
		n = sc.nextInt();
		int [] arr2 = new int[n];
		for(int i =0  ; i< n ; i++){
			arr2[i] = sc.nextInt();
		}
		
		System.out.println(findMedianSortedArrays(arr1,arr2));
		
//		int [] arr  = Arrays.copyOf(arr1, arr1.length+arr2.length);
//		System.arraycopy(arr2, 0, arr, arr1.length, arr2.length);
//		
//		Arrays.sort(arr);
//		
//		int left = 0;
//		for(int i = 0 ; i< arr.length ;i++){
//			if(arr[i] == arr[left])
//				continue;
//			else{
//				arr[left++] =arr[i];
//			}
//		}

	}

	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int [] temp = new int[nums1.length+nums2.length];
        for(int i = 0 ; i < nums1.length ; i++)
            temp[i] = nums1[i];
        for(int i = 0 , j = nums1.length; i < nums2.length ; i++,j++)
            temp[j] = nums2[i];
        Arrays.sort(temp);
        if(temp.length %2 == 0)
            return (temp[temp.length/2-1]+temp[temp.length/2])/2.0;
        else
            return (double)temp[temp.length/2];
    }
}
