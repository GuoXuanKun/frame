package com.gmgx.dao;


import com.gmgx.entity.Blog;
import com.gmgx.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IBlogDao {

    public List<Blog> queryAllBlog();

    public List<Blog> queryAllBlog2();

    public Blog queryBlogById(Integer blogId);

    public Blog queryBlogById2(Integer blogId);

    public List<Blog>  queryBlogById3(@Param("id1")Integer id1, @Param("id2")Integer id2);

    public List<Blog>  queryBlogById4(@Param("id1")Integer id1,@Param("id2")Integer id2);


    public boolean modifyBlog(Blog blog);

    public boolean modifyUser(User user);


    public List<Blog> queryBlogAndUserByBlogId(Integer blogId);






}
