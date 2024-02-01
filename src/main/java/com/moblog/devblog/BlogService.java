package com.moblog.devblog;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service// we can write @Componet, @Repository..
@RequiredArgsConstructor
public class BlogService {
    private final ArrayList<Blog> blogs;



    public void addBlog(Blog blog) {
        blogs.add(blog);
    }

    public List<Blog> getBlogs() {
        return blogs;
    }

    public Blog getBlog(int index) {
        return blogs.get(index);
    }
}
