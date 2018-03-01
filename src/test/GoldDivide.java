package test;

import java.util.Arrays;
import java.util.PriorityQueue;

//长工分金条

public class GoldDivide {

	public static void main(String[] args) {

		Integer[] employee = { 6, 7, 8, 9 };
		//System.out.println(getCount(employee).toString());
		System.out.println(getCountByUsePriorityQueue(employee).toString());

	}

	//每次循环使用数组排序
	public static Integer getCount(Integer[] employee) {

		int result = 0;

		for (int i = 0; i < employee.length; i++) {

			int temp = 0;

			Arrays.sort(employee);
			if (i + 1 < employee.length) {

				temp += employee[i];
				employee[i] = Integer.MIN_VALUE;

				temp += employee[i + 1];
				employee[i + 1] = Integer.MIN_VALUE;

			}
			employee[i] = temp;

			result += temp;

		}

		return result;
	}

	
	//使用优先队列
	public static Integer getCountByUsePriorityQueue(Integer[] employee) {

		int result = 0;

		PriorityQueue<Integer> q = new PriorityQueue();

		for (int i = 0; i < employee.length; i++) {
			q.add(employee[i]);
		}
		
		while (!q.isEmpty()) {
			Integer temp = 0;
			Integer n1 = q.poll();
			Integer n2 = q.poll();
			if(n2 != null){
				temp = n1 + n2;
				q.add(temp);
			}					
			result += temp;
		}

		return result;
	}

}
