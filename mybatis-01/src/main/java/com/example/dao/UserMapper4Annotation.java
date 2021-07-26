package com.example.dao;

import com.example.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

public interface UserMapper4Annotation {

    @Select("select * from user")
    List<User> getUserListByAnnotation();

    // 方法存在多个参数时，所有参数前面必须加上@Param(。。。)注解，这里仅用来展示sql语句内#后的内容随@param里的字符串
    @Select("select * from user where id = #{id}")
    User getUserById(@Param("id")int id2);

    @Insert("insert into user (id,name,pwd) values (#{id},#{name},#{pwd})")
    int addUser(User user);

    //小心不要把set后面的逗号写成and
    @Update("update user set name = #{name},pwd = #{pwd} where id = #{id}")
    int update(User user);

    @Delete("delete from user where id = #{id}")
    int delUser(int id);
}
