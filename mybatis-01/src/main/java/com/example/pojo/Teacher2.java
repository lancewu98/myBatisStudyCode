package com.example.pojo;

import lombok.Data;

import java.util.List;

@Data
public class Teacher2 {
    private int id;
    private String name;

    //一个老师对应多个学生
    private List<Student> students;
}
