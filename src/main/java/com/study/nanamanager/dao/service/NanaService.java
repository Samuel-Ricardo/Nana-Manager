package com.study.nanamanager.dao.service;

import com.study.nanamanager.dao.repository.NanaRepository;
import com.study.nanamanager.dto.mapper.NanaMapper;
import com.study.nanamanager.dto.request.NanaDTO;
import com.study.nanamanager.dto.response.Response;
import com.study.nanamanager.exceptions.NanaAlreadyRegisteredException;
import com.study.nanamanager.exceptions.NanaNotFoundException;
import com.study.nanamanager.model.entity.NanaG;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

/**
 *
 * @author Samuel
 */
@Service
//@AllArgsConstructor()
public class NanaService {

    private final NanaRepository nanaRepository;
    private final NanaMapper nanaMapper = NanaMapper.INSTANCE;

    @Autowired
    public NanaService(NanaRepository nanaRepository) {
        this.nanaRepository = nanaRepository;
    }

    public Response<NanaDTO> createNana(NanaDTO nanaDTO) throws NanaAlreadyRegisteredException {

//        Optional<String> error = error.ofNullable("");
        if (checkIfExistsNana(nanaDTO.getName()) == true) {

            throw new NanaAlreadyRegisteredException(nanaDTO.getName());
        }

        NanaG nana = nanaMapper.toModel(nanaDTO);
        NanaG savedNana = nanaRepository.save(nana);
        return new Response<>(
                nanaMapper.toDTO(savedNana),
                "Created With Success",
                HttpStatus.CREATED);
    }

    public Response<NanaDTO> findByName(String name) throws NanaNotFoundException {
        NanaG foundNana = nanaRepository.findByName(name)
                .orElseThrow(() -> new NanaNotFoundException(name));

        return new Response<NanaDTO>(
                nanaMapper.toDTO(foundNana),
                "Nana Found With Success",
                HttpStatus.FOUND);
    }

    public List<Response<NanaDTO>> listAll() {

        return nanaRepository.findAll()
                .stream()
                .map((entity) -> {
                    return new Response<NanaDTO>(
                            nanaMapper.toDTO(entity),
                            "The: " + entity.getName() + " Found :)",
                            HttpStatus.FOUND);
                })
                .collect(Collectors.toList());
    }

    public Response<NanaDTO> deleteById(Long id) throws NanaNotFoundException {

        NanaG nana = getNana(id).orElseThrow(() -> {
            return new NanaNotFoundException(id); //To change body of generated lambdas, choose Tools | Templates.
        });

        nanaRepository.delete(nana);

        return new Response<NanaDTO>(
                nanaMapper.toDTO(nana),
                 "The Nana " + nana.getName() + " with id: " + nana.getId() + " has been deleted",
                HttpStatus.OK
        );
    }

    public Response<NanaDTO> update(Long id, NanaDTO newNana) throws NanaNotFoundException {

        NanaG nana = getNana(id)
                .orElseThrow(() -> new NanaNotFoundException(id));

        NanaG savedNana = nanaRepository.save(nana);

        return new Response<NanaDTO>(
                nanaMapper.toDTO(nana),
                 "The Nana " + nana.getName() + " with id: " + nana.getId() + " has been updated",
                HttpStatus.OK
        );
    }

    public Response<NanaDTO> updateStock(Long id, Long stock) throws NanaNotFoundException {

        NanaG nana = getNana(id)
                .orElseThrow(() -> new NanaNotFoundException(id));
    
        nana.setStock(stock);
        
        return new Response<NanaDTO>(
                nanaMapper.toDTO(
                        nanaRepository.save(nana)
                ),
                "The Stock of Nana " + nana.getName() + " with id: " + nana.getId() + " has been updated",
                HttpStatus.OK
        ); 
    }

    private boolean checkIfExistsNana(String name) {
        Optional<NanaG> optSavedNana = nanaRepository.findByName(name);

        return optSavedNana.isPresent();
    }

    private boolean checkIfExistsNana(Long id) {
        Optional<NanaG> optSavedNana = nanaRepository.findById(id);

        return optSavedNana.isPresent();
    }

    private Optional<NanaG> getNana(String name) {
        Optional<NanaG> optSavedNana = nanaRepository.findByName(name);

        return optSavedNana;
    }

    private Optional<NanaG> getNana(Long id) {
        Optional<NanaG> optSavedNana = nanaRepository.findById(id);

        return optSavedNana;
    }

    public NanaRepository getNanaRepository() {
        return nanaRepository;
    }

    public NanaMapper getNanaMapper() {
        return nanaMapper;
    }
}
