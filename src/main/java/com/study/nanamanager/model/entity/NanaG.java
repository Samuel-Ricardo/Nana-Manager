package com.study.nanamanager.model.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

/**
 *
 * @author Samuel
 */

//Packing - embalagem + ml

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class NanaG {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private NanaType type;
    
    private NanaPacking packing;
    
    private Nutrients nutrients;
    
    private String Ingredients;
    
    private Long stock;
}
