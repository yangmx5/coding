package Com.didi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Q2 {

	 public static void main(String[] args) {
	        Scanner in = new Scanner(System.in);
	        	       	        
	        String s1 = in.nextLine();
	        String s2 = in.nextLine();
    
	        String[] arr = s1.split(" ");
	        
	        Integer [] temp = new Integer[arr.length];
	        for(int i =0 ; i < arr.length ; i++)
	        	temp[i] = Integer.valueOf(arr[i]);
	         
	        int k = Integer.valueOf(s2);
	        
	        System.out.println(maxSum(temp,k));

	    }

	private static Integer maxSum(Integer[] temp, int k) {
		
		Arrays.sort(temp);
		return temp[temp.length-k];
		
	}
	
}
