package Com.Xiecheng;

import static org.hamcrest.CoreMatchers.containsString;

import java.util.Scanner;

public class Q3 {
	public static void removeMethod(String s) {
		StringBuffer sb = new StringBuffer();
		int len = s.length();
		int i = 0;
		boolean flag = false;
		for (i = 0; i < len; i++) {
			char c = s.charAt(i);
			if (s.indexOf(c) != s.lastIndexOf(c)) {
				flag = false;
			} else {
				flag = true;
			}
			if (i == s.indexOf(c))
				flag = true;
			if (flag) {
				sb.append(c);
			}
		}
		System.out.print(sb.toString());
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		removeMethod(str);
	}
}
