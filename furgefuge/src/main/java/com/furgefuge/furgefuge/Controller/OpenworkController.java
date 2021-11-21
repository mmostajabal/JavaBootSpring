/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.furgefuge.furgefuge.Controller;

import com.furgefuge.furgefuge.Models.Openwork;
import com.furgefuge.furgefuge.Services.OpenworkService;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class OpenworkController {
    private final OpenworkService openworksrv;
    //**********************************
    //  OpenworkController
    //**********************************
    public OpenworkController(OpenworkService openworksrv) {
        this.openworksrv = openworksrv;
    }
    //**********************************
    //  addActivity
    //**********************************
    @PostMapping(path="addOpenwork")
    private Openwork addOpenwork(@RequestBody Openwork openwork){
        return openworksrv.addOpenwork(openwork);
    }
    //**********************************
    //  findAllOpenwork
    //**********************************
    @GetMapping(path="getallOpenwork")
    private List<Openwork> findAllOpenwork(){
        return openworksrv.findAllOpenwork();
    }
    //**********************************
    //  addOpenwork
    //**********************************
    @PostMapping(path="updateOpenwork")
    private Openwork updateOpenwork(@RequestBody Openwork openwork){
        return openworksrv.addOpenwork(openwork);
    }
    
    //**********************************
    //  addOpenwork
    //**********************************
    @PostMapping(path="deleteOpenwork")
    private boolean deleteOpenwork(@RequestBody Openwork openwork){
        return openworksrv.deleteOpenwork(openwork);
    }
       //**********************************
    //  findActivitesOnName
    //**********************************
    @GetMapping(path="getopenwork")
    private List<Openwork> findopenWorks(@RequestParam int usercode){
        return openworksrv.findopenWorks(usercode);
    }    
    
    @GetMapping(value="findbygardencode")
    public List<Openwork> findopenworkagarden(@RequestParam Integer gardencode){
        return openworksrv.findopenworkagarden(gardencode);
    }

}
