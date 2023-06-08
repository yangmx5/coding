package hotBack;

/**
 * @author fouthed
 * @date 2023/6/8
 * 盛最多水的容器
 * 双指针法，从两端向中间夹进
 */
public class MaxArea {

    public static void main(String[] args) {
        int[] height = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(resolve(height));
    }

    public static int resolve(int[] height) {
        int l = 0, r = height.length - 1;
        int max = 0;
        while (l != r) {
            int area = Math.min(height[l], height[r]) * (r - l);
            max = Math.max(max, area);
            if (height[l] <= height[r]) {
                l++;
            } else {
                r--;
            }
        }
        return max;
    }
}
