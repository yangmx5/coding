package Com.mi;

import java.util.HashMap;
import java.util.Scanner;

public class Q2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		HashMap<String, Integer> map = new HashMap<>();

		while (sc.hasNextLine()) {
			String temp = sc.nextLine();
			temp = "_" + temp+"_";
			temp.replaceAll(".", "_");
			for(int i = 0 ; i < temp.length() ; i++){
				if(temp.charAt(i) == '_')
					continue;
				if(temp.charAt(i) - 'A' >= 26){
					
					
				}
					 
			}
			System.out.println(temp);
		}
		
	}

}
