package Com.Lianjia;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Q1_2 {
	public static void main(String[] args) {
		Scanner cin = new Scanner(System.in);
		int a, b;

		a = cin.nextInt();
		long[] group = new long[a];
		for (int i = 0; i < a; i++) {
			group[i] = cin.nextInt();
		}
		b = cin.nextInt();
		long [] q = new long[b];
		for (int i = 0; i < b; i++) {
			q[i] = cin.nextInt();
		}
		
		
		for(int i = 0 ; i < q.length ;i++){
			long count = 0;
			for(int j = 0 ; j < group.length; j++){
				count += group[j];
				if(count >= q[i]){
					System.out.println(j+1);
					break;
				}
			}
		}

	}
}
