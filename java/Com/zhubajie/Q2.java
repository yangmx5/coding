package Com.zhubajie;

import java.util.HashSet;
import java.util.Scanner;

public class Q2 {

	static HashSet<String> set = new HashSet<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while (sc.hasNextLine()) {
			set.clear();
			int n = Integer.valueOf(sc.nextLine());
			String[] nameList = new String[n];
			for (int i = 0; i < n; i++) {
				nameList[i] = sc.nextLine();
			}
			for (int i = 0; i < n; i++) {
				String name = nameList[i];
				int count = 1;
				if (set.contains(name)) {
					while (set.contains(name + Integer.valueOf(count).toString())) {
						count++;
					}
					System.out.println(name + Integer.valueOf(count).toString());
					set.add(name + Integer.valueOf(count).toString());
				} else {
					System.out.println("OK");
					set.add(name);
				}

			}
		}
	}
}
