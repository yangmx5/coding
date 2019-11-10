package base;

import java.util.Arrays;

/**
 * 典故:据说著名犹太历史学家 Josephus有过以下的故事：在罗马人占领乔塔帕特后，39 个犹太人与Josephus及他的朋友躲到一个洞中，
 * 		39个犹太人决定宁愿死也不要被敌人到，于是决定了一个自杀方式，41个人排成一个圆圈，由第1个人 开始报数，每报数到第3人
 * 		该人就必须自杀，然后再由下一个重新报数，直到所有人都自杀身亡为止。然而Josephus 和他的朋友并不想遵从，Josephus要
 * 		他的朋友先假装遵从，他将朋友与自己安排在第16个与第31个位置，于是逃过了这场死亡游戏。
 * @param num 人数
 * @param per 每多少人抽取一个
 * @return 约瑟夫环数组
 */
public class Josephus {
public static int[] arrayOfJosephus(int num, int per) {
	int[] nums = new int[num];
	int count =0;
	int pos = 0;
	
	for (int i = 1; i <= num; i++) {
		while(true){
			pos = pos%num;
			if (nums[pos]==0) {
				count++;
			}
			
			if (count == per) {
				count = 0;
				break;
			}
			
			pos++;
		}
		
		nums[pos] = i;
	}
	
	return nums;
}

//约瑟夫环实现
public static void main(String[] args) {
	int manNum = 10;
	int per = 3;
	int aliveNum = 3;
	
	int[] man = Josephus.arrayOfJosephus(manNum, per);

	System.out.println("约琴夫环："+Arrays.toString(man));
	System.out.println("L表示3个存活的人要放的位置：");
	
	for (int i = 0; i < manNum; i++) {
		if (man[i] > manNum-aliveNum)
			System.out.print("L");
		else
			System.out.print("D");

		if ((i + 1) % 5 == 0)
			System.out.print("  ");
	}
}
}
