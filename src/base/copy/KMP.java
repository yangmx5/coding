package base.copy;

public class KMP {


    public static void main(String [] args){

        String s1 = "1234621";
        String s2 = "462";
        System.out.println(KMP(s1,s2));

    }


    public static int KMP(String s, String p){
        char [] arr_s = s.toCharArray();
        char [] arr_p = p.toCharArray();
        int i = 0 , j =0;

        int [] next = getNext(arr_s);

        for(i= 0 , j =0  ; i < arr_s.length && j < arr_p.length ;){
            if(arr_s[i] == arr_p[j]){
                i++;
                j++;
            }else if(next[j] == -1){
                i++;
            }else{
                j = next[j];
            }
        }
        return  j == arr_p.length?i-j:-1;
    }

    private static int [] getNext(char[] arr){
        int [] next = new int[arr.length];
        next[0] = -1;
        next[1] = 1;
        int pos = 2;
        int cn = 0;
        while(pos < arr.length){
            if(arr[pos-1] == arr[cn]){
                next[pos++] = ++cn;
            }else if(cn > 0){
                cn = next[cn];
            }else{
                next[pos++] = 0;
            }
        }
        return next;

    }
}
