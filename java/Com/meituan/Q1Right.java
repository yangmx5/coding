package Com.meituan;

import java.util.Scanner;


/*
 *  //记录整个数组的同余前缀和的最小下标和最大下标  
            max[mod] = Math.max(max[mod], i);//相同余数的下标存进来，保留最大下标  
            min[mod] = Math.min(min[mod], i);//保留最小下标  
            // 如果 a%b = c%b ,则a-c = b*k,k为常数  
        }  
  
        //然后，同余前缀和的最大下标与最小下标之差，取差的最大值就是最大长度  
 */
public class Q1Right {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] nums = new int[n];
		int[] sums = new int[n + 1];
		sums[0] = 0;
		for (int i = 1; i < n + 1; i++) {
			nums[i - 1] = sc.nextInt();
			sums[i] = sums[i - 1] + nums[i - 1];
		}
		int k = sc.nextInt();
		int[] max = new int[k];
		int[] min = new int[k];
		for (int i = 0; i < k; i++) {
			max[i] = -1;
			min[i] = n + 1;
		}
		for (int i = 0; i < n + 1; i++) {
			int mod = sums[i] % k;
			max[mod] = Math.max(max[mod], i);
			min[mod] = Math.min(min[mod], i);
		}
		int count = 0;
		for (int i = 0; i < k; i++) {
			if (max[i] != -1 && min[i] != n + 1) {
				count = Math.max(count, max[i] - min[i]);
			}
		}

		System.out.println(count);
	}

}