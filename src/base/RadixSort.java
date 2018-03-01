package base;

import java.util.Arrays;

public class RadixSort {
	/**
	 * 基数排序
	 * 简介:基数排序法又称“桶子法”,顾名思义,它是透过键值的部份资讯，将要排序的元素分配至某些“桶”中，藉以达到排序的作用
	 * 其时间复杂度为O (nlog(r)m)，其中r为所采取的基数，而m为堆数
	 * 稳定排序方式
	 * @param nums 待排序数组
	 * @d 基数
	 */
	public static void sort(int[] nums,int d){
		int k = 0;
		int n = 1;
		int len = nums.length;
		
		//分成nums.length个桶
		int[][] radixArray = new int[len][len];
		//每个桶放的个数组成的数组
		int[] tempArray = new int[len];
		
		//还在位数内
		while (n<=d) {
			for (int i = 0; i < len; i++) {
				//个,十,百,千...
				int temp = (nums[i]/n)%10;
				//存入特定桶的特定位置
				radixArray[temp][tempArray[temp]] = nums[i];
				tempArray[temp]++;
			}
			
			for (int i = 0; i < len; i++) {
				if (tempArray[i] != 0) {
					for (int j = 0; j < tempArray[i]; j++) {
						//数组重组
						nums[k] = radixArray[i][j];
						k++;
					}
					//重置,以防下次循环时数据出错
					tempArray[i] = 0;
				}
			}
			
			//重置,以防下次循环时数据出错
			k = 0;
			//进位
			n *=10;
		}
	}
	
	// 基数排序的实现
	public static void main(String[] args) {

		int[] nums = { 23, 71, 82, 34, 15, 61, 91,30, 53, 14 };

		RadixSort.sort(nums, 10);
		System.out.println(Arrays.toString(nums));
	}
}