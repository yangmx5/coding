package Com.pinduoduo.yunwei;

import java.util.List;
import java.util.Scanner;

public class Q3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt() ; 
		int m = sc.nextInt();
		
		good [] goods = new good[n];
		for(int i = 0 ; i < n ; i++){
			good temp = new good(sc.nextInt() ,sc.nextInt(), sc.nextInt());
 			goods[i] = temp;
		}
		for(int l  = 0 ; l < m ; l++){
			String order = sc.nextLine();
			String [] orders = order.split(" ");
			switch(orders[1]){
			case "add" :
				System.out.println(add(0,0,0,0,goods));break;
			case "buy" :
				System.out.println(buy());break;
			case "list":
				System.out.println(list());break;
			} 
		}
		
	}
	
	
	
	private static int add(int start , int end , int goodsid ,int count , good [] goods){
	
		return 0;
		
	}
	
	private static int buy(){
		return 0;
	}
	
	private static int list(){
		return 0;
	}
}
class good{
	public int id;
	public int person;
	public int count;
	
	public good(int id , int person , int count) {
		// TODO Auto-generated constructor stub
		this.id = id;
		this.person = person;
		this.count = count;
		
	}
}