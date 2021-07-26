package com.example.dao;

import com.example.pojo.User;
import com.example.pojo.User2;
import com.example.utils.MybatisUtils;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserDaoTest {

    @Test
    public void test(){
        //获取sqlSession
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        //方式一： getMapper
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

//        System.out.println();
//        User userById = mapper.getUserById(1);
//        System.out.println(userById.toString());

        //增删改需要提交事务
//        User kelly = new User(4, "Kelly", "23451");
//        mapper.addUser(kelly);
//        sqlSession.commit();
//
//        mapper.updateUser(new User(3,"Eileen","68875"));
//        sqlSession.commit();

//        mapper.deleteUser(4);
//        sqlSession.commit();

//        HashMap<String, Object> map = new HashMap<>(8);
//        map.put("userId",5);
//        map.put("userName","Bella");
//        map.put("passWord","31945");
//        mapper.addUserByMap(map);
//        sqlSession.commit();

//        List<User> userList = mapper.getUserList();
//        for (User user : userList) {
//            System.out.println(user.toString());
//        }

//        List<User> userLike = mapper.getUserLike("%l%");
//        for (User user : userLike) {
//            System.out.println(user.toString());
//        }
//
//        User2 user2ById = mapper.getUser2ById(1);
//        System.out.println(user2ById.toString());

//        Map<String, Integer> map = new HashMap<>(8);
//        map.put("startIndex",1);
//        map.put("pageSize",2);
//        List<User> userByLimit = mapper.getUserByLimit(map);
//        for (User user : userByLimit) {
//            System.out.println(user.toString());
//        }

////      用RowBounds进行分页（纯代码式,基于java代码层面实现分页）
//        RowBounds rowBounds = new RowBounds(1, 2);
//        List<User> users = sqlSession.selectList("com.example.dao.UserMapper.getUserList", null, rowBounds);
//        for (User user : users) {
//            System.out.println(user.toString());
//        }

        UserMapper4Annotation mapper4Annotation = sqlSession.getMapper(UserMapper4Annotation.class);
//        List<User> list = mapper4Annotation.getUserListByAnnotation();
//        for (User user : list) {
//            System.out.println(user.toString());
//        }
//        User userById = mapper4Annotation.getUserById(1);
//        System.out.println(userById.toString());

//        mapper4Annotation.addUser(new User(6, "Nanami", "65463"));
//        User userById = mapper4Annotation.getUserById(6);
//        mapper4Annotation.update(new User(6, "Mart", "98413"));
//        userById = mapper4Annotation.getUserById(6);
//        System.out.println(userById.toString());
//        mapper4Annotation.delUser(6);
//        sqlSession.commit();
        List<User> list = mapper4Annotation.getUserListByAnnotation();
        for (User user : list) {
            System.out.println(user.toString());
        }

        //关闭资源
        sqlSession.close();
    }
}
