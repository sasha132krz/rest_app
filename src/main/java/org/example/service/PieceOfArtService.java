package org.example.service;

import org.example.db.model.Category;
import org.example.db.model.PieceOfArt;
import org.example.db.model.Owner;

public interface PieceOfArtService {
    Iterable<PieceOfArt> listAll();
    void delete(Integer id);
    PieceOfArt add(String name, Category category, Owner owner, Integer year, Integer price);
}