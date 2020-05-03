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
import com.mycompany.entites.Evenement;
import com.mycompany.services.ServiceEvent;

/**
 *
 * @author yanisinfo
 */
public class CelluleEvenement extends Form{
     Form current;

    public CelluleEvenement(Evenement evenement) {
        
        current = this;
        
        Container c1 = new Container(BoxLayout.x());
        Label lbNom = new Label("Nom : ");
        Label lbNom2 = new Label(evenement.getNom());
        c1.add(lbNom);
        c1.add(lbNom2);
        
        Container c2 = new Container(BoxLayout.x());
        Label lbnbrP= new Label("nbrplace : ");
        Label lbnbrP2 = new Label(String.valueOf(evenement.getNbrPlace()));
        c2.add(lbnbrP);
        c2.add(lbnbrP2);
        
        Container c3 = new Container(BoxLayout.x());
        Label lbId = new Label("Id : ");
        Label lbId2 = new Label(String.valueOf(evenement.getIdEvent()));
        //lbId2.setHidden(true);
        c3.add(lbId);
        c3.add(lbId2);
        
        Container c4 = new Container(BoxLayout.x());
        Label lbType = new Label("type : ");
        Label lbType2 = new Label(evenement.getType());
        c4.add(lbType);
        c4.add(lbType2);
        
        Container c5 = new Container(BoxLayout.x());
        Label lbDress = new Label("DressCode : ");
        Label lbDress2 = new Label(evenement.getDressCode());
        c5.add(lbDress);
        c5.add(lbDress2);
        
        
    
 
        
        Container c_f = new Container(BoxLayout.y());
        c_f.addAll(c1, c2, c3,c4,c5);
        
        
        add(c_f);
    }
    
}
