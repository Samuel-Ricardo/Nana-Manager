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

//@Getter
//@AllArgsConstructor
public enum Type {
    
    GUARANA("Guaraná Antártica"),
    NO_SUGAR("Guaraná Antártica 0 Açucar"),
    NATU("Guaraná Antártica Natu");
    
    
    private final String type;

    private Type(String type) {
        this.type = type;
    }

    public static Type getGUARANA() {
        return GUARANA;
    }

    public static Type getNO_SUGAR() {
        return NO_SUGAR;
    }

    public static Type getNATU() {
        return NATU;
    }

    public String getType() {
        return type;
    }
}
