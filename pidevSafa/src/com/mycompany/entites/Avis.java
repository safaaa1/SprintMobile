/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.entites;

/**
 *
 * @author safa
 */
public class Avis {
   private int idAvis;
  private String description;
      private int idEvent;
    private int idParent;
        private int idUtilisateur;
        private double rating;  
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

    public Avis(int idAvis, String description, int idEvent, String nom) {
        this.idAvis = idAvis;
        this.description = description;
        this.idEvent = idEvent;
        this.nom = nom;
    }

    public Avis(int idAvis, String description, String nom) {
        this.idAvis = idAvis;
        this.description = description;
        this.nom = nom;
    }
 
    public Avis(int idEvent,String description) {
        
        this.idEvent=idEvent;
        this.description = description;
    }

    public int getIdAvis() {
        return idAvis;
    }

    public void setIdAvis(int idAvis) {
        this.idAvis = idAvis;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public Avis() {
    }

    public Avis(int idAvis, String description, int idEvent, int idParent, int idUtilisateur, double rating) {
        this.idAvis = idAvis;
        this.description = description;
        this.idEvent = idEvent;
        this.idParent = idParent;
        this.idUtilisateur = idUtilisateur;
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Avis{" + "idAvis=" + idAvis + ", description=" + description + ", idEvent=" + idEvent + ", idParent=" + idParent + ", idUtilisateur=" + idUtilisateur + ", rating=" + rating + ", nom=" + nom + ", nomUser=" + nomUser + '}';
    }
        
        
        
        
}
