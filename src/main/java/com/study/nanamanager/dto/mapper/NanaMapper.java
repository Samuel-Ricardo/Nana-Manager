/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.study.nanamanager.dto.mapper;

import com.study.nanamanager.dto.request.NanaDTO;
import com.study.nanamanager.model.entity.NanaG;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 *
 * @author Samuel
 */

@Mapper
public interface NanaMapper {
    
    NanaMapper INSTANCE = Mappers.getMapper(NanaMapper.class);

    NanaG toModel(NanaDTO dto);
    
    NanaDTO toDTO(NanaG entity);
}
