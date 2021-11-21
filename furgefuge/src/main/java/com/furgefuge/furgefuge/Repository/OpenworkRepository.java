/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.furgefuge.furgefuge.Repository;

import com.furgefuge.furgefuge.Models.Openwork;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Mohammad
 */
@Repository
public interface OpenworkRepository extends JpaRepository<Openwork, Integer>{
    @Query(value="select o from Openwork o where o.gardencode = :gardencode ")
    public List<Openwork> findopenworkagarden(@Param("gardencode") Integer gardencode);
}
