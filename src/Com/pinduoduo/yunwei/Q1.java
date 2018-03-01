package Com.pinduoduo.yunwei;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/*
2 5
5 6 10 1 30
4 34
3 35
 */
public class Q1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();

		int[] sugar = new int[m];
		for (int i = 0; i < m; i++) {
			sugar[i] = sc.nextInt();
		}

		Arrays.sort(sugar);

		PriorityQueue<bear> queue = new PriorityQueue<>(n,new Comparator<bear>() {

			@Override
			public int compare(bear o1, bear o2) {
				// TODO Auto-generated method stub
				if (o1.fight > o2.fight)
					return -1;
				else
					return 1;
			}
		});

		for(int i = 0 ; i < n ; i++){
			bear temp = new bear(sc.nextInt(),sc.nextInt());
			queue.add(temp);
		}
		
		while (!queue.isEmpty()) {
			bear m_bear = queue.poll();
			for (int j = sugar.length - 1; j >= 0; j--) {
				if (m_bear.hungery > 0 && m_bear.hungery - sugar[j] >= 0) {
					m_bear.hungery -= sugar[j];
					sugar[j] = 0;
				}
			}
			System.out.println(m_bear.hungery);
		}
	}

}

class bear {
	public int fight;
	public int hungery;

	public bear(int fight, int hungery) {
		// TODO Auto-generated constructor stub
		this.fight = fight;
		this.hungery = hungery;
	}
}
