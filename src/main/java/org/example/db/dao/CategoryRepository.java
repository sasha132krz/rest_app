package org.example.db.dao;

import org.example.db.model.Category;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface CategoryRepository extends CrudRepository<Category, Integer> {

    @Query("from Category where id=:id")
    public Category findByCategoryId(@Param("id") Integer id);
}