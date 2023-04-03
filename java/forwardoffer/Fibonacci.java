package forwardoffer;

public class Fibonacci {


    public static int FibonacciInRecursion(int n) {
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;
        return FibonacciInRecursion(n - 1) + FibonacciInRecursion(n - 2);
    }

    public static int FibonacciInIteration(int n) {
        int g = 0, f = 1;
        while (--n >= 0) {
            f += g;
            g = f - g;
        }
        return g;
    }

    public static void main(String[] args) {

        System.out.println(Integer.valueOf(FibonacciInRecursion(3)));
        System.out.println(Integer.valueOf(FibonacciInIteration(3)));

        System.out.println(recursion(3));
        System.out.println(dp(3));

    }

    public static int recursion(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return recursion(n - 1) + recursion(n - 2);
    }

    public static int dp(int n) {
        int i = 0, j = 1;
        while (n > 0) {
            int tmp = i;
            i = j;
            j = tmp + i;
            n--;
        }
        return i;
    }
}
