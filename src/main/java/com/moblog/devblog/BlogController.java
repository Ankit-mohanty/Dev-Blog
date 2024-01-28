package com.moblog.devblog;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BlogController {
    @GetMapping({ "/", "blogs" })
    public String blogs() {
        return "blogs";
    }

    @GetMapping("/blog")
    public String blog() {// git add.
        return "blog";// git commit -m "controller desing add"
    }

    @GetMapping("/add-blog")
    public String addblog() {
        return "add-blog";
    }
}
