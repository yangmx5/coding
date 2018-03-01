package forwardoffer;

import java.util.ArrayList;
import java.util.Collections;

/*
 * 全排列
 * “abc” 的全排列形式
 * 
 */
public class AllPaiLie {

	public static ArrayList<String> Permutation(String str) {

		ArrayList<String> res = new ArrayList<>();

		if (str != null && str.length() > 0) {
			PermutationHelper(str.toCharArray(), 0, res);
			Collections.sort(res);
		}

		return res;
	}

	private static void PermutationHelper(char[] cs, int i, ArrayList<String> list) {
		if (i == cs.length - 1) {
			list.add(String.valueOf(cs));
		} else {

			for (int j = i; j < cs.length; ++j) {
				if (j == i || cs[j] != cs[i]) {
					swap(cs, i, j);
					PermutationHelper(cs, i + 1, list);
					swap(cs, i, j);
				}
			}
		}
	}

	private static void swap(char[] cs, int i, int j) {

		char temp = cs[i];

		cs[i] = cs[j];
		cs[j] = temp;

	}

	public static void main(String[] args) {

		ArrayList<String> result = new ArrayList<>();
		result = Permutation("abc");
		System.out.println(result);

	}

}
