package org.example.service;

import lombok.extern.slf4j.Slf4j;
import org.example.db.dao.OwnerRepository;
import org.example.db.model.Owner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Slf4j
@Service
public class OwnerServiceImpl implements OwnerService {

    @Autowired
    private OwnerRepository ownerRepository;

    @Override
    public Iterable<Owner> listAll() {
        return ownerRepository.findAll();
    }

    @Override
    public void delete(Integer id) {
        ownerRepository.deleteById(id);
    }

    @Override
    public Owner add(String name) {
        return ownerRepository.save(new Owner(name));
    }

    @Override
    public Owner findByOwnerId(Integer id) {
        return ownerRepository.findByOwnerId(id);
    }

}