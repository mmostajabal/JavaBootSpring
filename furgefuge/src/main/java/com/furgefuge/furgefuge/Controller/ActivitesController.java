/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.furgefuge.furgefuge.Controller;

import com.furgefuge.furgefuge.Models.Activites;
import com.furgefuge.furgefuge.Services.ActivitesService;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ActivitesController {
    private final ActivitesService activitesSrv;
    //**********************************
    //  ActivitesController
    //**********************************
    public ActivitesController(ActivitesService activitesSrv) {
        this.activitesSrv = activitesSrv;
    }
    //**********************************
    //  addActivity
    //**********************************
    @PostMapping(path="add")
    private Activites addActivity(@RequestBody Activites act){
        return activitesSrv.addActivity(act);
    }
    //**********************************
    //  findAllActivity
    //**********************************
    @GetMapping(path="getall")
    private List<Activites> findAllActivity(){
        return activitesSrv.findAllActivity();
    }
    //**********************************
    //  addActivity
    //**********************************
    @PostMapping(path="update")
    private Activites updateActivity(@RequestBody Activites act){
        return activitesSrv.addActivity(act);
    }
    
    //**********************************
    //  addActivity
    //**********************************
    @PostMapping(path="delete")
    private boolean deleteActivity(@RequestBody Activites act){
        return activitesSrv.deleteActivity(act);
    }
    
    
     //**********************************
    //  findActivitesOnName
    //**********************************
    @GetMapping(path="getbyname")
    private List<Activites> findActivitesOnName(@RequestParam String name){
        return activitesSrv.findActivitesOnName(name);
    }

}
