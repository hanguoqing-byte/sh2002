package com.powernode.pojo;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * Company : BJPowernode
 * Date : 2020/9/15
 * Description :
 */
public class AppTest {

    public static void main(String[] args) {

        try {
            JdbcUtils.getConnection();
            List<Student> students = JdbcUtils.selectByList(Student.class);
            System.out.println(students);


        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
