package reflect.dynamic;

/**
 * Created by chen.mh on 2017/4/17.
 */
public class HelloImpl implements HelloInterface,HelloInterface2 {

    private volatile String infos1;

    private volatile String infos2;

    @Override
    public String getInfos1() {
        return infos1;
    }

    public void setInfos1(String infos1) {
        this.infos1 = infos1;
    }

    @Override
    public String getInfos2() {
        return infos2;
    }

    public void setInfos2(String infos2) {
        this.infos2 = infos2;
    }

    @Override
    public void setInfo(String infos1, String infos2) {
        this.infos1 = infos1;
        this.infos2 = infos2;
        this.display();
    }

    @Override
    public void display() {
        System.out.println("\t\t" + infos1 + "\t" + infos2);
    }
}
