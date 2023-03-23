package Com.mogujie;

import java.util.Scanner;

public class Q1 {

	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNextLine()){
			date temp = new date(sc.nextInt() , sc.nextInt(), sc.nextInt());
			System.out.println(days(temp));
		}
	}
	
	public static int days(date date) 
	{ 
	    int sum=0; 
	    int a[] = {0,31,28,31,30,31,30,31,31,30,31,30,31}; 
	    for(int i=0;i<date.month;i++) 
	    { 
	        sum=sum+a[i]; 
	    } 
	    sum=sum+date.day; 
	    if((date.year%4==0&&date.year%100!=0)||(date.year%400==0)) 
	        sum++; //判断是否是闰年
	    return sum; 
	} 
	 
}

class date{
	public int year;
	public int month;
	public int day;
	public date(int year, int month ,int day){
		this.year = year;
		this.month = month;
		this.day = day;
	}
}
