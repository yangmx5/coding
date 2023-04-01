package Com.wangyi;

import java.util.*;

/*
 * 
 * 小易有一个圆心在坐标原点的圆，小易知道圆的半径的平方。小易认为在圆上的点而且横纵坐标都是整数的点是优雅的，
 * 小易现在想寻找一个算法计算出优雅的点的个数，请你来帮帮他。
 * 例如：半径的平方如果为25
 * 优雅的点就有：(+/-3, +/-4), (+/-4, +/-3), (0, +/-5) (+/-5, 0)，一共12个点。 
 * 
 * 输入为一个整数，即为圆半径的平方,范围在32位int范围内。
 * 
 * 输出为一个整数，即为优雅的点的个数
 */
public class DifferPoint {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		double count = 0;
		for (int i = 0, j = (int) Math.sqrt(num); i <= j;) {
			int temp = i * i + j * j;
			if (temp < num)
				i++;
			else if (temp > num)
				j--;
			else if (temp == num) {
				if (i == j) {
					count += 0.5;
					i++;
				} else {
					count++;
					i++;
				}
			}
		}
		int test = (int) Math.sqrt(num);
		if (test * test == num) {
			count--;
			System.out.println((int) (count * 8 + 4));
		} else
			System.out.println((int) (count * 8));

	}

	public static int count(int n) {
		int count = 0;
		double r = Math.sqrt(n);
		for (int i = 0; i < r; i++) {
			double j = Math.sqrt(n - i * i);
			if (Math.abs(j - Math.round(j)) <= 0.000000001) {
				count++;
			}
		}
		return 4 * count;
	}
}
