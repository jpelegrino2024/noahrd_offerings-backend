package com.julioluis.offeringsbackend.services;

import com.julioluis.offeringsbackend.entities.SpentType;

import java.util.List;

public interface SpentTypeService {

    SpentType create(SpentType spentType);
    List<SpentType> getAllSpentTypes();
}
