package com.example.dao;

import com.example.pojo.Blog;

import java.util.List;
import java.util.Map;

public interface BlogMapper {

    void addBlog(Blog blog);

    List<Blog> getBlogs();

    List<Blog> queryBlogIf(Map map);

    List<Blog> queryBlogChoose(Map map);

    int updateBlog(Map map);

    List<Blog> queryBlogForeach(Map map);
}
