package test.Reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectTest {

    public static void main(String[] args) {

        try {

            Method method = Tool.class.getMethod("method1", String.class);
            Tool tool = new Tool();
            method.invoke(tool,"test1");

            method = Tool.class.getMethod("method2", String.class);
            method.invoke(tool,"test2");

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }

}


class Tool {
    public void method1(String str) {
        System.out.println("Method1: " + str);
    }


    public void method2(String str) {
        System.out.println("Method2: " + str);
    }

}
