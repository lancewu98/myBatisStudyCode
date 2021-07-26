package com.example.dao;

import com.example.pojo.Student;
import com.example.pojo.Teacher;
import com.example.utils.MybatisUtils;
import jdk.management.resource.internal.inst.SocketOutputStreamRMHooks;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class StudentDaoTest {

    @Test
    public void test(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> student = mapper.getStudent();
        for (Student s : student) {
            System.out.println(s.toString());
        }
        List<Student> student2 = mapper.getStudent2();
        for (Student s : student2) {
            System.out.println(s.toString());
        }
    }
}
