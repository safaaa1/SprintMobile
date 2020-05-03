/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.layouts.BoxLayout;
import com.mycompany.entites.Evenement;
import com.mycompany.services.ServiceEvent;

/**
 *
 * @author Mohamed
 */
public class ListeEventsForm extends Form{
    
    Form current;
    

    public ListeEventsForm() {
        current = this;
        
        Container liste = new Container(BoxLayout.y());
        for (Evenement evenement : ServiceEvent.getInstance().getAllEvents()) {
            CelluleEvenement celluleEvenement = new CelluleEvenement(evenement);
            liste.add(celluleEvenement);
        }
        
        add(liste);
    }
    
}
