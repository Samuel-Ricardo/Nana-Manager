/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.study.nanamanager.Nana;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Samuel
 */

//@Data
//@AllArgsConstructor
public class Nutrients {
    
    private double carbohydrates;
    private double calories;
    private double sugars;
    private double sodium;
    private String ingredients;
    
    @Autowired
    public Nutrients (NanaType nanaType, NanaPacking packing, String ingredients) {
        
       this.calories = nanaType.getBaseNutrients().getCalories() * packing.getMl();
       this.carbohydrates = nanaType.getBaseNutrients().getCarbohydrates() * packing.getMl();
       this.sugars = nanaType.getBaseNutrients().getSugars() * packing.getMl();
       this.sodium = nanaType.getBaseNutrients().getSodium() * packing.getMl();
       
       this.ingredients = ingredients;
    }

    public Nutrients(double carbohydrates, double calories, double sugars, double sodium, String ingredients) {
        this.carbohydrates = carbohydrates;
        this.calories = calories;
        this.sugars = sugars;
        this.sodium = sodium;
        this.ingredients = ingredients;
    }

    public double getCarbohydrates() {
        return carbohydrates;
    }

    public void setCarbohydrates(double carbohydrates) {
        this.carbohydrates = carbohydrates;
    }

    public double getCalories() {
        return calories;
    }

    public void setCalories(double calories) {
        this.calories = calories;
    }

    public double getSugars() {
        return sugars;
    }

    public void setSugars(double sugars) {
        this.sugars = sugars;
    }

    public double getSodium() {
        return sodium;
    }

    public void setSodium(double sodium) {
        this.sodium = sodium;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }
    
    
}
