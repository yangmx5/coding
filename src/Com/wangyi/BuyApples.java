package Com.wangyi;

import java.util.Scanner;
import java.util.Arrays;

/*
小易去附近的商店买苹果，奸诈的商贩使用了捆绑交易，只提供6个每袋和8个每袋的包装(包装不可拆分)。
可是小易现在只想购买恰好n个苹果，小易想购买尽量少的袋数方便携带。如果不能购买恰好n个苹果，小易将不会购买。 
输入描述:
输入一个整数n，表示小易想购买n(1 ≤ n ≤ 100)个苹果


输出描述:
输出一个整数表示最少需要购买的袋数，如果不能买恰好n个苹果则输出-1

 */
public class BuyApples {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		while (sc.hasNextInt()) {

			int num = sc.nextInt();
			System.out.println(CountBags(num));
		}

	}

	public static boolean JudgeOdd(int num)// 判断是奇数
	{
		if (num % 2 == 0)
			return false;//
		else
			return true;// 奇数返回true
	}

	public static int CountBags(int N) {
		int i;
		int minBag = N;// 最小的袋数

		if (JudgeOdd(N))
			return -1;

		for (i = 0; i <= N / 6; i++) {
			if ((N - 6 * i) % 8 == 0) {
				int j = (N - 6 * i) / 8;
				minBag = minBag > (i + j) ? (i + j) : minBag;
			}
		}

		if (minBag != N)
			return minBag;
		else
			return -1;
	}

}
