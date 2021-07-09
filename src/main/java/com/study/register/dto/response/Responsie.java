/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.study.nanamanager.dto.responsie;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

/**
 *
 * @author Samuel
 * @param <Data>
 */

@AllArgsConstructor
@Getter
@Setter
public class Responsie<Data> {
    
//    private Optional<Data> data;
    private Data data;
    private String message;
    private HttpStatus status;
    
}