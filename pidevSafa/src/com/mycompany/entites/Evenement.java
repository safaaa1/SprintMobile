/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.entites;

import java.util.Date;

/**
 *
 * @author safa
 */
public class Evenement {
   private int idEvent;
  private String nom;
  private String type;
  private Date date;
   private int nbrPlace;
  private String dressCode;
      private String image;

    public Evenement(int idEvent, String nom, String type, Date date, int nbrPlace, String dressCode, String image) {
        this.idEvent = idEvent;
        this.nom = nom;
        this.type = type;
        this.date = date;
        this.nbrPlace = nbrPlace;
        this.dressCode = dressCode;
        this.image = image;
    }

    public Evenement(int idEvent, String nom, String type, int nbrPlace, String dressCode) {
        this.idEvent = idEvent;
        this.nom = nom;
        this.type = type;
        this.nbrPlace = nbrPlace;
        this.dressCode = dressCode;
    }

    public Evenement() {
    }

   
   
   

    @Override
    public String toString() {
        return "Evenement{" + "idEvent=" + idEvent + ", nom=" + nom + ", type=" + type + ", date=" + date + ", nbrPlace=" + nbrPlace + ", dressCode=" + dressCode + ", image=" + image + '}';
    }

    public int getIdEvent() {
        return idEvent;
    }

    public void setIdEvent(int idEvent) {
        this.idEvent = idEvent;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getNbrPlace() {
        return nbrPlace;
    }

    public void setNbrPlace(int nbrPlace) {
        this.nbrPlace = nbrPlace;
    }

    public String getDressCode() {
        return dressCode;
    }

    public void setDressCode(String dressCode) {
        this.dressCode = dressCode;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
  
}
