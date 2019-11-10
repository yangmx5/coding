package Com.aLi;

import java.util.Scanner;


public class Q1 {

	/** 请完成下面这个process函数，实现题目要求的功能 **/
	/** 当然，你也可以不按照这个模板来作答，完全按照自己的想法来 ^-^ **/

	private static Model boxTemplate = new Model();

	private static int process(Model[] items) {
		int count = 0;

		int v = 0;
		int price = 0;
		for (int i = 0; i < items.length; i++) {
			if (items[i].length > boxTemplate.length || items[i].width > boxTemplate.width
					|| items[i].height > boxTemplate.height)
				continue;
			if (price >= boxTemplate.price || v >= boxTemplate.getV()) {
				count++;
				v= items[i].getV() ; 
				price = items[i].price;
			} else {
				price += items[i].price;
				v += items[i].getV();
			}
		}
		
		while (price >= boxTemplate.price || v >= boxTemplate.getV()) {
			count++;
			price-= boxTemplate.price;
			v-= boxTemplate.getV();
		} 
		
		if(v > 0)
			count++;

		return count;
	}

	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		boxTemplate.price = 2000;

		while (scanner.hasNext()) {
			boxTemplate.length = scanner.nextInt();
			boxTemplate.width = scanner.nextInt();
			boxTemplate.height = scanner.nextInt();

			int itemNum = scanner.nextInt();
			Model [] items = new Model[itemNum];
			for (int i = 0; i < itemNum; i++) {
				Model item = new Model();
				item.price = scanner.nextInt();
				item.length = scanner.nextInt();
				item.width = scanner.nextInt();
				item.height = scanner.nextInt();
				items[i] = item;
			}
			long startTime = System.currentTimeMillis();
			int boxMinNum = Integer.MAX_VALUE;
			
			System.out.println(process(items));

		}
	}

}

class Model {
	public int price;
	public int length;
	public int height;
	public int width;
	
	public int getV(){
		return length*height*width;
	}
}

