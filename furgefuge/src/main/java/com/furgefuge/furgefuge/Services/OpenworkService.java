/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.furgefuge.furgefuge.Services;

import com.furgefuge.furgefuge.Models.Openwork;
import com.furgefuge.furgefuge.Repository.OpenworkRepository;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

/**
 *
 * @author Mohammad
 */
@Service
public class OpenworkService {

    private final OpenworkRepository openworkRep;
    @PersistenceContext
    public EntityManager em;

    public OpenworkService(OpenworkRepository openworkRep) {
        this.openworkRep = openworkRep;
    }

    public Openwork addOpenwork(Openwork openwork) {
        openworkRep.save(openwork);
        return openwork;
    }

    public List<Openwork> findAllOpenwork() {
        return openworkRep.findAll();
    }

    public Openwork updateOpenwork(Openwork openwork) {
        return openworkRep.save(openwork);
    }

    public boolean deleteOpenwork(Openwork openwork) {
        openworkRep.delete(openwork);
        return true;
    }

    public List<Openwork> findopenWorks(int usercode) {
        StoredProcedureQuery spq = em.createStoredProcedureQuery("findopenWorks");
        spq.registerStoredProcedureParameter("usercodeIn", Integer.class, ParameterMode.IN);
        spq.setParameter("usercodeIn", usercode);
        List<Openwork> openworks = new ArrayList();
        List<Object[]> result = spq.getResultList();
        for (Object[] ow : result) {
            //read out the primary key, to pass it to em.find() later
            Integer id = Integer.parseInt(ow[1].toString()); // Typecast Object -> String -> Integer
            //Use the built in find function to create the full object
            Openwork wellFormedObject = em.find(Openwork.class, id);
            // Place the object to the return list
            openworks.add(wellFormedObject);

        }

        return openworks;
    }

    public List<Openwork> findopenworkagarden(Integer gardencode) {
        List<Openwork> result = openworkRep.findopenworkagarden(gardencode);
        if (CollectionUtils.isEmpty(result)) {
            throw new NoResultException("Not found by status");
        } else {
            return result;
        }
    }

}
