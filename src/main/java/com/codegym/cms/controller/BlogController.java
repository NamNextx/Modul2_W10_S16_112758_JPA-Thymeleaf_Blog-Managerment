package com.codegym.cms.controller;

import com.codegym.cms.model.Blog;
import com.codegym.cms.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class BlogController {
    @Autowired
    private IBlogService iBlogService;

    @GetMapping("/home")
    public ModelAndView home() {
        List<Blog> blogList=iBlogService.findAll();
        ModelAndView modelAndView=new ModelAndView("/repository/home");
        modelAndView.addObject("blogList",blogList);
        return modelAndView;
    }
    @GetMapping("/create-blog")

    public ModelAndView createBlogTemplate(){
        ModelAndView modelAndView=new ModelAndView("/repository/create_blog");
        modelAndView.addObject("blog",new Blog());
        return modelAndView;
    }
}
