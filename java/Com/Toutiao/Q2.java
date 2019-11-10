package Com.Toutiao;

import java.util.Scanner;

public class Q2 {

	public static void main(String [] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		char [][] arr = new char[n][m];
		for(int i = 0 ; i < arr.length ; i++){
			for(int j = 0 ; j < arr[0].length ; j++){
				arr[i][j] = (char) sc.nextByte();
			}
		}
		
		
		
	}
	
	private static void change(char[][] arr, int x, int y){
		
	}
	
}
