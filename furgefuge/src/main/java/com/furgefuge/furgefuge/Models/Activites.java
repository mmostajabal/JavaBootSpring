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
@Table(name = "activites")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Activites.findAll", query = "SELECT a FROM Activites a"),
    @NamedQuery(name = "Activites.findByName", query = "SELECT a FROM Activites a WHERE a.name = :name"),
    @NamedQuery(name = "Activites.findById", query = "SELECT a FROM Activites a WHERE a.id = :id"),
    @NamedQuery(name = "Activites.findByActivitycode", query = "SELECT a FROM Activites a WHERE a.activitycode = :activitycode")})
public class Activites implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "activitycode")
    private int activitycode;

    public Activites() {
    }

    public Activites(Integer id) {
        this.id = id;
    }

    public Activites(Integer id, String name, int activitycode) {
        this.id = id;
        this.name = name;
        this.activitycode = activitycode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getActivitycode() {
        return activitycode;
    }

    public void setActivitycode(int activitycode) {
        this.activitycode = activitycode;
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
        if (!(object instanceof Activites)) {
            return false;
        }
        Activites other = (Activites) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.furgefuge.furgefuge.Models.Activites[ id=" + id + " ]";
    }
    
}
