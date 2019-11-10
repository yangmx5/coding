package test.baseclass;

import java.lang.reflect.Field;

public class IntegerClass {

    public static void main(String [] args){
        Integer a = 1;
        Integer b = 2;


        try {
            swapInReflect(a,b);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(a);
        System.out.println(b);
    }

    private static void swap(Integer a, Integer b){
        Integer temp = a ;
        a = b;
        System.out.println(a);
        b = temp;
        System.out.println(b);
    }

    public static void swapInReflect(Integer a,Integer b) throws Exception
    {
        Field field = Integer.class.getDeclaredField("value");
        field.setAccessible(true);
        field.setInt(a, a ^ b);
        field.setInt(b, a ^ b);
        field.setInt(a, a ^ b);
    }


}
