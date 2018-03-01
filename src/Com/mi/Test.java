package Com.mi;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Test {

	public static void main(String[] args) {
		String str = "SUN公司被Oracle收购，是否意味着java被逼上了死路？MY.AST_Parser12";
		String s = "\\d+.\\d+|\\w+";
		Pattern pattern = Pattern.compile(s);
		Matcher ma = pattern.matcher(str);

		while (ma.find()) {
			System.out.println(ma.group());
		}

	}

}
