/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.furgefuge.furgefuge.Services;

import com.furgefuge.furgefuge.Models.Activites;
import com.furgefuge.furgefuge.Repository.ActivitesRepository;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import org.springframework.jdbc.object.StoredProcedure;
import org.springframework.stereotype.Service;

/**
 *
 * @author Mohammad
 */
@Service

public class ActivitesService {

    private final ActivitesRepository activitesRep;
    @PersistenceContext
    public EntityManager em;

    public ActivitesService(ActivitesRepository activitesRep) {
        this.activitesRep = activitesRep;
    }

    public Activites addActivity(Activites activity) {
        activitesRep.save(activity);
        return activity;
    }

    public List<Activites> findAllActivity() {
        return activitesRep.findAll();
    }

    public Activites updateActivity(Activites activity) {
        return activitesRep.save(activity);
    }

    public boolean deleteActivity(Activites activity) {
        activitesRep.delete(activity);
        return true;
    }

    public List<Activites> findActivitesOnName(String name) {
        StoredProcedureQuery spq = em.createStoredProcedureQuery("findActivitesOnName");
        spq.registerStoredProcedureParameter("activityname", String.class, ParameterMode.IN);
        spq.setParameter("activityname", name);
        List<Activites> activites = new ArrayList();
        List<Object[]> result = spq.getResultList();
        for (Object[] act : result) {
            //read out the primary key, to pass it to em.find() later
            Integer id = Integer.parseInt(act[1].toString()); // Typecast Object -> String -> Integer
            //Use the built in find function to create the full object
            Activites wellFormedObject = em.find(Activites.class, id);
            // Place the object to the return list
            activites.add(wellFormedObject);

        }

        return activites;
    }
}
