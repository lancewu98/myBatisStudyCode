package com.example.dao;

import com.example.pojo.Student;
import com.example.pojo.Teacher;

import java.util.List;

public interface StudentMapper {

    //按照子查询方式进行多对一映射
    List<Student> getStudent();
    Teacher getTeacher(int sid);

    //针对联表查询方式进行多对一映射
    List<Student> getStudent2();
}
