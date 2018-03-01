package base;

import java.util.Arrays;

public class HeapSort {

	private static void heapAdjust(int[] arr, int s, int n) {
		int j, rc = arr[s];
		for (j = 2 * s + 1; j < n-1; j =j*2+1) {
			if (j < n && arr[j] < arr[j + 1])
				j++;
			if (rc > arr[j])
				break;
			arr[s] = arr[j];
			s = j;
		}
		arr[s] = rc; 
	}

	// 堆排序
	public static void heapSort(int[] items) {
		int t, i;
		for (i = items.length / 2 - 1; i >= 0; i--) {
			heapAdjust(items, i, items.length);// 创建大顶堆
			for(int j = 0 ; j < items.length;j++)
				System.out.print(items[j]+ " ");
			System.out.println("");
		}
		for (i = items.length - 1; i > 0; i--) {
			t = items[0];
			items[0] = items[i];
			items[i] = t; // 交换
			heapAdjust(items, 0, i);
			for(int j = 0 ; j < items.length;j++)
				System.out.print(items[j]+ " ");
			System.out.println("");
		}
	}

	public static void main(String[] args) {

		int[] arr = { 4, 2, 5, 6, 1, 6, 3 };
		heapSort(arr);
		System.out.println(Arrays.toString(arr));

	}
}
