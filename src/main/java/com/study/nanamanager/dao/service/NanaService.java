package com.study.nanamanager.dao.service;

import com.study.nanamanager.dao.repository.NanaRepository;
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
//    private final NanaMapper nanaMapper;
}
