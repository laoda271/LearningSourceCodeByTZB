package reflect.dynamic;

/**
 * Created by chen.mh on 2017/4/18.
 */
public class AOPTestMain {
    public static void main(String[] args) throws IllegalAccessException, ClassNotFoundException, InstantiationException {
        HelloInterface hello = BeanFactory.getBean("reflect.dynamic.HelloImpl", HelloInterface.class);
        hello.setInfo("xieyuoo","xiaopang");
        hello.getInfos1();
        //hello.getInfos2();
        //hello.display();
    }
}
