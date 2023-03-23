package test.baseclass;

import java.util.Random;


/*
 * 生成随机数
 */
public class RandomNum {

	public static void main(String[] args) {

		int max = 20;
		int min = 10;
		Random random = new Random();

		while (min-- > 0) {
			// int s = random.nextInt(max) % (max - min + 1) + min;
			//random类获取随机数
			int s = random.nextInt(max);
			
			//Math类获取0-1之间的随机数double类型
			double l = Math.random();
			//int n = (int) ((l*10)%(max - min + 1) + min);
			int n = (int) (l*10);
			long m = System.currentTimeMillis();

			System.out.println(s + " / " + l + " / " + n);
		}

	}
}
