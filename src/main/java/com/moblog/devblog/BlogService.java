package com.moblog.devblog;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service// we can write @Componet, @Repository..
@RequiredArgsConstructor
public class BlogService {
    // private final ArrayList<Blog> blogs;
    private final JdbcTemplate jdbcTemplate;


    public void addBlog(Blog blog) {
        String sql = "insert into moblog (heading, description) values(?,?)";
        jdbcTemplate.update(sql, blog.getHeading(), blog.getDescription());
    }

    public List<Blog> getBlogs() {
        String sql = "Select * from moblog";
        RowMapper<Blog> rwm = (resultSet, rowNum) -> new Blog(
                resultSet.getInt("id"),
                resultSet.getString("heading"),
                resultSet.getNString("description"));
        return jdbcTemplate.query(sql, rwm);
    }

    public Blog getBlog(int id) {
        String sql = "select * from moblog where id= ?";
        RowMapper<Blog> rwm = (resultSet, rowNum) -> new Blog(resultSet.getInt("id"),
                resultSet.getString("heading"),
                resultSet.getNString("description"));
        return jdbcTemplate.queryForObject(sql, rwm, id);
    }
    public void deleteBlog(int id) {
        String sql = "delete from moblog where id = ?";
        jdbcTemplate.update(sql, id);
    }

}
