/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Display;
import com.codename1.ui.Font;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.Slider;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.geom.Dimension;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.plaf.Border;
import com.codename1.ui.plaf.Style;
import com.mycompany.entites.Avis;

/**
 *
 * @author Mohamed
 */
public class CelluleAvis extends Form{
    
    Form current;

    public CelluleAvis(Avis avis) {
        
        current = this;
        
        Container c0 = new Container(BoxLayout.x());
        Label lbId = new Label("Id : ");
        Label lbId2 = new Label(String.valueOf(avis.getIdAvis()));
        c0.add(lbId);
        c0.add(lbId2);
        
        Container c1 = new Container(BoxLayout.x());
        Label lbNom = new Label("Username  : ");
        Label lbNom2 = new Label(String.valueOf(avis.getNomUser()));
        c1.add(lbNom);
        c1.add(lbNom2);
        
        Container c4 = new Container(BoxLayout.x());
        Label lbNomm = new Label("Event name : ");
        Label lbNomm2 = new Label(String.valueOf(avis.getNom()));
        c4.add(lbNomm);
        c4.add(lbNomm2); 
        
        
        
        Container c2 = new Container(BoxLayout.x());
        Label lbQuantite = new Label("description  : ");
        Label lbQuantite2 = new Label(String.valueOf(avis.getDescription()));
        c2.add(lbQuantite);
        c2.add(lbQuantite2);
        
     
        
        Container c_f = new Container(BoxLayout.y());
        c_f.addAll(c1,c4, c2);
            //c_f.add(FlowLayout.encloseCenter(createStarRankSlider()));

        add(c_f);
        
    }
   
}