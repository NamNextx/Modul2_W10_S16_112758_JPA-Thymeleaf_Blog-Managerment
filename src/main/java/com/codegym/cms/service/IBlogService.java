package com.codegym.cms.service;

import com.codegym.cms.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface IBlogService {
    Iterable<Blog> findAll();
    Blog findById(Long id);
    void save(Blog blog);
    void remove(Long id);

    Page<Blog> findAll(Pageable pageable);
    Page<Blog> findAllByAuthorContaining(String name,Pageable pageable);
}
