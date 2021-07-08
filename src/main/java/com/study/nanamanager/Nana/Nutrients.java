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
public class Nutrients {
    
    private double carbohydrates;
    private double calories;
    private double sugars;
    private double sodium;
    private String ingredients;
    
    public Nutrients (NanaType nanaType, NanaPacking packing, String ingredients) {
        
       calories = nanaType.getBaseNutrients().calories * packing.getMl();
       carbohydrates = nanaType.getBaseNutrients().carbohydrates * packing.getMl();
       sugars = nanaType.getBaseNutrients().sugars * packing.getMl();
       sodium = nanaType.getBaseNutrients().sodium * packing.getMl();
       
       ingredients = ingredients;
    }
}
