package Com.wangyi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;



/*
 * 小易来到了一条石板路前，每块石板上从1挨着编号为：1、2、3.......
 * 这条石板路要根据特殊的规则才能前进：对于小易当前所在的编号为K的 石板，小易单次只能往前跳K的一个约数(不含1和K)步，
 * 即跳到K+X(X为K的一个非1和本身的约数)的位置。 小易当前处在编号为N的石板，他想跳到编号恰好为M的石板去，小易想知道
 * 最少需要跳跃几次可以到达。
 * 例如：
 * N =4，M = 24：
 * 4->6->8->12->18->24
 * 于是小易最少需要跳跃5次，就可以从4号石板跳到24号石板 
 * 
 * 
 * 输入为一行，有两个整数N，M，以空格隔开。
 * (4 ≤ N ≤ 100000)
 * (N ≤ M ≤ 100000)
 * 
 * 输出小易最少需要跳跃的步数,如果不能到达输出-1
 * 
 * 思路：将1-M个石板看做一个结果数组res，
 * 每个res[i]储存着从起点到这一步最小的步数，
 * 其中0为不能到达。从起点开始对res进行遍历，
 * 先求i的所有约数（即从res[i]能走的步数），
 * 然后更新那几个能到达的位置的最小步数
 * （如果不能到达则更新为此时位置的最小步数+1，
 * 如果是能到达的就更新为min（已记录的最小步数，此处的最小步数+1）），
 * 遍历一遍后得到结果。
 * 
 */
public class JumpStone {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n;
        int m;
        while(in.hasNext()){
            n = in.nextInt();
            m = in.nextInt();
            System.out.println(solveDP(n,m));
        }

    }
    private static int solveDP(int n,int m){
        int[] dp = new int[m+1]; // 到达 i位置需要的最小步数
        if(m==n)
            return 0;
        Arrays.fill(dp, Integer.MAX_VALUE);
//        System.out.println(Arrays.toString(dp));
        dp[n] = 0;//使n位置为0
        for(int i=n;i<=m;i++){
            if(dp[i] == Integer.MAX_VALUE){ // 该位置不能像前走
                dp[i] = 0;
                continue;
            }
            ArrayList<Integer> gcd = getList(i);
            for(int j=0;j<gcd.size();j++){
                int x = gcd.get(j);
                if(i+x<=m) // 记录向前走的长度，保留最小的步数
                    dp[i+x] = Math.min(dp[i+x], dp[i] + 1);
            }
        }
        if(dp[m]==0)
            return -1;
        else
            return dp[m];
        
    }
    // 求因数 时间复杂度 sqrt（n） 很强大
    public static ArrayList<Integer> getList(int k){
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i=2;i*i<=k;i++){
            if(k%i ==0){
                if(i!=1&&i!=k)
                    list.add(i);
                if((i*i)!=k&&(k/i)!=1&&(k/i)!=k)
                    list.add(k/i);
            }
        }
        return list;
    }
}
