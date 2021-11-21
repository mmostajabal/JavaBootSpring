/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.furgefuge.furgefuge.Services;

import com.furgefuge.furgefuge.Models.Users;
import com.furgefuge.furgefuge.Repository.UseresRepository;
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
public class UsersService {
    private final UseresRepository usersRep;
    @PersistenceContext
    public EntityManager em;
    
    public UsersService(UseresRepository usersRep) {
        this.usersRep = usersRep;
    }

    public Users addUsers(Users users){
        usersRep.save(users);
        return users;
    }

    public List<Users> findAllUsers(){
        return  usersRep.findAll();        
    }

    public Users updateUsers(Users users){
        return  usersRep.save(users);        
    }
    
    public boolean deleteUsers(Users users){
        usersRep.delete(users);        
        return true;
    }
    
    public List<Users> findusersonname(String firstname, String lastname) {
        StoredProcedureQuery spq = em.createStoredProcedureQuery("findusersonname");
        spq.registerStoredProcedureParameter("firstnamein", String.class, ParameterMode.IN);
        spq.registerStoredProcedureParameter("lastnamein", String.class, ParameterMode.IN);
        spq.setParameter("firstnamein", firstname);
        spq.setParameter("lastnamein", lastname);

        List<Users> users = new ArrayList();
        List<Object[]> result = spq.getResultList();
        for (Object[] ow : result) {
            //read out the primary key, to pass it to em.find() later
            Integer id = Integer.parseInt(ow[1].toString()); // Typecast Object -> String -> Integer
            //Use the built in find function to create the full object
            Users wellFormedObject = em.find(Users.class, id);
            // Place the object to the return list
            users.add(wellFormedObject);

        }

        return users;
    }
    
    public List<Users>  finduserbyidentitycard(String identitycard){
        StoredProcedureQuery spq = em.createStoredProcedureQuery("finduserbyidentitycard");
        spq.registerStoredProcedureParameter("identitycardIn", String.class, ParameterMode.IN);
        
        spq.setParameter("identitycardIn", identitycard);
        

        List<Users> users = new ArrayList();
        List<Object[]> result = spq.getResultList();
        for (Object[] ow : result) {
            //read out the primary key, to pass it to em.find() later
            Integer id = Integer.parseInt(ow[1].toString()); // Typecast Object -> String -> Integer
            //Use the built in find function to create the full object
            Users wellFormedObject = em.find(Users.class, id);
            // Place the object to the return list
            users.add(wellFormedObject);

        }

        return users;        
    }
    
    public List<Users> finduserisactive(Integer isactive) {
        List<Users> result = usersRep.findByStatus(isactive);
        if (CollectionUtils.isEmpty(result)) {
            throw new NoResultException("Not found by status");
        } else {
            return result;
        }
    }
}
