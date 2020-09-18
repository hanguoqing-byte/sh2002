package com.powernode.pojo;

import com.powernode.app.Column;
import com.powernode.app.Table;

/**
 * Company : BJPowernode
 * Date : 2020/9/15
 * Description :
 */
@Table("student")
public class Student {
    @Column(value = "id",isPk = true)
    private int id;
    @Column("sname")
    private String studentName;
    @Column(value = "saddress",isInsert = false)
    private String studentAddress;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentAddress() {
        return studentAddress;
    }

    public void setStudentAddress(String studentAddress) {
        this.studentAddress = studentAddress;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", studentName='" + studentName + '\'' +
                ", studentAddress='" + studentAddress + '\'' +
                '}';
    }
}
