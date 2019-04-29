package com.codegym.cms.controller;

import com.codegym.cms.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BlogController {
    @Autowired
    public IBlogService iBlogService;
    @GetMapping("/home")
    public String home() {
        return "/repository/home";
    }
}
