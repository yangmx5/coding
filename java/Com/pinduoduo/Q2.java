package Com.pinduoduo;

public class Q2 {

	
	/*
	 * String大数乘积
	 * 支持正负
	 */
	
	public static void main(String[] args) {
		String num1 = "21346543634631643146";
		String num2 = "123514651367563416";
		System.out.println(mul(num1, num2));
	}
	
	public static String Mulitply(String num1 , String num2){
		int move = 0;
		String reuslt= "";
		for( int i = num1.length()-1 ; i >= 0 ; i--){
			
			int move2 = 0 ; 
			String midNum = "";
			for(int j = num2.length()-1 ; j >= 0 ; j--){
				
				int temp = Integer.valueOf(num1.charAt(i))*Integer.valueOf(num2.charAt(j));
				temp+=move2;
				move2 = temp/10;
				temp %= 10;
				midNum = temp+midNum;
			}
			
		}
		
		return null;
	}

	
	public static String mul(String str1,String str2){
		//符号判断处理
		int judge = 0;
		if(str1.charAt(0) == '-' || str2.charAt(0) == '-'){
			
			if(str1.charAt(0) == str2.charAt(0))
				judge = 0;
			else
				judge = 1;
		}
		
		str1 = str1.substring( firstNumberIndex(str1));
		str2 = str2.substring( firstNumberIndex(str2));
		
		StringBuffer bstr=new StringBuffer();
		int i=0,j=0;
		for(i=0;i<str1.length()+str2.length();i++){
			bstr.append('0');
			}
		int k=bstr.length()-1,add=0,temp=0;
		for(j=str2.length()-1;j>=0;j--){
			if(str2.charAt(j)!='0'){
				for(i=str1.length()-1;i>=0;i--){
					k=i+j+1;
					temp=(str2.charAt(j)-'0')*(str1.charAt(i)-'0')+(bstr.charAt(k)-'0');
					bstr.setCharAt(k--, (char)('0'+temp%10));
					add=temp/10;
					while(add!=0){
						temp=add+bstr.charAt(k)-'0';
						bstr.setCharAt(k--, (char)('0'+temp%10));
						add=temp/10;
						}
					}
				}
			}
		
		String result = bstr.substring(firstNotZeroIndex(bstr));
		if(judge != 0){
			result = "-" + result;
		}
		return result;
		}
	
	private static int firstNotZeroIndex(StringBuffer str){
		for(int i=0;i<str.length();i++)
			if(str.charAt(i)!='0')
				return i;
		return str.length()-1;
		}
	
	private static int firstNumberIndex(String str1){
		for(int i =0 ; i< str1.length(); i++){
			if( 0 <= (int)str1.charAt(i) - '0' && 9 >=(int)str1.charAt(i) - '0')
				return i;
		}
		return str1.length()-1;
	}
}
