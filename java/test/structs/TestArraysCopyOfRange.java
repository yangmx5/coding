package test.structs;

import java.util.Arrays;

public class TestArraysCopyOfRange {
	
	public static void main(String[] args) {
		
		Integer [] a = new Integer[]{1,2,3,4,5,6};
		
		
		Integer[] b = Arrays.copyOfRange(a, 1, 4);
		//开始下标至第几个元素
		
		for(int i = 0 ;i < b.length ; i++){
			System.out.println(b[i]);
		}
		
		
	}
	
}
