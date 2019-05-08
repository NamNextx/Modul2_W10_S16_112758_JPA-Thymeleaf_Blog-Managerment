package com.codegym.cms.controller;

import com.codegym.cms.model.Blog;
import com.codegym.cms.model.Category;
import com.codegym.cms.service.IBlogService;
import com.codegym.cms.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
public class BlogController {
    @Autowired
    private IBlogService iBlogService;

    @Autowired
    private ICategoryService iCategoryService;

    @ModelAttribute("categorys")
    public Iterable<Category> getCategory(){
        return iCategoryService.findAll();
    }

    @GetMapping("/home")
    public ModelAndView listBlog(@RequestParam("s") Optional<String> s,@PageableDefault(4) Pageable pageable) {
        Page<Blog> blogList;
        if(s.isPresent()){
            blogList = iBlogService.findAllByAuthorContaining(s.get(),pageable);
        }else {
            blogList = iBlogService.findAll(pageable);
        }
        ModelAndView modelAndView=new ModelAndView("/blogs/home");
        modelAndView.addObject("blogList",blogList);
        return modelAndView;
    }

    @GetMapping("/create-blog")
    public ModelAndView createBlogTemplate(){
        ModelAndView modelAndView=new ModelAndView("/blogs/create_blog");
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
            modelAndView=new ModelAndView("/blogs/error-404");
            return modelAndView;
        }else {
            modelAndView=new ModelAndView("/blogs/update_form");
            modelAndView.addObject("blog",blog);
            return modelAndView;
        }
    }
    @PostMapping("/update_blog")
    public String updateBlog(Blog blog,RedirectAttributes redirect){
        iBlogService.save(blog);
        return ("redirect:/home");
    }
}
