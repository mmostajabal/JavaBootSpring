/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.furgefuge.furgefuge.Controller;

import com.furgefuge.furgefuge.Models.Garden;
import com.furgefuge.furgefuge.Services.GardenService;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class GardenController {
    private final GardenService gardenSrv;
    //**********************************
    //  GardenController
    //**********************************
    public GardenController(GardenService gardenSrv) {
        this.gardenSrv = gardenSrv;
    }
    //**********************************
    //  addActivity
    //**********************************
    @PostMapping(path="addgarden")
    private Garden addGarden(@RequestBody Garden act){
        return gardenSrv.addGarden(act);
    }
    //**********************************
    //  findAllActivity
    //**********************************
    @GetMapping(path="getallgarden")
    private List<Garden> findAllGarden(){
        return gardenSrv.findAllGarden();
    }
    //**********************************
    //  addActivity
    //**********************************
    @PostMapping(path="updategarden")
    private Garden updateGarden(@RequestBody Garden act){
        return gardenSrv.addGarden(act);
    }
    
    //**********************************
    //  addActivity
    //**********************************
    @PostMapping(path="deletegarden")
    private boolean deleteGarden(@RequestBody Garden act){
        return gardenSrv.deleteGarden(act);
    }
    
   //**********************************
    //  findActivitesOnName
    //**********************************
    @GetMapping(path="getgardenbyname")
    private List<Garden> findActivitesOnName(@RequestParam String name){
        return gardenSrv.findGardenOnName(name);
    }    
}
