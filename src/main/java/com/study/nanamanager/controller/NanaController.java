/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.study.nanamanager.controller;

import com.study.nanamanager.controller.documentation.NanaControllerDoc;
import com.study.nanamanager.dto.request.NanaDTO;
import com.study.nanamanager.dto.response.Response;
import com.study.nanamanager.exceptions.NanaAlreadyRegisteredException;
import com.study.nanamanager.exceptions.NanaNotFoundException;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Samuel
 */

@RestController
@RequestMapping("/api/v1/nana-manager")
//@RequestMapping("/api/v1/nana")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class NanaController implements NanaControllerDoc{

    @Override
    public Response<NanaDTO, NanaAlreadyRegisteredException> createNana(NanaDTO nanaDTO) throws NanaAlreadyRegisteredException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Response<NanaDTO, NanaNotFoundException> findByName(String name) throws NanaNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Response<NanaDTO, Exception>> listBeers() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Response<NanaDTO, NanaNotFoundException> deleteById(Long id) throws NanaNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
