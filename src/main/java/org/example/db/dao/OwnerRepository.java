package org.example.db.dao;

import org.example.db.model.Owner;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface OwnerRepository extends CrudRepository<Owner, Integer> {

    @Query("from Owner where id=:id")
    public Owner findByOwnerId(@Param("id") Integer id);
}
