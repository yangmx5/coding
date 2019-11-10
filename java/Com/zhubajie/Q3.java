package Com.zhubajie;

public class Q3 {

	
	
	public Integer get(int n){
		if(n == 1)
			return 1;
		if(n == 2)
			return 2;
		return 2*get(n-1) + get(n-2);
		
	}
	
}
