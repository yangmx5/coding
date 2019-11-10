package Com.Lianjia;

import java.util.Scanner;

public class Q4 {

	public static void main(String args[]) {
		Scanner cin = new Scanner(System.in);
		int g1 = cin.nextInt();
		int s1 = cin.nextInt();
		int b1 = cin.nextInt();
		int g2 = cin.nextInt();
		int s2 = cin.nextInt();
		int b2 = cin.nextInt();
		
		if(g1>=g2 && s1<s2&&b1<b2){
			Math.floor((Math.floor((b2-b1)/9.0)+s2-s1)/9.0);
		}
		else if(g1<g2 && s1>= s2 && b1<b2){}
		else if(g1<g2 && s1 < s2 && b1>=b2){}
		else if(g1 >= g2 && s1>=s2 && b1<b2){}
		else if(g1 < g2 && s1>=s2 && b1>=b2){}
		else if(g1 >= g2 && s1<s2 && b1>=b2){
			
		}
		else if(g1 >= g2 && s1>=s2 && b1>=b2){
			System.out.println(0);
		}
		else if(g1 <g2 && s1<s2 && b1<b2){
			System.out.println(-1);
		}
		
		
	}

}
