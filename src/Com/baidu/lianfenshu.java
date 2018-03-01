package Com.baidu;

public class lianfenshu {

	private double getValue(int [] arr , int n){
		return arr[n]+1/(getValue(arr,n-1));
	}
	
}
