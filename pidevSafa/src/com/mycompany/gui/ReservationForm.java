/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.mycompany.entites.Evenement;
import com.mycompany.entites.Reservation;
import com.mycompany.services.ServiceAvis;
import com.mycompany.services.ServiceReservation;

/**
 *
 * @author safa
 */
public class ReservationForm extends Form {

   Form current;
    Integer idEvent;

    
    /**
     *
     */
    public ReservationForm() {
        
        current = this;
        
       Container liste = new Container(BoxLayout.y());
        for (Reservation produit : ServiceReservation.getInstance().getAllReservations()) {
            CelluleReservation celluleProduit = new CelluleReservation(produit);
            liste.add(celluleProduit);
        }
        
        add(liste);
    }

    ReservationForm(int parseInt) {
    }
    
}
