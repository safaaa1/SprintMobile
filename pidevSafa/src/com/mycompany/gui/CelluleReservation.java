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
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.mycompany.entites.Reservation;
import com.mycompany.services.ServiceEvenement;
import com.mycompany.services.ServiceReservation;

/**
 *
 * @author safa
 */
public class CelluleReservation extends Form{
    
    Form current;

    public CelluleReservation(Reservation reservation) {
        
        current = this;
        
        Container c0 = new Container(BoxLayout.x());
        Label lbId = new Label("Id : ");
        Label lbId2 = new Label(String.valueOf(reservation.getIdReser()));
        c0.add(lbId);
        c0.add(lbId2);
        
        Container c1 = new Container(BoxLayout.x());
        Label lbNom = new Label("Event id : ");
        Label lbNom2 = new Label(String.valueOf(reservation.getIdEvent()));
        c1.add(lbNom);
        c1.add(lbNom2);
        
        Container c4 = new Container(BoxLayout.x());
        Label lbNomm = new Label("Event name : ");
        Label lbNomm2 = new Label(String.valueOf(reservation.getNom()));
        c4.add(lbNomm);
        c4.add(lbNomm2); 
        
        
        
        Container c2 = new Container(BoxLayout.x());
        Label lbQuantite = new Label("etat  : ");
        Label lbQuantite2 = new Label(String.valueOf(reservation.getEtat()));
        c2.add(lbQuantite);
        c2.add(lbQuantite2);
        
      Container c5 = new Container(BoxLayout.x());
        Label lbUser = new Label("User name : ");
        Label lbUser2 = new Label(String.valueOf(reservation.getNomUser()));
        c5.add(lbUser);
        c5.add(lbUser2); 
        
          Container c7 = new Container(BoxLayout.x());
        Button btPar = new Button("Valider");
      Button btAvis = new Button("Annuler");

        c7.addAll(btPar,btAvis);
        
    btPar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                System.out.println("Valider");
                System.out.println(ServiceReservation.getInstance().valider(Integer.parseInt(lbId2.getText())));
                new ReservationForm().show();
            }
        });
         btAvis.addActionListener(e-> new AvisForm(current).show());
        
        
         btAvis.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                System.out.println("Annuler");
                System.out.println(ServiceReservation.getInstance().annuler(Integer.parseInt(lbId2.getText())));
                new ReservationForm().show();
           
            }
        });
        
        
       
        Container c_f = new Container(BoxLayout.y());
        c_f.addAll(c4, c5,c2,c7);
        
        add(c_f);
    }
    
}
