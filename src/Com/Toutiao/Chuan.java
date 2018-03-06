package Com.Toutiao;

import java.util.Scanner;

public class Chuan {


    public static void main(String [] args){

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int c = sc.nextInt();

        int [] flag = new int[c];
        for(int i = 0 ; i < flag.length ; i++){
            flag[i] = 0;
        }
        int count = 0;
        for(int i = 0 ; i < n ; i++){
            int k = sc.nextInt();
            for(int j = 0 ;  j< k ; j++){
                int t = sc.nextInt();
                flag[t-1] += 1;
                if(flag[t-1] >= m){
                    flag[t-1] %= m;
                    count++;
                }
            }
        }
        System.out.println(count);
    }



}
