package com.study.nanamanager.model.entity;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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
    
    @Column(nullable = false)
    private String name;
    
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private NanaType type;
    
    @Column(nullable = false)
    private NanaPacking packing;
    
    @Column(nullable = false)
    private Nutrients nutrients;
    
    @Column(nullable = false)
    private String Ingredients;
    
    @Column(nullable = false)
    private Long stock;
    
    @Column(nullable = false)
    private List<Store> stores;
}
