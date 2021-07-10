package com.study.nanamanager.Nana;

import javax.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Samuel
 */

//@Getter
//@Setter
//@AllArgsConstructor
@Embeddable
public class NanaPacking {
    
    private String pack;
    private int ml;

    public NanaPacking(String pack, int ml) {
        this.pack = pack;
        this.ml = ml;
    }

    public String getPack() {
        return pack;
    }

    public void setPack(String pack) {
        this.pack = pack;
    }

    public int getMl() {
        return ml;
    }

    public void setMl(int ml) {
        this.ml = ml;
    }
    
    
}
