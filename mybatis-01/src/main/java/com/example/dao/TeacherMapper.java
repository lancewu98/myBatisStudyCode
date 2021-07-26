package com.example.dao;

import com.example.pojo.Student2;
import com.example.pojo.Teacher;
import com.example.pojo.Teacher2;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface TeacherMapper {

    @Select("select * from teacher where id = #{tid}")
    Teacher getTeacher(@Param("tid") int id);

    //针对联表查询方式进行一对多映射(比较推荐使用)
    Teacher2 getTeacher2(@Param("tid") int id);

    //按照子查询方式进行一对多映射
    Teacher2 getTeacher2_2(@Param("tid") int id);
    Student2 getStudent2(int tid);

}
