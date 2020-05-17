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
public class Reservation {
     private int idReser;
  private Date dateReservation; 
  private String etat;
      private int idEvent;
    private int idParent;
        private int idUtilisateur;
 private String nom;
 private String nomUser;

    public String getNomUser() {
        return nomUser;
    }

    public void setNomUser(String nomUser) {
        this.nomUser = nomUser;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getIdReser() {
        return idReser;
    }

    public void setIdReser(int idReser) {
        this.idReser = idReser;
    }

    public Date getDateReservation() {
        return dateReservation;
    }

    public void setDateReservation(Date dateReservation) {
        this.dateReservation = dateReservation;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public int getIdEvent() {
        return idEvent;
    }

    public void setIdEvent(int idEvent) {
        this.idEvent = idEvent;
    }

    public int getIdParent() {
        return idParent;
    }

    public void setIdParent(int idParent) {
        this.idParent = idParent;
    }

    public int getIdUtilisateur() {
        return idUtilisateur;
    }

    public void setIdUtilisateur(int idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

    public Reservation(int idReser, Date dateReservation, String etat, int idEvent, int idParent, int idUtilisateur) {
        this.idReser = idReser;
        this.dateReservation = dateReservation;
        this.etat = etat;
        this.idEvent = idEvent;
        this.idParent = idParent;
        this.idUtilisateur = idUtilisateur;
    }

    public Reservation() {
    }

    public Reservation(int idReser, Date dateReservation, String etat) {
        this.idReser = idReser;
        this.dateReservation = dateReservation;
        this.etat = etat;
    }

 
}
