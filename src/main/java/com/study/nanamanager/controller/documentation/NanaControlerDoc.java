/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.study.nanamanager.controller.documentation;

import com.study.nanamanager.dto.request.NanaDTO;
import com.study.nanamanager.dto.response.Response;
import com.study.nanamanager.exceptions.NanaAlreadyRegisteredException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 *
 * @author Samuel
 */

@Api
public interface NanaControlerDoc {
    
    @ApiOperation(value = "Nana Creation Operation")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Nana Created"),
        @ApiResponse(code = 404, message = "Erro at Create")
    })
    Response<NanaDTO, NanaAlreadyRegisteredException> createNana(NanaDTO nanaDTO);
}
