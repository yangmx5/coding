package Com.Lianjia;

import java.util.Scanner;

public class Q3 {

	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		int temp;
		int [] arr = new int[10];
		for(int i = 0 ; i < arr.length ; i++){
			arr[i] = cin.nextInt();
		}
		temp = cin.nextInt();
		
		temp += 30;
		int count = 0;
		for(int i = 0 ; i< arr.length; i++){
			if(arr[i] <= temp)
				count++;
		}
		
		System.out.println(count);
	}
}
