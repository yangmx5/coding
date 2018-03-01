package Com.SouHu;

import java.util.Scanner;
import java.util.Stack;

public class Q1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String path = sc.nextLine();

		if (path.charAt(0) != '/')
			System.out.println("");
		else {

			String[] arr = path.split("/");
			Stack<String> pathStack = new Stack<>();

			for (int i = 0; i < arr.length; i++) {
				if (arr[i].trim().equals("") || arr[i].equals(".")) {
					continue;
				} else {
					if (arr[i].equals("..")) {
						if (!pathStack.isEmpty()) {
							pathStack.pop();
						}
					} else {
						pathStack.push(arr[i]);
					}
				}
			}

			String result = "";
			while (!pathStack.isEmpty()) {
				result = pathStack.pop() + "/" + result;
			}
			if (result != "") {
				result = "/" + result.substring(0, result.length() - 1);
			}else
				result ="/";
			System.out.println(result);
		}
	}

}
