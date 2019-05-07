package com.codegym.cms.controller;

import com.codegym.cms.model.Category;
import com.codegym.cms.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class CategoryController {
    @Autowired
    private ICategoryService categoryService;

    @GetMapping("/list-category")
    public ModelAndView listCategory() {
        ModelAndView modelAndView = new ModelAndView("/category/list");
        Iterable<Category> categories = categoryService.findAll();
        modelAndView.addObject("categorys", categories);
        return modelAndView;
    }

    @GetMapping("/create-category")
    public ModelAndView createCategory() {
        ModelAndView modelAndView = new ModelAndView("/category/create");
        modelAndView.addObject("category", new Category());
        return modelAndView;
    }

    @PostMapping("/create-category")
    public String createCategory(Category category, RedirectAttributes redirect) {
        categoryService.save(category);
        redirect.addFlashAttribute("mes", "well done");
        return "redirect:/list-category";
    }

    @GetMapping("/edit-category/{id}")
    public ModelAndView editCategory(@PathVariable Long id) {
        Category category = categoryService.findById(id);
        ModelAndView modelAndView;
        if (category == null) {
             modelAndView = new ModelAndView("error");
             return modelAndView;
        } else  {
             modelAndView = new ModelAndView("/category/edit");
             modelAndView.addObject("category",category);
             return modelAndView;
        }
    }
    @PostMapping("/update-category")
    public String editCategory(@ModelAttribute("category") Category category,RedirectAttributes redirect){
        categoryService.save(category);
        redirect.addFlashAttribute("mes", "done");
        return "redirect: /list-category";
    }


}
