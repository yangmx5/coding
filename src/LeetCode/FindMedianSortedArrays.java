package LeetCode;

import java.util.Arrays;

/*
 * ÕÒÖĞÎ»Êı
 * 
 */
public class FindMedianSortedArrays {
	
	//AC
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
	
	public static void main(String[] args) {
		int [] nums1 = {1,2};
		int [] nums2 = {3,4};
		System.out.println(findMedianSortedArrays(nums1,nums2));
	}
}
