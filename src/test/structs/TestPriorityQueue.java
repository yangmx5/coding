package test.structs;

import java.util.PriorityQueue;

public class TestPriorityQueue {

	public static void main(String[] args) {

		PriorityQueue<String> queue = new PriorityQueue<>();

		
		queue.add("13");
		queue.add("145");
		queue.add("2311");
		queue.add("231");
		queue.add("ayw511");
		queue.add("axf894");
		

		while (!queue.isEmpty()) {
			
			System.out.println(queue.poll());
		}

	}

}
