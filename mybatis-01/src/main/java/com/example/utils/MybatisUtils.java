package com.example.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

//sqlSessionFactory -> sqlSession
public class MybatisUtils {

    //可以理解为数据库连接池，一旦被创建后就应该在应用的运行期间一直存在，没有理由丢弃或重新创建它
    //最佳作用域：应用作用域   使用单例或静态单例
    private static SqlSessionFactory sqlSessionFactory;

    static {
        try {
            //使用mybatis第一步：获取sqlSessionFactory对象
            String resource = "mybatis-config.xml";
            InputStream  inputStream = Resources.getResourceAsStream(resource);
            //SqlSessionFactoryBuilder:一旦创建了sqlSessionFactory，就不需要它了（做局部变量就行）
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 既然有了 SqlSessionFactory，顾名思义，我们可以从中获得 SqlSession 的实例。
     * SqlSession 提供了在数据库执行 SQL 命令所需的所有方法。
     * 可以通过 SqlSession 实例来直接执行已映射的 SQL 语句。
     */
    //SqlSession可以理解为连接到连接池的一个请求，实例不是线程安全，故不可共享，用完之后需要赶紧关闭
    //最佳作用域：请求或方法作用域
    //openSession(true)的话自动提交事务
    public static SqlSession getSqlSession(){
        return sqlSessionFactory.openSession();
    }


}
