package org.example.service;

import org.example.db.model.Owner;

public interface OwnerService {
    Iterable<Owner> listAll();
    void delete(Integer id);
    Owner add(String name);
    Owner findByOwnerId(Integer id);
}