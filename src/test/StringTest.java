package test;

public class StringTest {

//	private String a;
	
	public void run(){
		String a = null ;
		System.out.println(a + "teo");
	}
	
	public static void main(String[] args) {
		StringTest temp = new StringTest();
		temp.run();

		String temp2 = "1232135135";

		String one = temp2.replace("1",";");
		System.out.println(one);
		System.out.println(temp2);



	}
	
}
