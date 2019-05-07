package com.codegym.cms.repository;

import com.codegym.cms.model.Blog;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IBlogRepository  extends PagingAndSortingRepository<Blog,Long> {
}
