package cn.fouthed;

import com.googlecode.aviator.AviatorEvaluator;
import com.googlecode.aviator.Options;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * Hello world!
 *
 * @author fouthed
 */
public class App {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException {
        System.out.println("Hello World!");

        //case 1
        AviatorEvaluator.setOption(Options.ALWAYS_PARSE_INTEGRAL_NUMBER_INTO_DECIMAL, true);
        Double ret = (Double) AviatorEvaluator.execute("1+2+3.0");
        System.out.println(ret);

        //case 2
        BigDecimal ret2 = (BigDecimal) AviatorEvaluator.execute("print('hello aviator\n'); 1+1 ; 2+3");
        System.out.println(ret2);

        //case 3
        String yourName = "fouthed";
        Map<String, Object> env = new HashMap<String, Object>();
        env.put("name", yourName);
        String ret3 = (String) AviatorEvaluator.execute("'hello ' + name", env);
        System.out.println(ret3);

        //case 4
        // with any name is ok
        String ret4 = (String) AviatorEvaluator.exec("'t hello ' + anyname", env);
        System.out.println(ret4);

        //case 5
        Long ret5 = (Long) AviatorEvaluator.execute("string.length('hello test the func')");
        System.out.println(ret5);

        //case 6
        Long ret6 = (Long) AviatorEvaluator.exec("(lambda (x, y) -> x + y end)(x, y)", 1L, 2L);
        System.out.println(ret6);

        //case 7
        AviatorEvaluator.addFunction(new CustomFunction());
        Double ret7 = (Double) AviatorEvaluator.execute("add(1,2)");
        System.out.println(ret7);

        //case 8
        AviatorEvaluator.importFunctions(CustomFunction.class);
        AviatorEvaluator.execute("test.say()");

        //case 9
        env.put("instance", new CustomFunction());
        AviatorEvaluator.setOption(Options.TRACE_EVAL,true);
        AviatorEvaluator.execute("test.call(instance)", env);

    }
}
