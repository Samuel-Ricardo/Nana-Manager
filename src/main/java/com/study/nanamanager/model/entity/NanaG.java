package com.study.nanamanager.model.entity;

import com.study.nanamanager.Nana.NanaPacking;
import com.study.nanamanager.Nana.NanaType;
import com.study.nanamanager.Nana.Nutrients;
import com.study.nanamanager.Nana.Store;
import com.study.nanamanager.Nana.Type;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
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

//@Data
@Entity
//@AllArgsConstructor
//@NoArgsConstructor
public class NanaG {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    private String name;
    
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Type type;
    
    @ElementCollection
    @Column(nullable = false)
    private NanaType nanaType;
    
    @ElementCollection
    @Column(nullable = false)
    private NanaPacking packing;
    
    @ElementCollection
    @Column(nullable = false)
    private Nutrients nutrients;
    
    @Column(nullable = false)
    private Long stock;
    
    @ElementCollection
    @Column(nullable = false)
    private List<Store> stores;

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public NanaG(Long id, String name, Type type, NanaType nanaType, NanaPacking packing, Nutrients nutrients, Long stock, List<Store> stores) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.nanaType = nanaType;
        this.packing = packing;
        this.nutrients = nutrients;
        this.stock = stock;
        this.stores = stores;
    }

    public NanaG() {
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public NanaType getNanaType() {
        return nanaType;
    }

    public void setNanaType(NanaType nanaType) {
        this.nanaType = nanaType;
    }

    public NanaPacking getPacking() {
        return packing;
    }

    public void setPacking(NanaPacking packing) {
        this.packing = packing;
    }

    public Nutrients getNutrients() {
        return nutrients;
    }

    public void setNutrients(Nutrients nutrients) {
        this.nutrients = nutrients;
    }

    public Long getStock() {
        return stock;
    }

    public void setStock(Long stock) {
        this.stock = stock;
    }

    public List<Store> getStores() {
        return stores;
    }

    public void setStores(List<Store> stores) {
        this.stores = stores;
    }
    
    
}
