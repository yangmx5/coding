package Com.sougou;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
		int count = Integer.valueOf(sc.readLine());
		double [] arr = new double[count];
		for(int i=0;i<count;i++) {
			arr[i] = Double.valueOf(sc.readLine());
		}
		
		double maxLength = 0;
		int p = 0;
		for(int t=0;t<count-1;t++) {
			double len = 0;
			if(arr[count-1]-arr[t]<180) {
				len = arr[count-1]-arr[t];
			}else {
				for(int i=count-1;i>0;i--) {
					if(arr[i] - arr[t]<180) {
						p = i;
						break;
					}
				}
				len = 360-(arr[p+1]-arr[t])> arr[p]-arr[t] ? 360-(arr[p+1]-arr[t]) : arr[p]-arr[t];
			}
			if(len >maxLength)
				maxLength = len;
		}
		DecimalFormat df = new DecimalFormat("0.00000000");
		System.out.println(df.format(maxLength));
	}
}