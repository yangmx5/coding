package base;

import java.util.Arrays;

/*
 * 快速排序
 * 
 */

public class QuickSort {

	public static void main(String[] args) {

		int[] arr = { 2, 5, 1, 4, 6, 8, 1, 2 };

		QuickSort(arr, 0, arr.length - 1);

		System.out.println(Arrays.toString(arr));

	}

	public static int[] QuickSort(int[] arr, int start, int end) {
		if (end > start) {
			int mid = Partition(arr, start, end);
			QuickSort(arr, start, mid);
			QuickSort(arr, mid + 1, end);
		}
		return arr;

	}

	public static int Partition(int[] arr, int start, int end) {
		int key = arr[start];
		int i = start;
		int j = end;

		while (i < j) {

			while (i < j && key <= arr[j]) {
				j--;
			}

			if (i < j) {
				arr[i] = arr[j];
				i++;
			}

			while (i < j && key >= arr[i]) {
				i++;
			}

			if (i < j) {
				arr[j] = arr[i];
				j--;
			}
		}
		arr[i] = key;
		return i;

	}

}
