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

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
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
    
    @NotNull
    private Nutrients nutrients;
    
    @NotNull
    private Long stock;
    
    @NotNull
    private List<Store> stores;
}
