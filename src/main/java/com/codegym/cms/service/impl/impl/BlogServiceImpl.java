package com.codegym.cms.service.impl.impl;

import com.codegym.cms.model.Blog;
import com.codegym.cms.repository.impl.BlogRepositoryImpl;
import com.codegym.cms.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import sun.rmi.runtime.Log;

import java.util.List;

public class BlogServiceImpl implements IBlogService {
    @Autowired
    private BlogRepositoryImpl blogRepository;
    @Override
    public List<Blog> findAll() {
        return blogRepository.findAll();
    }

    @Override
    public Blog findById(Long id) {
        return blogRepository.findByID(id);
    }

    @Override
    public void save(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public void remove(Long id) {
        blogRepository.remove(id);
    }
}
