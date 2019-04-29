package com.codegym.cms.service;

import com.codegym.cms.model.Blog;
import sun.rmi.runtime.Log;

import java.util.List;

public interface IBlogService {
    List<Blog> findAll();
    Blog findById(Long id);
    void save(Blog blog);
    void remove(Long id);
}
