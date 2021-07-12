/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.study.nanamanager.service;

import com.study.nanamanager.dao.repository.NanaRepository;
import com.study.nanamanager.dao.service.NanaService;
import com.study.nanamanager.dto.mapper.NanaMapper;
import com.study.nanamanager.dto.request.NanaDTO;
import com.study.nanamanager.dto.response.Response;
import com.study.nanamanager.exceptions.NanaAlreadyRegisteredException;
import com.study.nanamanager.factory.NanaFactory;
import static com.study.nanamanager.factory.NanaFactory.getDefaultDTO;
import com.study.nanamanager.model.entity.NanaG;
import java.util.Optional;
import org.assertj.core.api.Assertions;
import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;


import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.springframework.http.HttpStatus;


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
    void whenNanaInformedThenItShouldBeCreated() throws NanaAlreadyRegisteredException {
    
        // given
        NanaDTO expectedNanaDTO = getDefaultDTO();
        NanaG expectedSavedNana = mapper.toModel(expectedNanaDTO);
    
        // when
        lenient().when(repository.findByName(expectedNanaDTO.getName())).thenReturn(Optional.empty());
        lenient().when(repository.save(expectedSavedNana)).thenReturn(expectedSavedNana);
        
        //then
        Response<NanaDTO> createdNanaDTO = service.createNana(expectedNanaDTO);

        assertThat(createdNanaDTO.getStatus(), is(equalTo(HttpStatus.CREATED)));
//        assertThat(createdNanaDTO.getData().getId(), is(equalTo(expectedNanaDTO.getId())));
//        assertThat(createdNanaDTO.getData().getName(), is(equalTo(expectedNanaDTO.getName())));
//        assertThat(createdNanaDTO.getData().getStock(), is(equalTo(expectedNanaDTO.getStock())));
    }
    
    
    @Test
    void whenAlreadyRegisteredNanaInformedThenAnExceptionShouldBeThrown() {
        // given
        NanaDTO expectedNanaDTO = NanaFactory.getDefaultDTO();
        NanaG duplicatedNana = mapper.toModel(expectedNanaDTO);

        // when
        when(repository.findByName(expectedNanaDTO.getName())).thenReturn(Optional.of(duplicatedNana));

        // then
        assertThrows(NanaAlreadyRegisteredException.class, () -> service.createNana(expectedNanaDTO));
    }
}
