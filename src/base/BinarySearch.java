package base;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class BinarySearch {

    public static void main(String[] args) {

        int[] arr = {1, 2, 3,3,3,3, 4, 5, 6, 7};
        System.out.println(Arrays.toString(arr));
        System.out.println(binarySearch(arr, 3));

        System.out.println(binarySearch_2(arr, 0, arr.length - 1, 3));
        System.out.println(getDown(arr, 3));
        System.out.println(getUp(arr, 3));


    }

    //二分查找非递归方法
    public static int binarySearch(int[] arr, int num) {

        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = low + ((high - low) / 2);
            if (num == arr[mid])
                return mid;
            else if (num < arr[mid]) {
                high = mid - 1;
            } else
                low = mid + 1;
        }
        return -1;
    }

    //二分查找递归方法
    public static int binarySearch_2(int[] arr, int low, int high, int num) {
        if (low <= high) {
            int mid = (low + high) / 2;
            if (num == arr[mid])
                return mid;
            else if (num < arr[mid])
                return binarySearch_2(arr, low, mid - 1, num);
            else
                return binarySearch_2(arr, mid + 1, high, num);
        } else
            return -1;
    }

    //求数组中下边界问题
    public static int getDown(int[] arr, int k) {
        int l, r;
        for (l = 0, r = arr.length;l<r;){
            int mid = (l+r)/2;
                if(!(arr[mid] >= k)){
                    l = mid+1;
                }else
                    r =mid;
        }
        return l;
    }

    //求数组中上边界问题
    public static int getUp(int[] arr, int k) {
        int l, r;
        for (l = -1, r = arr.length - 1;l<r;){
            int mid = (l+r+1)/2;
            if(!(arr[mid] <= k)){
                r = mid-1;
            }else
                l = mid;
        }
        return l;
    }
}
