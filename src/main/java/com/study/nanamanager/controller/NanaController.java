/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.study.nanamanager.controller;

import com.study.nanamanager.controller.documentation.NanaControllerDoc;
import com.study.nanamanager.dao.service.NanaService;
import com.study.nanamanager.dto.request.NanaDTO;
import com.study.nanamanager.dto.response.Response;
import com.study.nanamanager.exceptions.NanaAlreadyRegisteredException;
import com.study.nanamanager.exceptions.NanaNotFoundException;
import java.util.List;
import javax.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Samuel
 */
@RestController
@RequestMapping("/api/v1/nana-manager")
//@RequestMapping("/api/v1/nana")
//@AllArgsConstructor()
public class NanaController implements NanaControllerDoc {

    private final NanaService service;

    public NanaController(NanaService nanaService) {
        this.service = nanaService;
    }

    @Override
    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public Response<NanaDTO> createNana(@RequestBody @Valid NanaDTO nanaDTO) throws NanaAlreadyRegisteredException {

        return service.createNana(nanaDTO);
    }

    @Override
    @GetMapping("/{name}")
    @ResponseStatus(HttpStatus.FOUND)
    public Response<NanaDTO> findByName(@PathVariable String name) throws NanaNotFoundException {

        return service.findByName(name);
    }

    @Override
    @GetMapping("/list-all")
    @ResponseStatus(HttpStatus.FOUND)
    public List<Response<NanaDTO>> listNanas() {

        return service.listAll();
    }

    @Override
    @DeleteMapping("/{id}/delete")
    @ResponseStatus(HttpStatus.OK)
    public Response<NanaDTO> deleteById(@PathVariable Long id) throws NanaNotFoundException {

        return service.deleteById(id);
    }

    @Override
    @PutMapping("/{id}/update")
    @ResponseStatus(HttpStatus.OK)
    public Response<NanaDTO> update(@PathVariable Long id, @RequestBody @Valid NanaDTO newNana) throws NanaNotFoundException {

        return service.update(id, newNana);
    }

    @Override
    @PutMapping("/{id}/update-stock")
    @ResponseStatus(HttpStatus.OK)
    public Response<NanaDTO> updateStock(@PathVariable Long id, @RequestBody Long stock) throws NanaNotFoundException {
    
        return service.updateStock(id, stock);
    }
}
