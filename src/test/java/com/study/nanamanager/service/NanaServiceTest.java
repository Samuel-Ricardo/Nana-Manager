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
import com.study.nanamanager.exceptions.NanaNotFoundException;
import com.study.nanamanager.factory.NanaFactory;
import static com.study.nanamanager.factory.NanaFactory.getDefaultDTO;
import com.study.nanamanager.model.entity.NanaG;
import java.util.Collections;
import java.util.List;
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

    @Test
    void whenValidNanaNameIsGivenThenReturnANana() throws NanaNotFoundException {
        // given
        NanaDTO expectedFoundNanaDTO = NanaFactory.getDefaultDTO();
        NanaG expectedFoundNana = mapper.toModel(expectedFoundNanaDTO);

        // when
        when(repository.findByName(expectedFoundNana.getName())).thenReturn(Optional.of(expectedFoundNana));

        // then
        Response<NanaDTO> foundNanaDTO = service.findByName(expectedFoundNanaDTO.getName());

        assertThat(foundNanaDTO.getData().getName(), is(equalTo(expectedFoundNanaDTO.getName())));
    }

    @Test
    void whenNotRegisteredNanaNameIsGivenThenThrowAnException() {
        // given
        NanaDTO expectedFoundNanaDTO = NanaFactory.getDefaultDTO();

        // when
        when(repository.findByName(expectedFoundNanaDTO.getName())).thenReturn(Optional.empty());

        // then
        assertThrows(NanaNotFoundException.class, () -> service.findByName(expectedFoundNanaDTO.getName()));
    }

    @Test
    void whenListNanaIsCalledThenReturnAListOfNanas() {
        // given
        NanaDTO expectedFoundNanaDTO = NanaFactory.getDefaultDTO();
        NanaG expectedFoundNana = mapper.toModel(expectedFoundNanaDTO);

        //when
        when(repository.findAll()).thenReturn(Collections.singletonList(expectedFoundNana));

        //then
        List<Response<NanaDTO>> foundListNanasDTO = service.listAll();

        assertThat(foundListNanasDTO, is(not(empty())));
        assertThat(foundListNanasDTO.get(0).getData().getName(), is(equalTo(expectedFoundNanaDTO.getName())));
    }

    @Test
    void whenListNanaIsCalledThenReturnAnEmptyListOfNanas() {
        //when
        when(repository.findAll()).thenReturn(Collections.EMPTY_LIST);

        //then
        List<Response<NanaDTO>> foundListNanasDTO = service.listAll();

        assertThat(foundListNanasDTO, is(empty()));
    }

    @Test
    void whenExclusionIsCalledWithValidIdThenANanaShouldBeDeleted() throws NanaNotFoundException {
        // given
        NanaDTO expectedDeletedNanaDTO = NanaFactory.getDefaultDTO();
        NanaG expectedDeletedNana = NanaFactory.getDefaultEntity();

        // when
        lenient().when(repository.findById(expectedDeletedNanaDTO.getId())).thenReturn(Optional.of(expectedDeletedNana));
        lenient().doNothing().when(repository).deleteById(expectedDeletedNanaDTO.getId());

        // then
        Response<NanaDTO> deletedNana = service.deleteById(expectedDeletedNanaDTO.getId());

//        verify(repository, times(1)).findById(expectedDeletedNanaDTO.getId());
//        verify(repository, times(1)).deleteById(expectedDeletedNanaDTO.getId());
        assertThat(deletedNana.getData().getId(), is(equalTo(expectedDeletedNanaDTO.getId())));
    }
    
/*
    @Test
    void testUpdateNana() throws NanaNotFoundException {
        // given
        NanaDTO expectedUpdatedNanaDTO = NanaFactory.getDefaultDTO();
        expectedUpdatedNanaDTO.setId(1l);
        expectedUpdatedNanaDTO.setName("New Name");
        NanaG expectedUpdatedNana = mapper.toModel(expectedUpdatedNanaDTO);

        // when
        lenient().when(repository.save(expectedUpdatedNana)).thenReturn(expectedUpdatedNana);

        // then
        Response<NanaDTO> updateResponse = service.update(expectedUpdatedNanaDTO.getId(), expectedUpdatedNanaDTO);

        //assert
        assertThat(updateResponse.getData().getId(), is(equalTo(expectedUpdatedNanaDTO.getId())));
        assertThat(updateResponse.getData().getName(), not(is(equalTo(expectedUpdatedNanaDTO.getName()))));
    }

    @Test
    void testUpdateNanaStock() throws NanaNotFoundException {
        // given
        NanaDTO expectedUpdatedNanaDTO = NanaFactory.getDefaultDTO();
        expectedUpdatedNanaDTO.setStock(10L);
        NanaG expectedUpdatedNana = mapper.toModel(expectedUpdatedNanaDTO);

        // when
        lenient()
                .when(repository.save(expectedUpdatedNana))
                .thenReturn(expectedUpdatedNana);

        // then
        Response<NanaDTO> updateResponse = service.updateStock(
                expectedUpdatedNanaDTO.getId(),
                expectedUpdatedNanaDTO.getStock()
        );

        //assert
        assertThat(updateResponse.getData().getId(),
                is(equalTo(expectedUpdatedNanaDTO.getId())));

        assertThat(updateResponse.getData().getName(),
                not(
                        is(
                                equalTo(
                                        expectedUpdatedNanaDTO.getName()
                                )
                        )
                )
        );
    }
*/
}
