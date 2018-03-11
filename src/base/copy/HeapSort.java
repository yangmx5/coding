package base.copy;

import java.util.Arrays;

public class HeapSort {

    public static void main(String[] args) {

        int[] arr = { 4, 2, 5, 6, 1, 6, 3 };
        heapSort(arr);
        System.out.println(Arrays.toString(arr));

    }


    private static void HeapAdjust(int[] arr, int s, int n) {
        int j, rc = arr[s];
        for (j = 2 * s + 1; j < n - 1; j = j * 2 + 1) {
            if (j < n && arr[j] < arr[j + 1])
                j++;
            if (rc > arr[j])
                break;
            arr[s] = arr[j];
            s = j;
        }
        arr[s] = rc;
    }

    public static void heapSort(int[] arr) {
        int i;
        for (i = arr.length / 2 - 1; i >= 0; i--) {
            HeapAdjust(arr, i, arr.length);
        }
        for (i = arr.length - 1; i > 0; i--) {
            arr[0] += arr[i];
            arr[i] = arr[0] - arr[i];
            arr[0] = arr[0] - arr[i];
            HeapAdjust(arr,0,i);
        }
    }

}
