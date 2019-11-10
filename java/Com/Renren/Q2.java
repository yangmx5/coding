package Com.Renren;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Q2 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();
		int k = sc.nextInt();

		Node[] arr = new Node[k];
		for (int i = 0; i < k; i++) {
			arr[i] = new Node(sc.nextInt(), sc.nextInt());
		}

		Arrays.sort(arr, new Comparator<Node>() {

			@Override
			public int compare(Node o1, Node o2) {
				// TODO Auto-generated method stub
				if (o1.x > o2.x)
					return 1;
				else if (o1.x < o2.x)
					return -1;
				else {
					if (o1.y > o2.y)
						return 1;
					else
						return -1;
				}
			}
		});

		Node now = new Node(1, 1);
		String result = "";
		boolean flag = false;

		for (int i = 0; i < k; i++) {
			Node temp = arr[i];
			if (temp.x < now.x || temp.y < now.y)
				flag = true;

			while (temp.x > now.x) {
				result += "D";
				now.x++;
			}
			while (temp.y > now.y) {
				result += "R";
				now.y++;
			}

		}

		while (now.x < n) {
			result += "D";
			now.x++;
		}
		while (now.y < m) {
			result += "R";
			now.y++;
		}
		if (flag)
			System.out.println("Impossible");
		else
			System.out.println(result);
	}
}

class Node {
	public int x;
	public int y;

	public Node(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
