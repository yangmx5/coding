package Com.Renren;

import java.util.Scanner;

public class Q1 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n  = sc.nextInt();
		
		System.out.println(solve(n));
	
	}
	
	private static long solve(int n){
		if(n == 1)
			return 1;
		if(n == 2)
			return 3;
		return 2*solve(n-1)+1;
	}
	
}
