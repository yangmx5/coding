class Solution {
    public int trap(int[] height) {
        if(height == null || height.length == 0){
            return 0;
        }
        int [] left_max = new int[height.length];
        int [] right_max = new int[height.length];
        left_max[0] = height[0];
        for(int i = 1; i < height.length; i++){
            left_max[i] = Math.max(height[i], left_max[i-1]);
        }
        right_max[height.length-1] = height[height.length-1];
        for(int i = height.length-2; i >= 0; i--){
            right_max[i] = Math.max(height[i],right_max[i+1]);
        }
        int ret = 0;
        for(int i = 0 ; i < height.length - 1; i++){
            ret += Math.min(left_max[i],right_max[i]) - height[i];
        }
        return ret;
    }
    public int trap2(int [] height){
        int len = height.length;
        if(height == null || len == 0){
            return 0;
        }
        int [] heightLeft = new int[len];
        int [] heightRight = new int[len];
        heightLeft[0] = height[0];
        heightRight[len-1] = height[len-1];
        for(int i = 1 ; i < len; i++){
            heightLeft[i] = Math.max(height[i], heightLeft[i-1]);
        }
        for(int i = len-2;  i >= 0; i--){
            heightRight[i] = Math.max(height[i],heightRight[i+1]);
        }
        int ret = 0;
        for(int i = 0 ;i <  len - 1; i++){
            ret += Math.min(heightLeft[i], heightRight[i]) - height[i];
        }
        return ret;
    }
}
