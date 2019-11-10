package Com.Qunar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Q2 {

	private static int INF = Integer.MAX_VALUE;
	// dist[i][j]=INF<==>no edges between i and j
	private int[][] dist;
	// the distance between i and j.At first,dist[i][j] is the weight of edge
	// [i,j]
	private int[][] path;
	private List<Integer> result = new ArrayList<Integer>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int p = sc.nextInt();
		int r = sc.nextInt();

		String[] arr = new String[2 * r];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.next();
		}

		HashMap<String, Integer> map = new HashMap<>();
		for (int i = 0; i < r * 2; i += 2) {
			String s1 = arr[i];
			String s2 = arr[i + 1];
			if (p != 0 && !map.containsKey(s1)) {
				map.put(s1, p--);
			}
			if (p != 0 && !map.containsKey(s2)) {
				map.put(s2, p--);
			}
		}

		System.out.println(map.keySet().toString());

		int n = map.keySet().size();
		int[][] dis = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++)
				if (i == j)
					dis[i][j] = 0;
				else
					dis[i][j] = INF;
		}

		for (int i = 0; i < r * 2; i += 2) {
			String s1 = arr[i];
			String s2 = arr[i + 1];
			int v1 = map.get(s1);
			int v2 = map.get(s2);
			dis[v1 - 1][v2 - 1] = 1;
			dis[v2 - 1][v1 - 1] = 1;
		}

		for (int i = 0; i < dis.length; i++) {
			for (int j = 0; j < dis[0].length; j++)
				System.out.print(dis[i][j] + " ");
			System.out.println("");
		}
		System.out.println("==");
		
		
		Q2 graph = new Q2(5);
		graph.findCheapestPath(0, n-1, dis);
		int max = -1;
		for (int i = 0; i < graph.dist.length; i++) {
			for (int j = 0; j < graph.dist[0].length; j++)
				if (i == j)
					continue;
				else
					max = Math.max(max, graph.dist[i][j]);
		}
		
		for (int i = 0; i < graph.dist.length; i++) {
			for (int j = 0; j < graph.dist[0].length; j++)
				System.out.print(graph.dist[i][j] + " ");
			System.out.println("");
		}
		
		if (max == INF)
			System.out.println("DISCONNECTED");
		else
			System.out.println(max);
	}

	public Q2(int size) {
		this.path = new int[size][size];
		this.dist = new int[size][size];
	}

	public void findCheapestPath(int begin, int end, int[][] matrix) {
		floyd(matrix);
		result.add(begin);
		findPath(begin, end);
		result.add(end);
	}

	public void findPath(int i, int j) {
		int k = path[i][j];
		if (k == -1)
			return;
		findPath(i, k);
		result.add(k);
		findPath(k, j);
	}

	public void floyd(int[][] matrix) {
		int size = matrix.length;
		// initialize dist and path
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				path[i][j] = -1;
				dist[i][j] = matrix[i][j];
			}
		}
		for (int k = 0; k < size; k++) {
			for (int i = 0; i < size; i++) {
				for (int j = 0; j < size; j++) {
					if (dist[i][k] != INF && dist[k][j] != INF && dist[i][k] + dist[k][j] > dist[i][j]) {// dist[i][k]+dist[k][j]>dist[i][j]-->longestPath
						dist[i][j] = dist[i][k] + dist[k][j];
						path[i][j] = k;
					}
				}
			}
		}

	}
}
