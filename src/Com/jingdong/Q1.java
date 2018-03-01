package Com.jingdong;

import java.util.Scanner;

public class Q1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String s = sc.nextLine();
		char [] arr = s.toCharArray();
		
		int left = 0;
		int result = 1;
		for(int i =0 ; i < arr.length ; i++){
			if(arr[i] == '(')
				left++;
			if(arr[i] == ')'){
				result *= left;
				left--;
			}
		}
		
		System.out.println(result);
	}
	
}
