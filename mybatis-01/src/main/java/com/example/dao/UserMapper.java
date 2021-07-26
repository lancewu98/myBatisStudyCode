package com.example.dao;

import com.example.pojo.User;
import com.example.pojo.User2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface UserMapper {
    List<User> getUserList();

    User getUserById(int id);

    int addUser(User user);

    int updateUser(User user);

    int deleteUser(int id);

    int addUserByMap(HashMap<String,Object> map);

    List<User> getUserLike(String value);

    User2 getUser2ById(int id);

    //分页
    List<User> getUserByLimit(Map<String,Integer> map);
}
