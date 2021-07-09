/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.study.nanamanager.controller.documentation;

import com.study.nanamanager.dto.request.NanaDTO;
import com.study.nanamanager.dto.response.Response;
import com.study.nanamanager.exceptions.NanaAlreadyRegisteredException;
import com.study.nanamanager.exceptions.NanaNotFoundException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import java.util.List;
import org.springframework.web.bind.annotation.PathVariable;

/**
 *
 * @author Samuel
 */
@Api
public interface NanaControllerDoc {

    @ApiOperation(value = "Nana Creation Operation")
    @ApiResponses(value = {
        @ApiResponse(code = 201, message = "Nana Created"),
        @ApiResponse(code = 400, message = "Erro at Create")
    })
    Response
       <NanaDTO>
         createNana(NanaDTO nanaDTO) throws NanaAlreadyRegisteredException;
         
     @ApiOperation(value = "Find Nana Operation, return the first nana that found")
        @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Find Nana"),
            @ApiResponse(code = 404, message = "Erro at Find Nana")
        })
     Response<NanaDTO> findByName(@PathVariable String name) throws NanaNotFoundException;

    @ApiOperation(value = "Returns a list of all nanas registered in the system")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "List of all nana registered in the system"),
    })
    List<Response<NanaDTO>> listBeers();

    @ApiOperation(value = "Delete a nana found by a given valid Id")
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Success nana deleted in the system"),
            @ApiResponse(code = 404, message = "Nana with given id not found.")
    })
    Response<NanaDTO> deleteById(@PathVariable Long id) throws NanaNotFoundException;
}
