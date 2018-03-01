package Com.Haikang;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Q1 {



	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {

			String str = sc.nextLine();
			String[] arr = str.split(",");

			int n = Integer.valueOf(arr[0]);
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			sdf.setLenient(false);
			try {
				if(n < 3){
					Exception err = new Exception("erro");
					throw err ;
				}
				Date t1 = sdf.parse(arr[1]);
				Date t2 = sdf.parse(arr[2]);
				long between = (t2.getTime() - t1.getTime());
				long cir = between/(15*n*60*1000);
				System.out.print(++cir+";");
				between %= (15*n*60*1000);
				long coun = between/(15*60*1000);
				between %= (15*60*1000);
				if(between > 5*60*1000){
					coun++;
					System.out.print(coun +"-");
					coun +=1;
					coun %= n;
					System.out.println(coun);
				}else{
					coun++;
					System.out.println(coun +"-" + coun);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println("incorrect data");
			}

			

		}

	}

}
