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

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class NanaAlreadyRegisteredException extends  Exception{
 
    public NanaAlreadyRegisteredException(String nanaName){
        super(String.format("Nana with name %s already registered in the system.", nanaName));
    }
}
