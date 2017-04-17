package reflect.dynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by chen.mh on 2017/4/17.
 */
public class AOPHandler implements InvocationHandler {

    private Object target;

    public AOPHandler(Object target){
        this.target = target;
    }

    public void println(String str,Object... args){
        System.out.println(str);
        if(args == null){
            System.out.println("\t未传入任何值.....");
        } else{
            for(Object obj : args){
                System.out.println(obj);
            }
        }
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("\n\n=====>调用方法名：" + method.getName() );
        Class<?>[] variables = method.getParameterTypes();
        System.out.println("\n\n参数类型列表:\n");
        for (Class<?> typevariables : variables) {
            System.out.println("\t\t\t" + typevariables.getName());
        }
        System.out.println("\n\n传入参数值为:\n");
        if(args != null && args.length > 0){
            for (Object arg: args) {
                System.out.println("\t\t\t" + arg);
            }
        }
        Object result = method.invoke(target, args);
        println("返回的参数为：" ,result);
        println("返回值类型为：",method.getReturnType());
        return result;
    }
}
