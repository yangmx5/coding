package LeetCode;

/*Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Determine if you are able to reach the last index.

For example:
A = [2,3,1,1,4], return true.

A = [3,2,1,0,4], return false.

*/


public class JumpGame {

    public static boolean canJump(int[] nums) {

/*
        boolean[] dp = new boolean[nums.length];
        dp[0] = true;
        for (int i = 0; i < dp.length; i++) {
            for (int j = i; j <= i + nums[i] && j < dp.length; j++) {
                dp[j] = dp[i];
            }
        }

        return dp[nums.length - 1];
*/

        int max = 0;
        for(int i=0;i<nums.length;i++){
            if(i>max) {return false;}
            max = Math.max(nums[i]+i,max);
        }
        return true;
    }



    public static void main(String[] args) {
        int[][] nums = {{2, 3, 1, 1, 4}, {3,2,1,0,4}
        };
        for (int i = 0; i < nums.length; i++) {
            System.out.println(canJump(nums[i]));
        }


    }

}
