package Com.RenRencopy;

import java.util.Scanner;

public class Q3 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		while (n-- > 0) {
			line l1 = new line(new node(sc.nextInt(), sc.nextInt()), new node(sc.nextInt(), sc.nextInt()));
			line l2 = new line(new node(sc.nextInt(), sc.nextInt()), new node(sc.nextInt(), sc.nextInt()));
			line l3 = new line(new node(sc.nextInt(), sc.nextInt()), new node(sc.nextInt(), sc.nextInt()));

			if (l1.isRepeat(l2)) {
				if((l1.isOn(l3.node1) || l1.isOn(l3.node2))&&(l2.isOn(l3.node1)||l2.isOn(l3.node2)))
					System.out.println("YES");
			} else if (l1.isRepeat(l3)) {
				if((l1.isOn(l2.node1) || l1.isOn(l2.node2))&&(l3.isOn(l2.node1)||l3.isOn(l2.node2)))
					System.out.println("YES");
			} else if (l2.isRepeat(l3)) {
				if((l3.isOn(l1.node1) || l3.isOn(l1.node2))&&(l2.isOn(l1.node1)||l2.isOn(l1.node2)))
					System.out.println("YES");
			} else
				System.out.println("NO");
		}

	}

}

class line {
	public node node1;
	public node node2;

	public line(node node1, node node2) {
		this.node1 = node1;
		this.node2 = node2;
	}

	public boolean isRepeat(line l) {
		if (l.node1.isRepeat(this.node1) || l.node2.isRepeat(this.node2) || l.node1.isRepeat(node2)
				|| l.node2.isRepeat(node1))
			return true;
		else
			return false;
	}

	public boolean isRight(line l) {
		return true;
	}

	public boolean isOn(node n) {
		if (((node1.x - node2.x) / (node1.y - node2.y)) * n.y == n.x) {
			if (n.isRepeat(node1) || n.isRepeat(node2))
				return false;
			else
				return true;
		} else
			return false;
	}

}

class node {
	public int x;
	public int y;

	public node(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public boolean isRepeat(node n) {
		if (this.x == n.x && this.y == n.y)
			return true;
		else
			return false;
	}
}