package com.julioluis.offeringsbackend.controller;

import com.julioluis.offeringsbackend.entities.SpentType;
import com.julioluis.offeringsbackend.services.SpentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/spentTypes")
public class SpentTypeController {

    @Autowired
    private SpentTypeService spentTypeService;

    @PostMapping
    public ResponseEntity<SpentType> create(@RequestBody SpentType type) {
        SpentType spentType = spentTypeService.create(type);
        return ResponseEntity.status(201).body(spentType);
    }

    @GetMapping
    public ResponseEntity<List<SpentType>> getAll() {
        List<SpentType> spentTypes = spentTypeService.getAllSpentTypes();

        return ResponseEntity.ok().body(spentTypes);
    }







}
