package LeetCode;

import java.util.Stack;

public class PolishValue {
	
	
	/*
	 * 后缀表达式求值
	 * 逆波兰式
	 * 
	 */

	public static void main(String[] args) {

		String [] arr = {"2", "1", "+", "3", "*"};
		System.out.println(Integer.valueOf(evalRPN(arr)));
		
		
	}

	public static int evalRPN(String[] tokens) {
			Stack<Integer> stack = new Stack<Integer>();
	
			for (int i = 0; i < tokens.length; i++) {
	
				if (tokens[i].equals("+")) {
					Integer a = stack.pop();
					Integer b = stack.pop();
					a+=b;
					stack.push(a);
					continue;
				}
				if (tokens[i].equals("-")) {
					Integer a = stack.pop();
					Integer b = stack.pop();
					a-=b;
					stack.push(a);
					continue;
				}
				if (tokens[i].equals("*")) {
					Integer a = stack.pop();
					Integer b = stack.pop();
					a*=b;
					stack.push(a);
					continue;
				}
				if (tokens[i].equals("/")) {
					Integer a = stack.pop();
					Integer b = stack.pop();
					a/=b;
					stack.push(a);
					continue;
				}
				stack.push(Integer.valueOf(tokens[i]));
			}
			
			return stack.pop();
	}
}
