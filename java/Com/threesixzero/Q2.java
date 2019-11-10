package Com.threesixzero;

import java.util.Scanner;
import java.util.Stack;

public class Q2 {

	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int [] arr = new int[n];
		for(int i = 0 ; i < arr.length; i++){
			arr[i] = sc.nextInt();
		}
		
//		Stack<Integer> s = new Stack<Integer>();
//		Stack<Integer> temp =  new Stack<Integer>();
		int [] result = new int[arr.length];
//		for(int i = arr.length-1 ; i >0; i--){
//			if(s.isEmpty() || arr[i] <= arr[s.peek()])
//				s.push(i);
//			while(!s.isEmpty() && arr[i] > arr[s.peek()]){
//				temp.push(s.peek());
//				result[s.pop()]++;
//			}
//			
//			while(!temp.isEmpty()){
//				s.push(temp.pop());
//			}
//			
//		}
		
		
//		for(int i = 0 ; i < arr.length ; i++){
//			for(int j = 0 ; j < i ; j++){
//				if(arr[j] > arr[i])
//					result[i]++;
//			}
//			
//		}

		
		for(int i =0 ; i < result.length-1; i++)
			System.out.print(result[i] + " ");
		System.out.print(result[result.length-1]);
	}
}
