package Com.Toutiao;

import java.util.Scanner;

public class Q1{
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt();
        int [] arr = new int[n];
        for(int i = 0; i < n ; i++){
        	arr[i] = sc.nextInt();
        }
        
        int count = 0 ;
        for(int i = x-1 ; ;i--){
        	if(i < 0)
        		i = n-1 ;
        	if(arr[i] <= 0){
        		arr[i] += count;
        		break;
        	}
        	arr[i]--;
        	count++;    
        	
        }
        for(int i = 0 ; i < arr.length-1 ; i++)
        	System.out.print(arr[i]+ " ");
        System.out.print(arr[arr.length-1]);
        
    }
}