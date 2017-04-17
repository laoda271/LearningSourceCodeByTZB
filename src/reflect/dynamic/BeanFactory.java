package reflect.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * Created by chen.mh on 2017/4/18.
 */
public class BeanFactory {

    public static Object getBean(String className) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Object obj = Class.forName(className).newInstance();
        InvocationHandler aopHandler = new AOPHandler(obj); //定义过滤器
        Object o = Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), aopHandler);
        return o;
    }

    public static <T> T getBean(String className,Class<T> clazz) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        return (T) getBean(className);
    }
}
