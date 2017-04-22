package reflect.annotation;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.*;

/**
 * Created by chen.mh on 2017/4/22.
 */
public class ConversionService {
    public static <T> T convertMapToBean(Map<String, String> row, Class<T> clazz) throws IllegalAccessException, InstantiationException {
        Object object = clazz.newInstance();
        List<Field> list = findFields(clazz);
        for (Field field : list) {
            if (!Modifier.isStatic(field.getModifiers()) && !Modifier.isFinal(field.getModifiers())) {
                if (!field.isAccessible()) field.setAccessible(true);
                Column columnAnnotation = field.getAnnotation(Column.class);
                if (columnAnnotation != null) {
                    String value = row.get(columnAnnotation.name()); //通过annotation注解的名称来获取对应的值
                    Class<?> fieldType = field.getType();
                    if (fieldType == String.class) {
                        field.set(object, value);
                    } else if (fieldType == Integer.class) {
                        field.set(object, getInteger(value));
                    } else if (fieldType == int.class) {
                        field.setInt(object, getInt(value));
                    } else if (fieldType == Long.class) {
                        field.set(object, getLongWrapper(value));
                    } else if (fieldType == long.class) {
                        field.setLong(object, getLong(value));
                    }
                    /**
                     *  继续的数据类型大家可以自己补充
                     */
                }
            } else {
                /**，没有annotation的代码交给大家去补充**/
            }
        }
        return (T) object;
    }

    private static List<Field> findFields(Class<?> clazz) {
        ArrayList<Field> fieldList = new ArrayList<Field>();
        Set<String> fieldNames = new HashSet<String>();
        Class<?> clazzTemp = clazz;
        while (clazzTemp != Object.class) {
            Field[] fields = clazzTemp.getDeclaredFields();
            for (Field field : fields) {
                if (!fieldNames.contains(field.getName())) { //同名属性子类覆盖
                    fieldList.add(field);
                    fieldNames.add(field.getName());
                }
            }
            clazzTemp = clazzTemp.getSuperclass();
        }
        return fieldList;
    }

    public static Integer getInteger(String value) {
        if (isEmpty(value)) {
            return null;
        }
        return Integer.valueOf(value);
    }

    private static boolean isEmpty(String value) {
        return value == null || value == "";
    }

    public static int getInt(String value) {
        if (isEmpty(value)) return 0;
        return Integer.valueOf(value);
    }

    public static Long getLongWrapper(String value) {
        if (isEmpty(value)) return null;
        return Long.valueOf(value);
    }

    public static long getLong(String value) {
        if (isEmpty(value))
            return 0;
        return Long.valueOf(value);
    }
}
