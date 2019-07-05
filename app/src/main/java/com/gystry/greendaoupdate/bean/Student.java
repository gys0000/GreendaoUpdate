package com.gystry.greendaoupdate.bean;

import android.util.Log;
import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Unique;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class Student {
    @Id(autoincrement = true)
    Long id;
    @Unique
    Long studentNo;
    int age;
    String name;
    String sex;
    String grade;
    String height;

    @Generated(hash = 376301238)
    public Student(Long id, Long studentNo, int age, String name, String sex,
            String grade, String height) {
        this.id = id;
        this.studentNo = studentNo;
        this.age = age;
        this.name = name;
        this.sex = sex;
        this.grade = grade;
        this.height = height;
    }

    @Generated(hash = 1556870573)
    public Student() {
    }


    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getStudentNo() {
        return studentNo;
    }

    public void setStudentNo(Long studentNo) {
        this.studentNo = studentNo;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getHeight() {
        return this.height;
    }

    public void setHeight(String height) {
        this.height = height;
    }
}
