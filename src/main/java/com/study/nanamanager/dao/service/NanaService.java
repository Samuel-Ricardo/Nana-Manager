package com.study.nanamanager.dao.service;

import com.study.nanamanager.dao.repository.NanaRepository;
import com.study.nanamanager.dto.mapper.NanaMapper;
import com.study.nanamanager.dto.request.NanaDTO;
import com.study.nanamanager.dto.response.Response;
import com.study.nanamanager.exceptions.NanaAlreadyRegisteredException;
import com.study.nanamanager.model.entity.NanaG;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

/**
 *
 * @author Samuel
 */

@Service
@AllArgsConstructor()
public class NanaService {
    
    private final NanaRepository nanaRepository;
    private final NanaMapper nanaMapper = NanaMapper.INSTANCE;
    
    public Response<NanaDTO> createNana(NanaDTO nanaDTO) throws NanaAlreadyRegisteredException {
    
//        Optional<String> error = error.ofNullable("");
        
        if(checkIfExistsNana(nanaDTO.getName()) == true) {
            
            throw new NanaAlreadyRegisteredException(nanaDTO.getName());
        }
        
        NanaG nana = nanaMapper.toModel(nanaDTO);
        NanaG savedNana = nanaRepository.save(nana);
        return new Response<NanaDTO>(
                nanaMapper.toDTO(savedNana),
                "", 
                HttpStatus.CREATED);
    }

    private boolean checkIfExistsNana(String name) {
        Optional<NanaG> optSavedNana = nanaRepository.findByName(name);
        
        return optSavedNana.isPresent();
    }
    
    private Optional<NanaG> getNana(String name) {
        Optional<NanaG> optSavedNana = nanaRepository.findByName(name);
        
        return optSavedNana;
    }
}