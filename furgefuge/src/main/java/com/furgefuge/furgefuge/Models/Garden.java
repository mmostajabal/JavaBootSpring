/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.furgefuge.furgefuge.Models;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Mohammad
 */
@Entity
@Table(name = "garden")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Garden.findAll", query = "SELECT g FROM Garden g"),
    @NamedQuery(name = "Garden.findByGardencode", query = "SELECT g FROM Garden g WHERE g.gardencode = :gardencode"),
    @NamedQuery(name = "Garden.findByName", query = "SELECT g FROM Garden g WHERE g.name = :name"),
    @NamedQuery(name = "Garden.findByAddress", query = "SELECT g FROM Garden g WHERE g.address = :address"),
    @NamedQuery(name = "Garden.findByDescription", query = "SELECT g FROM Garden g WHERE g.description = :description"),
    @NamedQuery(name = "Garden.findById", query = "SELECT g FROM Garden g WHERE g.id = :id")})
public class Garden implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "gardencode")
    private int gardencode;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @Column(name = "address")
    private String address;
    @Column(name = "description")
    private String description;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    public Garden() {
    }

    public Garden(Integer id) {
        this.id = id;
    }

    public Garden(Integer id, int gardencode, String name, String address) {
        this.id = id;
        this.gardencode = gardencode;
        this.name = name;
        this.address = address;
    }

    public int getGardencode() {
        return gardencode;
    }

    public void setGardencode(int gardencode) {
        this.gardencode = gardencode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
        if (!(object instanceof Garden)) {
            return false;
        }
        Garden other = (Garden) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.furgefuge.furgefuge.Models.Garden[ id=" + id + " ]";
    }
    
}
