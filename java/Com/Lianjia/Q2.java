package Com.Lianjia;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Q2 {

	public static void main(String args[]) {
		Scanner cin = new Scanner(System.in);
		int a ;

		a = cin.nextInt();
		Integer [] arr = new Integer[a];
		for(int i = 0 ;i < a ;i++){
			arr[i] = cin.nextInt();
		}
		
		Arrays.sort(arr);
		Integer cun = arr[0];
		for(int i = 1 ; i < arr.length ; i++){
			if(arr[i] == cun){
				arr[i] = null;
			}else{
				cun = arr[i];
			}
		}
		
		for(int i= 0 ; i<arr.length ;i++)
			System.out.print(arr[i]+" ");
		System.out.println("");
		
		int nLength =0;
		for(int i = 0 ; i< arr.length ; i++){
			if(arr[i] != null)
				nLength++;
		}
		
		Integer [] arr_f = new Integer[nLength];
		for(int i = 0 ,j =0; i< arr.length && j<arr_f.length; i++){
			if(arr[i] != null){
				arr_f[j] = arr[i];
				j++;
			}
		}
		System.out.println(arr_f.length);
		for(int i = 0 ; i< arr_f.length; i++){
			System.out.print(arr_f[i] + " ");
		}
		
	}

}
