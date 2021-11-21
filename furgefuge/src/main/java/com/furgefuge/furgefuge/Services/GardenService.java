/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.furgefuge.furgefuge.Services;


import com.furgefuge.furgefuge.Models.Garden;

import com.furgefuge.furgefuge.Repository.gardenRepository;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import org.springframework.stereotype.Service;

/**
 *
 * @author Mohammad
 */
@Service
public class GardenService {
    private final gardenRepository gardenRep;
    @PersistenceContext
    public EntityManager em;
    public GardenService(gardenRepository gardenRep) {
        this.gardenRep = gardenRep;
    }

    public Garden addGarden(Garden garden){
        gardenRep.save(garden);
        return garden;
    }

    public List<Garden> findAllGarden(){
        return  gardenRep.findAll();        
    }

    public Garden updateGarden(Garden garden){
        return  gardenRep.save(garden);        
    }
    
    public boolean deleteGarden(Garden garden){
        gardenRep.delete(garden);        
        return true;
    }
    
        public List<Garden> findGardenOnName(String name) {
        StoredProcedureQuery spq = em.createStoredProcedureQuery("findGardenOnName");
        spq.registerStoredProcedureParameter("gardenname", String.class, ParameterMode.IN);
        spq.setParameter("gardenname", name);
        List<Garden> gardens = new ArrayList();
        List<Object[]> result = spq.getResultList();
        for (Object[] garden : result) {
            //read out the primary key, to pass it to em.find() later
            Integer id = Integer.parseInt(garden[0].toString()); // Typecast Object -> String -> Integer
            //Use the built in find function to create the full object
            Garden wellFormedObject = em.find(Garden.class, id);
            // Place the object to the return list
            gardens.add(wellFormedObject);

        }

        return gardens;
    }
}
