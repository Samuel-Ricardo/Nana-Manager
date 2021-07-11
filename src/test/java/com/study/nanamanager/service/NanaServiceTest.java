/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.study.nanamanager.service;

import com.study.nanamanager.dao.repository.NanaRepository;
import com.study.nanamanager.dao.service.NanaService;
import com.study.nanamanager.dto.mapper.NanaMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

/**
 *
 * @author Samuel
 */

@ExtendWith(MockitoExtension.class)
public class NanaServiceTest {
    
    private static final long INAVLID_NANA_ID = 1L;
    
    @Mock
    private NanaRepository repository;
    
    private NanaMapper mapper = NanaMapper.INSTANCE;

    @InjectMocks
    private NanaService service;

    @Test
    void whenNanaInformedThenItShouldBeCreated() {
    }
}
