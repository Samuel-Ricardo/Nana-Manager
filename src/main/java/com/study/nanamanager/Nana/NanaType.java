/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.study.nanamanager.Nana;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 *
 * @author Samuel
 */

@Getter
@AllArgsConstructor
public enum NanaType {
    
    GUARANA("Guaraná Antártica"),
    NO_SUGAR("Guaraná Antártica 0 Açucar"),
    NATU("Guaraná Antártica Natu");
    
    
    private final String type;
}
