package com.powernode.pojo;

import com.powernode.app.Column;
import com.powernode.app.Table;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Company : BJPowernode
 * Date : 2020/9/15
 * Description :
 */
public class JdbcUtils {

    private static  Connection connection;
    private static PreparedStatement preparedStatement;
    private static ResultSet resultSet;

    static{

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public static void getConnection() throws SQLException {
        connection =  DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");
    }

    /**
     * 查询所有的数据
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> List<T> selectByList(Class<T> clazz) throws Exception {
        String sql = "select * from "+getTableName(clazz);
        preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        List<T> list = new ArrayList<T>();
        while (resultSet.next()){
            T t = clazz.newInstance();
            Field[] declaredFields = clazz.getDeclaredFields();
            for (Field field : declaredFields) {
                Column columnName = field.getAnnotation(Column.class);
                String column = columnName.value();
                Object value = resultSet.getObject(column);
                String fileName= field.getName();
                Class<?> type = field.getType();
                Method setter = getSetter(clazz, fileName, type);
                if (type.equals(Integer.class) || type.equals(int.class)){
                    /*BigDecimal bigDecimal = new BigDecimal(value);
                    value = bigDecimal.intValue();*/
                    value = (Integer)value;
                }
                if (type.equals(byte.class) || type.equals(Byte.class)){
                    BigDecimal bigDecimal = (BigDecimal)value;
                    value = bigDecimal.byteValue();
                }
                if (type.equals(long.class) || type.equals(Long.class)){
                    BigDecimal bigDecimal = (BigDecimal)value;
                    value = bigDecimal.longValue();
                }
                if (type.equals(short.class) || type.equals(Short.class)){
                    BigDecimal bigDecimal = (BigDecimal)value;
                    value = bigDecimal.shortValue();
                }
                if (type.equals(double.class) || type.equals(Double.class)){
                    BigDecimal bigDecimal = (BigDecimal)value;
                    value = bigDecimal.doubleValue();
                }
                if (type.equals(float.class) || type.equals(Float.class)){
                    BigDecimal bigDecimal = (BigDecimal)value;
                    value = bigDecimal.floatValue();
                }
                setter.invoke(t,value);

            }

            list.add(t);
        }

        return  list;

    }

    /**
     * 表名
     * @param cla
     * @param <T>
     * @return
     */
    public static <T>String getTableName(Class<T> cla){
        Table annotation = cla.getAnnotation(Table.class);
      return annotation.value();
    }

    public static Method getSetter(Class cla,String fileName,Class<?> type) throws NoSuchMethodException {
        //studentName       setStudentName()
        String methodName = "set"+fileName.substring(0,1).toUpperCase()+fileName.substring(1);
       return cla.getDeclaredMethod(methodName, type);
    }

    /**
     *  1.插入的数据并不一定是全部的，比如student新增一条记录时，只需要是sname字段
     *  2.删除   参数
     *  3.分页
     *  4.迷糊查询
     *  5.根据主键查询
     */

}
