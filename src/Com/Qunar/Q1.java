package Com.Qunar;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class Q1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int k = sc.nextInt();
		int [] arr= new int[n];
		for(int i =0 ; i < n ; i++){
			arr[i] = sc.nextInt();
		}
			
		Deque<Integer> q =new ArrayDeque<>();
		int count = 0;
		int left = 0;
		int right = 0;
		boolean flag = false;
		for(int i = 0 ; i< n ;){
			if(count < k){
				count += arr[i];
				q.add(arr[i]);
				right++;
				i++;
			}else if(count > k){
				count -= q.getFirst();
				q.removeFirst();
				left++;
			}else if(count == k){
				flag = true;
				break;
			}
		}
		
		if(count > k){
			count -= q.getFirst();
			q.removeFirst();
			left++;
		}
		
		if(flag || count ==k){
			System.out.println("YES");
			
			int [] temp = new int[right - left];
			for(int i = left , j= 0 ; i < right && j < temp.length ; i++,j++){
				temp[j] = arr[i];
			}
			Arrays.sort(temp);
			
			for(int i = 0 ; i < temp.length-1 ; i++){
				if(arr[i] == 0 ){
					continue;
				}
				System.out.print(temp[i] +" ");
			}
			System.out.println(temp[temp.length-1]);
			
//			for(int i = left ; i < right-1 ; i++){
//				System.out.print(arr[i] +" ");
//			}
//			System.out.println(arr[right-1]);
		}else{
			System.out.println("NO");
		}
		
		
		
	}
}
