package org.example.service;

import lombok.extern.slf4j.Slf4j;
import org.example.db.dao.PieceOfArtRepository;
import org.example.db.model.Category;
import org.example.db.model.PieceOfArt;
import org.example.db.model.Owner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Slf4j
@Service
public class PieceOfArtServiceImpl implements PieceOfArtService {

    @Autowired
    private PieceOfArtRepository pieceOfArtRepository;

    @Override
    public Iterable<PieceOfArt> listAll() {
        return pieceOfArtRepository.findAll();
    }

    @Override
    public void delete(Integer id) {
        pieceOfArtRepository.deleteById(id);
    }

    @Transactional
    @Override
    public PieceOfArt add(String name, Category category, Owner owner, Integer year, Integer price) {
        PieceOfArt piece = new PieceOfArt(name, year, price);
        piece.setOwner(owner);
        piece.setCategory(category);
        return pieceOfArtRepository.save(piece);
    }
}