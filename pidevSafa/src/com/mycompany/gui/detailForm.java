/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.util.Resources;
import com.mycompany.entites.Evenement;
import com.mycompany.services.ServiceEvenement;

/**
 *
 * @author safa
 */
public class detailForm extends Form {
        Form current;
    public detailForm(Resources theme,int id) {
         Container liste = new Container(BoxLayout.y());
        for (Evenement produit : ServiceEvenement.getInstance().detail(id)) {
            CelluleEvenement celluleProduit = new CelluleEvenement(produit, theme);
            liste.add(celluleProduit);

        }
        add(liste);

    }

    detailForm(Form current) {
    }

   
}
