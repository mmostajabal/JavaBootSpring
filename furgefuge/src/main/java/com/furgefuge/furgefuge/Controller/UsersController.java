/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.furgefuge.furgefuge.Controller;

import com.furgefuge.furgefuge.Models.Users;
import com.furgefuge.furgefuge.Services.UsersService;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UsersController {
    private final UsersService usersSrv;
    //**********************************
    //  UsersController
    //**********************************
    public UsersController(UsersService userSrv) {
        this.usersSrv = userSrv;
    }
    //**********************************
    //  addActivity
    //**********************************
    @PostMapping(path="addusers")
    private Users addActivity(@RequestBody Users user){
        return usersSrv.addUsers(user);
    }
    //**********************************
    //  findAllActivity
    //**********************************
    @GetMapping(path="getallusers")
    private List<Users> findAllUsers(){
        return usersSrv.findAllUsers();
    }
    //**********************************
    //  addActivity
    //**********************************
    @PostMapping(path="updateusers")
    private Users updateActivity(@RequestBody Users user){
        return usersSrv.addUsers(user);
    }
    
    //**********************************
    //  addActivity
    //**********************************
    @PostMapping(path="deleteusers")
    private boolean deleteActivity(@RequestBody Users user){
        return usersSrv.deleteUsers(user);
    }
    
    //**********************************
    //  findActivitesOnName
    //**********************************
    @GetMapping(path="getuseronname")
    private List<Users> findusersonname(@RequestParam String firstname, @RequestParam String lastname){
        return usersSrv.findusersonname(firstname, lastname);
    }    

    @GetMapping(path="getuserbyidentitycard")
    private List<Users> finduserbyidentitycard(@RequestParam String identitycard){
        return usersSrv.finduserbyidentitycard(identitycard);
    }    
    
    @GetMapping(value="findbystatus")
    public List<Users> finduserisactive(@RequestParam Integer status){
        return usersSrv.finduserisactive(status);
    }
}
