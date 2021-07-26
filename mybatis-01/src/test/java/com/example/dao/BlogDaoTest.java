package com.example.dao;


import com.example.pojo.Blog;
import com.example.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class BlogDaoTest {

    @Test
    public void test(){
        //mybatis的一级缓存存在于sqlSession中，sqlSession关闭则缓存关闭，一级缓存默认开启
        //select操作的结果会被缓存
        //insert update delete操作会刷新缓存(即重新查库把数据写入缓存)
        //缓存会使用最近最少使用算法（LRU, Least Recently Used）算法来清除不需要的缓存
        //缓存不会定时进行刷新（也就是说，没有刷新间隔）
        //缓存会保存列表或对象（无论查询方法返回哪种）的 1024 个引用
        //缓存会被视为读/写缓存，这意味着获取到的对象并不是共享的，可以安全地被调用者修改，而不干扰其他调用者或线程所做的潜在修改
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
//        String id = IDUtils.getID();
//        String title = "asoul";
//        String author = "queen";
//        Date date = new Date();
//        int views = 64;
//        Blog blog = new Blog(id, title, author, date, views);
//        mapper.addBlog(blog);
//        sqlSession.commit();

//        List<Blog> blogs = mapper.getBlogs();
//        for (Blog b : blogs) {
//            System.out.println(b.toString());

//        }
//
//        Map<String, String> map = new HashMap<>();
////        map.put("title","asoul");
//        map.put("author","kira");
//        List<Blog> blogs = mapper.queryBlogIf(map);
////        map.put("views","91");

//
//        Map<String, String> map = new HashMap<>();
//        map.put("title","a_soul");
//        map.put("author","Eileen");
//        map.put("id","befe9b042b74427c898388f1cbecb177");
//        mapper.updateBlog(map);
//        sqlSession.commit();
//        List<Blog> blogs = mapper.queryBlogChoose(map);

        HashMap<String, Object> map = new HashMap<>();
        List<String> list = new LinkedList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        map.put("ids",list);
        List<Blog> blogs = mapper.queryBlogForeach(map);
        for (Blog blog : blogs) {
            System.out.println(blog.toString());
        }
        //手动清理缓存
        sqlSession.clearCache();
        sqlSession.close();
    }
}
