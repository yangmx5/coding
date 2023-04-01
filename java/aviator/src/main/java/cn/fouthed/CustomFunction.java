//package cn.fouthed;
//
//import com.googlecode.aviator.annotation.Function;
//import com.googlecode.aviator.annotation.Import;
//import com.googlecode.aviator.runtime.function.AbstractFunction;
//import com.googlecode.aviator.runtime.function.FunctionUtils;
//import com.googlecode.aviator.runtime.type.AviatorDouble;
//import com.googlecode.aviator.runtime.type.AviatorObject;
//
//import java.util.Map;
//
///**
// * @author fouthed
// */
//
//@Import(ns = "test")
//public class CustomFunction extends AbstractFunction {
//
//    @Override
//    public AviatorObject call(Map<String, Object> env, AviatorObject arg1, AviatorObject arg2) {
//        Number left = FunctionUtils.getNumberValue(arg1, env);
//        Number right = FunctionUtils.getNumberValue(arg2, env);
//        return new AviatorDouble(left.doubleValue() + right.doubleValue());
//    }
//
//
//    @Override
//    public String getName() {
//        return "add";
//    }
//
//    public static void say() {
//        System.out.println("I'm static function");
//    }
//
//    @Function(rename = "call")
//    public void tell() {
//        System.out.println("I'm instance function");
//    }
//}
