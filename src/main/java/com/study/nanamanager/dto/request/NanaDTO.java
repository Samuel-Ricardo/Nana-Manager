package com.study.nanamanager.dto.request;

import com.study.nanamanager.Nana.NanaPacking;
import com.study.nanamanager.Nana.NanaType;
import com.study.nanamanager.Nana.Nutrients;
import com.study.nanamanager.Nana.Store;
import com.study.nanamanager.Nana.Type;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Samuel
 */

//@Data
//@Builder
//@NoArgsConstructor
//@AllArgsConstructor
public class NanaDTO {
    
    private Long id;
    
    @NotNull
    @Size(min = 1, max =  200)
    private String name;
    
    @Enumerated(EnumType.STRING)
    @NotNull
    private Type type;
    
    @NotNull
    private NanaType nanaType;
    
    @NotNull
    private NanaPacking packing;
    
//    @NotNull
//    private Nutrients nutrients;
    
    @NotNull
    private Long stock;
    
    @NotNull
    private List<Store> stores;

    public NanaDTO(Long id, String name, Type type, NanaType nanaType, NanaPacking packing /*, Nutrients nutrients*/, Long stock, List<Store> stores) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.nanaType = nanaType;
        this.packing = packing;
//        this.nutrients = nutrients;
        this.stock = stock;
        this.stores = stores;
    }

    public NanaDTO() {
    }
    
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
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
        
        return new Nutrients(this);
    }
    
//    public Nutrients getNutrients() {
//        return nutrients;
//    }
//
//    public void setNutrients(Nutrients nutrients) {
//        this.nutrients = nutrients;
//    }

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
