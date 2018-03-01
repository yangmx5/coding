package Com.mi;

import java.util.HashMap;
import java.util.Scanner;

public class Q1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		HashMap<String, Integer> map = new HashMap<>();

		while (sc.hasNextLine()) {
			String temp = sc.nextLine();
			if (temp.equals("-"))
				break;
			String[] arr = temp.split(" ");
			int Id = Integer.valueOf(arr[1]);
			map.put(arr[0], Id);

		}

		while (sc.hasNextLine()) {
			String temp = sc.nextLine();
			if (map.containsKey(temp)) {
				System.out.println(map.get(temp));
			} else {
				boolean flag  =false;
				int length = Integer.MIN_VALUE;
				String keys = "";
				for (String key : map.keySet()) {
					if (temp.matches(key+"/.*" ) && key.length() > length) {
						keys = key;
						flag =true;
					}
				}
				if(!flag){
					System.out.println(0);
				}else{
					System.out.println(map.get(keys));
				}
				
			}

		}

	}

}
