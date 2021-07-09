/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.study.nanamanager.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author Samuel
 */

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NanaNotFoundException extends Exception{
    
    public NanaNotFoundException (String nanaName) {
        super(String.format("Nana With name: %s not found :(", nanaName));
    }
    
    public NanaNotFoundException (Long id) {
        super(String.format("Nana with id: %s not found :(", id));
    }
}
