package com.codegym.cms.service.impl.impl;

import com.codegym.cms.model.Blog;
import com.codegym.cms.repository.IBlogRepository;
import com.codegym.cms.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
public class BlogServiceImpl implements IBlogService {
    @Autowired
    private IBlogRepository blogRepository;

    @Override
    public Iterable<Blog> findAll() {
        return blogRepository.findAll();
    }

    @Override
    public Blog findById(Long id) {
        return blogRepository.findOne(id);
    }

    @Override
    public void save(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public void remove(Long id) {
        blogRepository.delete(id);
    }
}
