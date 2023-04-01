package common;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * @date 2023/3/27
 */
public class CommonUtil {
    public static void printArray(int [] arr){
        System.out.println(Arrays.stream(arr).boxed().collect(Collectors.toList()));
    }
}
