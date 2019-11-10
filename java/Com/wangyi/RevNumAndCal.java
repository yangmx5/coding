package Com.wangyi;

import java.util.Scanner;


/*
 * 对于一个整数X，定义操作rev(X)为将X按数位翻转过来，并且去除掉前导0。例如:
 * 如果 X = 123，则rev(X) = 321;
 * 如果 X = 100，则rev(X) = 1.
 * 现在给出整数x和y,要求rev(rev(x) + rev(y))为多少？ 
 * 
 */
public class RevNumAndCal {

	public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);
	        int num1 = sc.nextInt();
	        int num2 = sc.nextInt();
	        System.out.println(rev(rev(num1)+rev(num2)));
	}
	
	
	public static int rev(int num){
		
		String temp = Integer.valueOf(num).toString();
		
		String tar = "";
		for(int i = temp.length()-1; i >= 0 ; i--){
			tar += temp.charAt(i);
		}
		int result = Integer.valueOf(tar) ;  
		
		return result;
	}
	
}
