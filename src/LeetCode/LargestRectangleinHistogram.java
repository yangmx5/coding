package LeetCode;

import java.util.Stack;

public class LargestRectangleinHistogram {

	
	public static int largestRectangleArea(int [] heights){
		
		Stack<Integer> s = new Stack<Integer>();
		int Max = 0;
		int top;
		int temp;
		
		int i = 0;
		int n = heights.length;
		
		
		while(i < n){
			if(s.empty() || heights[i] >= heights[s.peek()]){
				s.push(i++);
			}else{
				top = s.pop();
				temp = heights[top]*(s.empty()?i:i-s.peek()-1);
				Max = Math.max(Max,temp);
			}
		}
		
		while(!s.empty()){
			top = s.pop();
			temp = heights[top]*(s.empty()?i:i-s.peek()-1);
			Max = Math.max(Max,temp);	
		}
		
		return Max;
		
	}
	
	public static void main(String[] args) {
		int [] heights = {2,1,5,6,2,3};
		System.out.println(largestRectangleArea(heights));
	}
}
