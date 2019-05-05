package com.codegym.cms.controller;

import com.codegym.cms.model.Blog;
import com.codegym.cms.repository.IBlogRepository;
import com.codegym.cms.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

    @PostMapping("/create-blog")
    public String createBlog(Blog blog, RedirectAttributes redirect){
        iBlogService.save(blog);
        redirect.addFlashAttribute("done","created new a blog");
        return ("redirect:/home");
    }

    @GetMapping("/update_blog/{id}")
    public ModelAndView updateBlog(@ModelAttribute("id") Long id){
        Blog blog= iBlogService.findById(id);
        ModelAndView modelAndView;
        if (blog==null){
            modelAndView=new ModelAndView("/repository/error-404");
            return modelAndView;
        }else {
            modelAndView=new ModelAndView("/repository/update_form");
            modelAndView.addObject("blog",blog);
            return modelAndView;
        }
    }
    @PostMapping("/update_blog")
    public String updateBlog(@ModelAttribute("abc") Blog blog,RedirectAttributes redirect){
        iBlogService.save(blog);
        return ("redirect:/home");
    }
}
