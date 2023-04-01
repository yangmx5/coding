package forwardoffer;

public class ReverseSentence {

	
	/*
	 * 反转字符串
	 * 
	 */
	public static String Reversesentence(String str){
		
		String result = "";
		for(int i = str.lastIndexOf(" ") ; i != -1 ; i = str.lastIndexOf(" ")){
			result += str.substring(i +1 ,str.length());
			str = str.substring(0 , i);
			result += " ";
		}
		result += str;
		return result;
		
	}
	
	public static void main(String[] args) {
		System.out.println(Reversesentence("student a am I"));
	}
	
}
