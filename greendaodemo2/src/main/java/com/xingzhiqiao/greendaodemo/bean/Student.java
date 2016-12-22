package com.xingzhiqiao.greendaodemo.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * Created by xingzhiqiao on 2016/12/22.
 */

@Entity
public class Student {

    @Id
    private Long id;

    private String name;

    private String age;

    @Generated(hash = 563965806)
    public Student(Long id, String name, String age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    @Generated(hash = 1556870573)
    public Student() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return this.age;
    }

    public void setAge(String age) {
        this.age = age;
    }

}
