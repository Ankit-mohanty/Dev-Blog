package com.moblog.devblog;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

//import jakarta.servlet.http.HttpServletRequest;

@Controller // IOC(Inversion of Container)= it is simple a container who create and maintain spring bean .
@RequiredArgsConstructor
public class BlogController {// Bean Factory= Interface who help IOC to create and miantain the spring bean.

//    @Autowired//( Setter Base Dependency Injection)
//    public void setBlogService(BlogService blogService) {
//        this.blogService = blogService;
//    }

    //@Autowired// we can define this 3 ways. Property based, setter based , and constructor base.
    //private  BlogService blogService;//{Property Based Injection} //Bean= The object create and maintain by spring IOC container is called bean.
    private final BlogService blogService;

    //dependency injection= If we want to create a one class object by the help of another class object we called dependecy.
    //To use the another class object to create current class object we called depnedecy injection.
    @GetMapping({"/", "blogs"})
    public String blogs(Model model) {
        var blogs = blogService.getBlogs();
        model.addAttribute("blogs", blogs);
        return "blogs";
    }

    @GetMapping("/blog")
    public String blog(@RequestParam int id, Model model) {// git add.
        var blog = blogService.getBlog(id);
        model.addAttribute("blog", blog);
        return "blog"; // git commit -m "controller desing add"
    }

    @GetMapping("/add-blog")
    public String addblog() {
        return "/add-blog";
    }

    @PostMapping("/add-blog") // if give same pathto method get and post both then by default it called get
    // request.
    // public String addblog(HttpServletRequest request, PrintWriter pw) {
    //public void addblog(@RequestParam String heading, @RequestParam String description, PrintWriter pw) {
    //public void addblog(@ModelAttribute Blog blog, PrintWriter pw) {// if we wnat to send single data we are using request param.If we sent multipledat we are using model atribute.
    public String addblog(@ModelAttribute Blog blog) {// here we redirect addblog to blogs..here we called one controler to another controller.
        // String heading= request.getParameter("heading");
        // String description= request.getParameter("description");
        //pw.println(blog);
        blogService.addBlog(blog);
        //pw.println(description);
        return "redirect:/blogs";

    }
}

