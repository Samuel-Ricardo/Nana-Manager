/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.study.nanamanager.Nana;

/**
 *
 * @author Samuel
 */
public class NanaType {

    private Type nanaType;
    private Nutrients baseNutrients;
    private String ingredients;

    private NanaType(Type type) {

        nanaType = type;

        switch (type) {

            case GUARANA:

                ingredients = "Água gaseificada, açúcar, extrato de guaraná, acidulante ácido cítrico, conservadores: benzoato de sódio e sorbato de potássio, aromatizante e corante caramelo.\n"
                        + "\n"
                        + "\n"
                        + "\n"
                        + "Não contém glúten.";
                baseNutrients = new Nutrients();
                break;
        }
    }
}
