package Com.wangyi;

import java.util.Scanner;

public class OneselfLive {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			long x = sc.nextLong();
			long f = sc.nextLong();
			long d = sc.nextLong();
			long p = sc.nextLong();

			if (d < x)
				System.out.println(0);
			else if (d / x <= f)
				System.out.println((int) Math.floor(((double) d) / ((double) x)));
			else
				System.out.println((int) Math.floor(((double) d + f * p) / ((double) p + x)));
			
			System.out.println(Math.floor(0.01));
		}
	}

}
