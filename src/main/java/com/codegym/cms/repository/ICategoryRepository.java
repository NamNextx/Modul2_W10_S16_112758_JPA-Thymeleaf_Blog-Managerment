package com.codegym.cms.repository;

import com.codegym.cms.model.Category;
import org.springframework.data.repository.PagingAndSortingRepository;
public interface ICategoryRepository extends PagingAndSortingRepository<Category,Long> {
}
