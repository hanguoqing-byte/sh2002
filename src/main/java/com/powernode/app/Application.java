package com.powernode.app;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Company : BJPowernode
 * Date : 2020/9/15
 * Description :
 */
public class Application {

    public static void main(String[] args) {


        /**
         * 三种方式
         * Class.forName()
         * 类.class
         * 对象.class
         *        //类.class
         *             Class userClass = User.class;
         *
         *             //对象.class
         *             Class aClass = new User().getClass();
         */

        try {
            //参数是类的完整路径=包名+类名
            Class clazz = Class.forName("com.powernode.app.User");
            //获取所有的构造函数
            /*Constructor[] constructors = clazz.getConstructors();
            for (Constructor constructor : constructors) {
                System.out.println(constructor.getName());
            }*/
//---------------------------------------被public修饰的构造函数  getConstructor---------------------------------------------
            //new User();
            //无参构造函数的对象
            /*Constructor constructor = clazz.getConstructor(null);
            User user = (User) constructor.newInstance(null);
            System.out.println(user);*/


            //有参构造函数创建对象   new User("admin","admin")
          /* Constructor constructor =  clazz.getConstructor(String.class, String.class);
           User user = (User) constructor.newInstance("admin", "admin");
           System.out.println(user);*/

//-------------------------------------获取私有和公共的构造函数--------------------------------------------------------
           /* Constructor declaredConstructor = clazz.getDeclaredConstructor(null);
            //暴力反射
            declaredConstructor.setAccessible(true);
            User user = (User) declaredConstructor.newInstance(null);
            System.out.println(user);*/

           /* Constructor[] declaredConstructors = clazz.getDeclaredConstructors();
            for (Constructor declaredConstructor : declaredConstructors) {
                System.out.println(declaredConstructor.getName());
            }*/


           /* List<User> list = JDBCUtils.findByList(User.class);
            JDBCUtils.dele(User.class,1);
            JDBCUtils.update(new User("xx","xx"),1)
           JDBCUtils.insert(new User(xx,xxx,xxx,xx)*/

            /*Constructor constructor = clazz.getConstructor(null);
            User user = (User) constructor.newInstance(null);
*/
           //获取方法对象   对象.方法()
          /*  Method method = clazz.getDeclaredMethod("setUsername", String.class);
            method.invoke(user,"哈哈哈");//  对象.方法()*/

            //获取公共属性
            /*clazz.getFields()
            clazz.getField()*/

           /* Field username = clazz.getDeclaredField("username");
            System.out.println(username.get(user));*/

            /*Field[] declaredFields = clazz.getDeclaredFields();
            for (Field declaredField : declaredFields) {
                System.out.println(declaredField.getName());
                System.out.println(declaredField.getType());
            }*/

        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
