package Com.didi;

import java.util.ArrayList;
import java.util.Scanner;
public class Q1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        ArrayList<Integer> arr  = new ArrayList<Integer>();
        while (in.hasNextInt()) {//注意while处理多个case
            int a = in.nextInt();
            arr.add(a);
        }
        
        Integer [] temp = arr.toArray(new Integer[arr.size()]);
        
        System.out.println(maxSum(temp));

    }
    public static int maxSum(Integer[] a) {
		if (a == null || a.length == 0) {
			return 0;
		}
		int max = Integer.MIN_VALUE;
		int cur = 0;
		for (int i = 0; i != a.length; i++) {
			cur += a[i];
			max = Math.max(max, cur);
			cur = cur < 0 ? 0 : cur;
		}
		return max;
	}
}