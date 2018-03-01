package forwardoffer;

public class Fibonacci {

	
	public static int FibonacciInRecursion(int n){
		if(n == 0)
			return 0;
		if(n == 1)
			return 1;
		return FibonacciInRecursion(n-1) + FibonacciInRecursion(n-2);
	}
	
	public static int FibonacciInIteration(int n){
		int g = 0 , f = 1;
		while(--n >= 0){
			f += g;
			g = f - g;
		}
		return g;
	}
	
	public static void main(String[] args) {
		
		System.out.println(Integer.valueOf(FibonacciInRecursion(3)));
		System.out.println(Integer.valueOf(FibonacciInIteration(3)));
		
		
	}
}
