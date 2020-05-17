/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.layouts.BoxLayout;
import com.mycompany.entites.Avis;
import com.mycompany.services.ServiceAvis;

/**
 *
 * @author safa
 */
public class ListAvisForm extends Form{
    
    Form current;
    

    public ListAvisForm() {
        current = this;
        
        Container liste = new Container(BoxLayout.y());
        for (Avis panier : ServiceAvis.getInstance().getAllAvis()) {
            CelluleAvis cellulePanier = new CelluleAvis(panier);
            liste.add(cellulePanier);
        }
        
        add(liste);

    }

    ListAvisForm(Form current) {
    }
    
}
