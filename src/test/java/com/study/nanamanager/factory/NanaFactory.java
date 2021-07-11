/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.study.nanamanager.factory;

import com.study.nanamanager.Nana.NanaPacking;
import com.study.nanamanager.Nana.NanaType;
import com.study.nanamanager.Nana.Store;
import com.study.nanamanager.Nana.Type;
import com.study.nanamanager.dto.mapper.NanaMapper;
import com.study.nanamanager.dto.request.NanaDTO;
import com.study.nanamanager.model.entity.NanaG;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Samuel
 */
public class NanaFactory {
    
    public static NanaDTO getDefaultDTO(){
        
        List<Store> stores = new ArrayList<>();
        
        stores.add(new Store("Lojas Americanas", 3.25));
        
        long id = 25;
        long stock = 68;
        
        return new NanaDTO(
                id, 
                "Guaraná Antártica Natu", 
                Type.NATU, 
                new NanaType(Type.NATU.getType()), 
                new NanaPacking("Latinha", 260), 
                stock,
                stores
        ); 
    }
    
    public static NanaG getDefaultEntity(){
        
        NanaMapper mapper = NanaMapper.INSTANCE;
        
        return mapper.toModel(NanaFactory.getDefaultDTO());
    }
}
