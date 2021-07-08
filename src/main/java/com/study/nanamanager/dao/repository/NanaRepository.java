/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.study.nanamanager.dao.repository;

import com.study.nanamanager.model.entity.NanaG;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Samuel
 */
public interface NanaRepository extends JpaRepository<NanaG, Long>{
    
    Optional<NanaG> findByName(String name);
}
