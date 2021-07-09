/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.study.nanamanager.Nana;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 *
 * @author Samuel
 */
@Data
@AllArgsConstructor
public class NanaType {

    private Type nanaType;
    private Nutrients baseNutrients;

    private NanaType(Type type) {

        nanaType = type;

        switch (type) {

            case GUARANA:

                baseNutrients = new Nutrients(
                        0.1,
                        0.415,
                        0.1,
                        0.055,
                        "Água gaseificada, açúcar, extrato de guaraná, acidulante ácido cítrico, conservadores: benzoato de sódio e sorbato de potássio, aromatizante e corante caramelo.\n"
                        + "\n"
                        + "Não contém glúten."
                );
                break;

            case NO_SUGAR:

                baseNutrients = new Nutrients(
                        0,
                        0,
                        0,
                        0.15,
                        "Água gaseificada, açúcar, extrato de guaraná, acidulante ácido cítrico, conservadores: benzoato de sódio e sorbato de potássio, aromatizante e corante caramelo IV.\n"
                        + "\n"
                        + "Não contém glúten.");
                break;

            case NATU:

                baseNutrients = new Nutrients(
                        0.415,
                        0.19,
                        0,
                        0,
                        "Água gaseificada, suco concentrado de pera clarificado, suco concentrado de maçã clarificado, suco concentrado de limão clarificado, concentrado de maçã, cenoura e hibisco, extrato de guaraná, aromas naturais e edulcorantes e glicosídeos de esteviol (13,5 mg/100ml).\n"
                        + "\n"
                        + "Não contém glúten.");
                break;
        }
    }

    public Nutrients getBaseNutrients() {
        
        return baseNutrients;
    }
}
