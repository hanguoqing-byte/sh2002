package com.powernode.app;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

/**
 * Company : BJPowernode
 * Date : 2020/9/15
 * Description :
 */
public class Application2 {

    public static void main(String[] args) {

        try {
            Class clazz = Class.forName("com.powernode.app.User");
            Field[] declaredFields = clazz.getDeclaredFields();
            for (Field declaredField : declaredFields) {
                Column column = declaredField.getAnnotation(Column.class);
                System.out.println( column.value()+"   "+column.isPk());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    /**
     * 获取当前字节码对象对应表名
     * @return
     */
    public static String getTableName(Class cla){
        Table table = (Table) cla.getAnnotation(Table.class);
        String value = table.value();
        return value;
    }
}
