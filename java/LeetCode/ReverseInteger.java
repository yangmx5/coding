package LeetCode;

public class ReverseInteger {


    /*
    * Given a 32-bit signed integer, reverse digits of an integer.

Example 1:

Input: 123
Output:  321
Example 2:

Input: -123
Output: -321
Example 3:

Input: 120
Output: 21
*/

    public static int reverse(int x){
        int result = 0;
        while(x != 0){
            int tail = x % 10;
            int newResult = result * 10 + tail;
            if((newResult - tail)/10 != result) return 0;
            result = newResult;
            x=x/10;
        }
        return result;
    }

    public static void main(String [] args){
        System.out.println(reverse(-123));
    }
}
