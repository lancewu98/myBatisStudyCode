package com.example.dao;

import com.example.pojo.Teacher;
import com.example.pojo.Teacher2;
import com.example.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class TeacherDaoTest {

    @Test
    public void test(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
//        Teacher teacher = mapper.getTeacher(1);
//        System.out.println(teacher.toString());

//        Teacher2 teacher2 = mapper.getTeacher2(1);
//        System.out.println(teacher2.toString());

        Teacher2 teacher2_2 = mapper.getTeacher2_2(1);
        System.out.println(teacher2_2.toString());
        sqlSession.close();
    }
}
