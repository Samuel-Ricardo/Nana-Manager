/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.study.nanamanager.controller;

import com.study.nanamanager.dao.service.NanaService;
import com.study.nanamanager.dto.request.NanaDTO;
import com.study.nanamanager.dto.response.Response;
import com.study.nanamanager.factory.NanaFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;
import org.springframework.http.MediaType;
import static org.springframework.mock.http.server.reactive.MockServerHttpRequest.patch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 *
 * @author Samuel
 */
import static com.study.nanamanager.utils.JsonConverter.toJsonString;
import static org.mockito.Mockito.lenient;

@ExtendWith(MockitoExtension.class)
public class NanaControllerTest {

    private static final String DEFAULT_URL = "/api/v1/nana-manager";
    private static final long VALID_NANA_ID = 1L;
    private static final long INVALID_NANA_ID = 2L;

    private MockMvc mockMvc;


    @Mock
    private NanaService service;

    @InjectMocks
    private NanaController controller;

    @BeforeEach
    void setUp() {

        mockMvc = MockMvcBuilders.standaloneSetup(controller)
                .setCustomArgumentResolvers(new PageableHandlerMethodArgumentResolver())
                .setViewResolvers((s, locale) -> new MappingJackson2JsonView())
                .build();
    
    }
    
    @Test
    void whenPOSTIsCalledThenANanaIsCreated() throws Exception {
        // given
        NanaDTO nanaDTO = NanaFactory.getDefaultDTO();

        System.out.println("NANA NAME "+toJsonString(nanaDTO));
        
        Response<NanaDTO> createNana = service.createNana(nanaDTO);
        
        // when
        lenient().when(service.createNana(nanaDTO)).thenReturn(createNana);

        // then
        mockMvc.perform(post(DEFAULT_URL+"/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(toJsonString(nanaDTO)))
                .andExpect(status().isCreated());
//                .andExpect(jsonPath("$.name", is(nanaDTO.getName())))
//                .andExpect(jsonPath("$.stock", is(nanaDTO.getStock())));
    }
}
