package base.copy;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        int[] arr = {2, 5, 1, 4, 6, 8, 1, 2};
        quickSort2(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static int[] quickSort2(int[] arr, int start, int end) {
        int i, j, key;
        if (start > end) return arr;
        key = arr[start];
        i = start;
        j = end;
        while (i < j) {
            while (arr[j] >= key && i < j)
                j--;
            while (arr[i] <= key && i < j)
                i++;
            if (i < j) {
                int t = arr[i];
                arr[i] = arr[j];
                arr[j] = t;
            }
        }
        arr[start] = arr[i];
        arr[i] = key;
        quickSort2(arr, start, i - 1);
        quickSort2(arr, i + 1, end);
        return arr;
    }

    public static int[] quickSort1(int[] arr, int start, int end) {
        if (start < end) {
            int mid = Partition(arr, start, end);
            quickSort1(arr, start, mid);
            quickSort1(arr, mid + 1, end);
        }
        return arr;
    }

    private static int Partition(int[] arr, int start, int end) {
        int i = start, j = end;
        int key = arr[i];
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
