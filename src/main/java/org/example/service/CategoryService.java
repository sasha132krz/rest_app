package org.example.service;

import org.example.db.model.Category;

public interface CategoryService {
    Iterable<Category> listAll();
    void delete(Integer id);
    Category add(String name);
    Category findByCategoryId(Integer id);
}
