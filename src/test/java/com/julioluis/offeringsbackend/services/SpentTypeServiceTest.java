package com.julioluis.offeringsbackend.services;

import com.julioluis.offeringsbackend.entities.SpentType;
import com.julioluis.offeringsbackend.repositories.SpentTypeRepository;
import com.julioluis.offeringsbackend.services.impl.SpentTypeServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class SpentTypeServiceTest {

    @InjectMocks
    private SpentTypeServiceImpl service;
    @Mock
    private SpentTypeRepository spentTypeRepository;

    private SpentType spentType;

    @Before
    public void init() {
        spentType = new SpentType();
    }

    @Test
    public void test_save_spent_type() {
        spentType.setId(1L);
        when(spentTypeRepository.save(any(SpentType.class))).thenReturn(spentType);

        SpentType savedSpentType = service.create(spentType);

        assertNotNull(savedSpentType);
        verify(spentTypeRepository, times(1)).save(any(SpentType.class));
    }
}
