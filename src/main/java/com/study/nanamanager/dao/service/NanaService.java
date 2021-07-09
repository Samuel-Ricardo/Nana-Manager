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
import org.springframework.stereotype.Service;

/**
 *
 * @author Samuel
 */

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class NanaService {
    
    private final NanaRepository nanaRepository;
    private final NanaMapper nanaMapper = NanaMapper.INSTANCE;

    public Response<NanaDTO, NanaAlreadyRegisteredException> createNana(NanaDTO nanaDTO) {
        
        Optional<NanaG> nana = getNana(nanaDTO.getName());
    
        if(nana.isPresent()) {
            
        }
        
        return null;
    }

    private boolean checkIfExistsNana(String name) {
        Optional<NanaG> optSavedNana = nanaRepository.findByName(name);
        
        return optSavedNana.isPresent();
    }

}