package com.codegym.cms.model;

import javax.persistence.*;

@Entity
@Table(name = "blog")
public class Blog {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)

    private Long id;
    private String author;
    private String description;
    private String contain;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    public Blog() {
    }

    public Blog(String author, String description, String contain, Category category) {
        this.author = author;
        this.description = description;
        this.contain = contain;
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContain() {
        return contain;
    }

    public void setContain(String contain) {
        this.contain = contain;
    }

    public Category getCategory() {
        Category empty = new Category();
        return (this.category != null) ? this.category : empty;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
