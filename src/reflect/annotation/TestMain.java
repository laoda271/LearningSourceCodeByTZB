package reflect.annotation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by chen.mh on 2017/4/22.
 */
public class TestMain {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        List<HashMap<String, String>> list = Arrays.asList(
                new HashMap<String, String>() {
                    {
                        put("name", "xieyuooo");
                        put("title", "小胖");
                    }
                },
                new HashMap<String, String>() {
                    {
                        put("name", "ffff");
                        put("title", "标题2");
                    }
                }
        );

        ArrayList<UserDO> users = new ArrayList<UserDO>(list.size());
        for (HashMap<String,String> row : list) {
                users.add(ConversionService.convertMapToBean(row,UserDO.class));
        }
        System.out.println();
        for (UserDO userDO : users) {
            System.out.println(userDO.getUserName() + " , " + userDO.getUserTitle());
        }
        //这里大家可以将users的列表进行输出
    }
}
