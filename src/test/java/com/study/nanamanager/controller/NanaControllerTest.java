/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.study.nanamanager.controller;

import com.study.nanamanager.dao.service.NanaService;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;

/**
 *
 * @author Samuel
 */

@ExtendWith(MockitoExtension.class)
public class NanaControllerTest {
    
    private static final String DEFAULT_URL = "/api/v1/nana";         
    private static final long VALID_NANA_ID = 1L;         
    private static final long INVALID_NANA_ID = 2L;

    private MockMvc mockMvc;
    
    @Mock
    private NanaService service;
    
    @InjectMocks
    private NanaController controller;
    
    void setUp() {
        
    }
}
