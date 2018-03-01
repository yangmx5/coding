package Com.pinduoduo;

public class Q1 {

	/*
	 * 无序数组中，元素可为负数，正数，0
	 * 求其中三个数的最大乘积
	 */
	public static void main(String[] args) {
		int[] arr1 = { -1, 2, 3, 2 };
		int[] arr2 = { -1, -2, 3, 2 };
		int[] arr3 = { -1, -2, -3, 2 };
		int[] arr4 = { -1, -2, -3, -2 };
		
		int[] arr5 = {-1, -2, -3, -2,0};
		int[] arr6 = { -1, -2, -3,0, -2 };
		int[] arr7 = { -1, -2, 0,3, -2 };

		System.out.println(Integer.valueOf(getBiggest(arr1)));
		System.out.println(Integer.valueOf(getBiggest(arr2)));
		System.out.println(Integer.valueOf(getBiggest(arr3)));
		System.out.println(Integer.valueOf(getBiggest(arr4)));
		System.out.println(Integer.valueOf(getBiggest(arr5)));
		System.out.println(Integer.valueOf(getBiggest(arr6)));
		System.out.println(Integer.valueOf(getBiggest(arr7)));
		
	}

	public static int getBiggest(int[] arr) {
		if (arr.length < 3)
			return getMul(arr);
		int[] temp = { arr[0], arr[1], arr[2] };
		int max = getMul(temp);
		for (int i = 3; i < arr.length; i++) {
			
			int n0 = temp[1]* temp[2]*arr[i];
			int n1 = temp[0]* temp[2]*arr[i];
			int n2 = temp[0]* temp[1]*arr[i];
			if (n0 >= n1 && n0 >= n2) {
				temp[0] = arr[i];
				continue;
			}
			if (n1 >= n0 && n1 >= n2) {
				temp[1] = arr[i];
				continue;
			}
			if (n2 >= n1 && n2 >= n0) {
				temp[2] = arr[i];
				continue;
			}
		}
		return getMul(temp);

	}

	public static int getMul(int[] arr) {
		int result = 1;
		for (int i = 0; i < arr.length; i++) {
			result *= arr[i];
		}
		return result;
	}
}
