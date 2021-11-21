/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.furgefuge.furgefuge.Models;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Mohammad
 */
@Entity
@Table(name = "users")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Users.findAll", query = "SELECT u FROM Users u"),
    @NamedQuery(name = "Users.findByUserid", query = "SELECT u FROM Users u WHERE u.userid = :userid"),
    @NamedQuery(name = "Users.findByIdentitycard", query = "SELECT u FROM Users u WHERE u.identitycard = :identitycard"),
    @NamedQuery(name = "Users.findByFirstname", query = "SELECT u FROM Users u WHERE u.firstname = :firstname"),
    @NamedQuery(name = "Users.findByLastname", query = "SELECT u FROM Users u WHERE u.lastname = :lastname"),
    @NamedQuery(name = "Users.findByEmail", query = "SELECT u FROM Users u WHERE u.email = :email"),
    @NamedQuery(name = "Users.findByPhonenumber", query = "SELECT u FROM Users u WHERE u.phonenumber = :phonenumber"),
    @NamedQuery(name = "Users.findByHourlywages", query = "SELECT u FROM Users u WHERE u.hourlywages = :hourlywages"),
    @NamedQuery(name = "Users.findByPassword", query = "SELECT u FROM Users u WHERE u.password = :password"),
    @NamedQuery(name = "Users.findByGender", query = "SELECT u FROM Users u WHERE u.gender = :gender"),
    @NamedQuery(name = "Users.findByUsertype", query = "SELECT u FROM Users u WHERE u.usertype = :usertype"),
    @NamedQuery(name = "Users.findByCompanycode", query = "SELECT u FROM Users u WHERE u.companycode = :companycode"),
    @NamedQuery(name = "Users.findByIsactive", query = "SELECT u FROM Users u WHERE u.isactive = :isactive"),
    @NamedQuery(name = "Users.findByDateoflastchanges", query = "SELECT u FROM Users u WHERE u.dateoflastchanges = :dateoflastchanges"),
    @NamedQuery(name = "Users.findByModifiercode", query = "SELECT u FROM Users u WHERE u.modifiercode = :modifiercode"),
    @NamedQuery(name = "Users.findById", query = "SELECT u FROM Users u WHERE u.id = :id")})
public class Users implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "userid")
    private int userid;
    @Column(name = "identitycard")
    private String identitycard;
    @Basic(optional = false)
    @Column(name = "firstname")
    private String firstname;
    @Basic(optional = false)
    @Column(name = "lastname")
    private String lastname;
    @Basic(optional = false)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @Column(name = "phonenumber")
    private String phonenumber;
    @Basic(optional = false)
    @Column(name = "hourlywages")
    private double hourlywages;
    @Basic(optional = false)
    @Column(name = "password")
    private String password;
    @Basic(optional = false)
    @Column(name = "gender")
    private String gender;
    @Basic(optional = false)
    @Column(name = "usertype")
    private String usertype;
    @Column(name = "companycode")
    private Integer companycode;
    @Basic(optional = false)
    @Column(name = "isactive")
    private int isactive;
    @Basic(optional = false)
    @Column(name = "dateoflastchanges")
    @Temporal(TemporalType.DATE)
    private Date dateoflastchanges;
    @Basic(optional = false)
    @Column(name = "modifiercode")
    private int modifiercode;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    public Users() {
    }

    public Users(Integer id) {
        this.id = id;
    }

    public Users(Integer id, int userid, String firstname, String lastname, String email, String phonenumber, double hourlywages, String password, String gender, String usertype, int isactive, Date dateoflastchanges, int modifiercode) {
        this.id = id;
        this.userid = userid;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.phonenumber = phonenumber;
        this.hourlywages = hourlywages;
        this.password = password;
        this.gender = gender;
        this.usertype = usertype;
        this.isactive = isactive;
        this.dateoflastchanges = dateoflastchanges;
        this.modifiercode = modifiercode;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getIdentitycard() {
        return identitycard;
    }

    public void setIdentitycard(String identitycard) {
        this.identitycard = identitycard;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public double getHourlywages() {
        return hourlywages;
    }

    public void setHourlywages(double hourlywages) {
        this.hourlywages = hourlywages;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getUsertype() {
        return usertype;
    }

    public void setUsertype(String usertype) {
        this.usertype = usertype;
    }

    public Integer getCompanycode() {
        return companycode;
    }

    public void setCompanycode(Integer companycode) {
        this.companycode = companycode;
    }

    public int getIsactive() {
        return isactive;
    }

    public void setIsactive(int isactive) {
        this.isactive = isactive;
    }

    public Date getDateoflastchanges() {
        return dateoflastchanges;
    }

    public void setDateoflastchanges(Date dateoflastchanges) {
        this.dateoflastchanges = dateoflastchanges;
    }

    public int getModifiercode() {
        return modifiercode;
    }

    public void setModifiercode(int modifiercode) {
        this.modifiercode = modifiercode;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Users)) {
            return false;
        }
        Users other = (Users) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.furgefuge.furgefuge.Models.Users[ id=" + id + " ]";
    }
    
}
