package hotOneHundred;

import java.util.Arrays;

/**
 * @author fouthed
 * @date 2023/5/15
 */
public class DailyTemperature {
    public static void main(String[] args) {
        int[] tmp = new int[]{73, 74, 75, 71, 69, 72, 76, 73};
        System.out.println(Arrays.toString(resolve(tmp)));
    }

    public static int[] resolve(int[] arr) {
        int[] ret = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            for(int j = i ; j < arr.length ; j++){
                if (arr[j] > arr[i]) {
                    ret[i] = j-i;
                    break;
                } else {
                    ret[i] = 0;
                }
            }

        }
        return ret;
    }
}
