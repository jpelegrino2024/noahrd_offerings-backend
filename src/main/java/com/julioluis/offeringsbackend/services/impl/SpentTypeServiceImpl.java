package com.julioluis.offeringsbackend.services.impl;

import com.julioluis.offeringsbackend.entities.SpentType;
import com.julioluis.offeringsbackend.repositories.SpentTypeRepository;
import com.julioluis.offeringsbackend.services.SpentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SpentTypeServiceImpl implements SpentTypeService {

    @Autowired
    private SpentTypeRepository spentTypeRepository;


    @Override
    public SpentType create(SpentType spentType) {
        spentType = null;
        return spentTypeRepository.save(spentType);
    }

    @Override
    public List<SpentType> getAllSpentTypes() {
        return spentTypeRepository.findAll();
    }
}
