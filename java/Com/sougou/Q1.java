package Com.sougou;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

public class Q1 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// Scanner sc = new Scanner(System.in);
		BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.valueOf(sc.readLine());
		double[] arr = new double[n];

		// Map<Double , Integer> s = new HashMap<>();

		for (int i = 0; i < n; i++) {
			arr[i] = Double.valueOf(sc.readLine());
			// s.put(arr[i], i);
		}

		double max = 0;

		for (int i = 0; i < arr.length; i++) {
			double temp = arr[i] + 180;
			
			
		}
		DecimalFormat df = new DecimalFormat("#.00000000");
		System.out.println(df.format(max));
	}
	
	private int getBin(double [] arr , double l){
		int low = 0; 
		int high = arr.length-1;
		while(low <= high){
			int mid = low+((high-low)/2);
			if(l == arr[mid] || mid == low)
				return mid;
			else if(l < arr[mid]){
				high=mid-1;
			}else
				low = mid +1;
		}		
		return -1;
	}
	

}
