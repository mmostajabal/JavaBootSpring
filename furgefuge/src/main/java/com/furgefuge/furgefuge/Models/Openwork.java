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
@Table(name = "openwork")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Openwork.findAll", query = "SELECT o FROM Openwork o"),
    @NamedQuery(name = "Openwork.findByCode", query = "SELECT o FROM Openwork o WHERE o.code = :code"),
    @NamedQuery(name = "Openwork.findByUsercode", query = "SELECT o FROM Openwork o WHERE o.usercode = :usercode"),
    @NamedQuery(name = "Openwork.findByGardencode", query = "SELECT o FROM Openwork o WHERE o.gardencode = :gardencode"),
    @NamedQuery(name = "Openwork.findByActivitycode", query = "SELECT o FROM Openwork o WHERE o.activitycode = :activitycode"),
    @NamedQuery(name = "Openwork.findByOpendescription", query = "SELECT o FROM Openwork o WHERE o.opendescription = :opendescription"),
    @NamedQuery(name = "Openwork.findByStartdate", query = "SELECT o FROM Openwork o WHERE o.startdate = :startdate"),
    @NamedQuery(name = "Openwork.findByStarttime", query = "SELECT o FROM Openwork o WHERE o.starttime = :starttime"),
    @NamedQuery(name = "Openwork.findByEndtime", query = "SELECT o FROM Openwork o WHERE o.endtime = :endtime"),
    @NamedQuery(name = "Openwork.findByNumofbags", query = "SELECT o FROM Openwork o WHERE o.numofbags = :numofbags"),
    @NamedQuery(name = "Openwork.findByClosedescription", query = "SELECT o FROM Openwork o WHERE o.closedescription = :closedescription"),
    @NamedQuery(name = "Openwork.findByWorkpoint", query = "SELECT o FROM Openwork o WHERE o.workpoint = :workpoint"),
    @NamedQuery(name = "Openwork.findByWorkscore", query = "SELECT o FROM Openwork o WHERE o.workscore = :workscore"),
    @NamedQuery(name = "Openwork.findByBehaviorscore", query = "SELECT o FROM Openwork o WHERE o.behaviorscore = :behaviorscore"),
    @NamedQuery(name = "Openwork.findByEnddate", query = "SELECT o FROM Openwork o WHERE o.enddate = :enddate"),
    @NamedQuery(name = "Openwork.findById", query = "SELECT o FROM Openwork o WHERE o.id = :id")})
public class Openwork implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "code")
    private int code;
    @Basic(optional = false)
    @Column(name = "usercode")
    private int usercode;
    @Basic(optional = false)
    @Column(name = "gardencode")
    private int gardencode;
    @Basic(optional = false)
    @Column(name = "activitycode")
    private int activitycode;
    @Column(name = "opendescription")
    private String opendescription;
    @Basic(optional = false)
    @Column(name = "startdate")
    @Temporal(TemporalType.DATE)
    private Date startdate;
    @Basic(optional = false)
    @Column(name = "starttime")
    @Temporal(TemporalType.TIME)
    private Date starttime;
    @Basic(optional = false)
    @Column(name = "endtime")
    @Temporal(TemporalType.TIME)
    private Date endtime;
    @Basic(optional = false)
    @Column(name = "numofbags")
    private int numofbags;
    @Column(name = "closedescription")
    private String closedescription;
    @Column(name = "workpoint")
    private String workpoint;
    @Column(name = "workscore")
    private Integer workscore;
    @Column(name = "behaviorscore")
    private Integer behaviorscore;
    @Basic(optional = false)
    @Column(name = "enddate")
    @Temporal(TemporalType.DATE)
    private Date enddate;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    public Openwork() {
    }

    public Openwork(Integer id) {
        this.id = id;
    }

    public Openwork(Integer id, int code, int usercode, int gardencode, int activitycode, Date startdate, Date starttime, Date endtime, int numofbags, Date enddate) {
        this.id = id;
        this.code = code;
        this.usercode = usercode;
        this.gardencode = gardencode;
        this.activitycode = activitycode;
        this.startdate = startdate;
        this.starttime = starttime;
        this.endtime = endtime;
        this.numofbags = numofbags;
        this.enddate = enddate;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getUsercode() {
        return usercode;
    }

    public void setUsercode(int usercode) {
        this.usercode = usercode;
    }

    public int getGardencode() {
        return gardencode;
    }

    public void setGardencode(int gardencode) {
        this.gardencode = gardencode;
    }

    public int getActivitycode() {
        return activitycode;
    }

    public void setActivitycode(int activitycode) {
        this.activitycode = activitycode;
    }

    public String getOpendescription() {
        return opendescription;
    }

    public void setOpendescription(String opendescription) {
        this.opendescription = opendescription;
    }

    public Date getStartdate() {
        return startdate;
    }

    public void setStartdate(Date startdate) {
        this.startdate = startdate;
    }

    public Date getStarttime() {
        return starttime;
    }

    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    public int getNumofbags() {
        return numofbags;
    }

    public void setNumofbags(int numofbags) {
        this.numofbags = numofbags;
    }

    public String getClosedescription() {
        return closedescription;
    }

    public void setClosedescription(String closedescription) {
        this.closedescription = closedescription;
    }

    public String getWorkpoint() {
        return workpoint;
    }

    public void setWorkpoint(String workpoint) {
        this.workpoint = workpoint;
    }

    public Integer getWorkscore() {
        return workscore;
    }

    public void setWorkscore(Integer workscore) {
        this.workscore = workscore;
    }

    public Integer getBehaviorscore() {
        return behaviorscore;
    }

    public void setBehaviorscore(Integer behaviorscore) {
        this.behaviorscore = behaviorscore;
    }

    public Date getEnddate() {
        return enddate;
    }

    public void setEnddate(Date enddate) {
        this.enddate = enddate;
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
        if (!(object instanceof Openwork)) {
            return false;
        }
        Openwork other = (Openwork) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.furgefuge.furgefuge.Models.Openwork[ id=" + id + " ]";
    }
    
}
