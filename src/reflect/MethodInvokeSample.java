package reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by chen.mh on 2017/4/11.
 */
public class MethodInvokeSample {
    public static void main(String[] args){
        try {
            Method method = MethodInvokeSample.class.getDeclaredMethod("test",String.class,int.class);
            String result = (String) method.invoke(null,"fuck",2);
            System.out.print(result);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    public static String test(String a,int b){
        return "传入参数1:" + a + ",传入参数2:" + b;
    }
}
