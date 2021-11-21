/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.furgefuge.furgefuge.Repository;

import com.furgefuge.furgefuge.Models.Activites;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Mohammad
 */
@Repository
public interface ActivitesRepository extends JpaRepository<Activites, Integer>{
}
