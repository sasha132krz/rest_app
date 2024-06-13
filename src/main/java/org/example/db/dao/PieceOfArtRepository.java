package org.example.db.dao;

import org.example.db.model.PieceOfArt;
import org.springframework.data.repository.CrudRepository;

public interface PieceOfArtRepository extends CrudRepository<PieceOfArt, Integer> {
}