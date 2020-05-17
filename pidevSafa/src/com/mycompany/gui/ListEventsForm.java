/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.components.ImageViewer;
import com.codename1.components.SpanLabel;
import com.codename1.notifications.LocalNotification;
import com.codename1.ui.Component;
import com.codename1.ui.Container;           
import com.codename1.ui.Display;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.Font;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.Slider;
import com.codename1.ui.TextArea;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.URLImage;
import com.codename1.ui.geom.Dimension;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.Border;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import com.mycompany.entites.Evenement;

import com.mycompany.services.ServiceEvenement;

/**
 *
 * @author safa
 */
public class ListEventsForm extends Form {

    Form current;

    public ListEventsForm(Resources theme) {
       
        //  current = this;
        
        
        Toolbar.setGlobalToolbar(true);
        //   getToolbar().addCommandToLeftBar("",theme.getImage("back.png"), e->new Home(theme).show());
        Style s = UIManager.getInstance().getComponentStyle("Title");
        TextField searchField = new TextField("", "Recherche evenement"); // <1>
        searchField.getHintLabel().setUIID("Title");
        searchField.setUIID("Title");
        searchField.getAllStyles().setAlignment(Component.LEFT);
        getToolbar().setTitleComponent(searchField);
        FontImage searchIcon = FontImage.createMaterial(FontImage.MATERIAL_SEARCH, s);

        searchField.addDataChangeListener((i1, i2) -> { // <2>
            String t = searchField.getText();
            if (t.length() < 1) {
                for (Component cmp : getContentPane()) {
                    for (Component cmpp : ((Container) cmp).getChildrenAsList(focusScrolling)) {
                        cmpp.setHidden(false);
                        cmpp.setVisible(true);
                    }
                }
            } else {
                t = t.toLowerCase();               
                for (Component cmp : getContentPane()) {                   
                    if (cmp instanceof Container) {                   
                        for (Component cmpp : ((Container) cmp).getChildrenAsList(focusScrolling)) {
                            if (cmpp instanceof Container) {
                                for (Component cmppp : ((Container) cmpp).getChildrenAsList(focusScrolling)) {
                                                                String val = null;
                                    if (cmppp instanceof Container) {
                                        for (Component cmpppp : ((Container) cmppp).getChildrenAsList(focusScrolling)) {
                                             if (cmpppp instanceof Container) {
                                                for (Component cmppppp : ((Container) cmpppp).getChildrenAsList(focusScrolling)) {
                                                    
                                                    if (cmppppp instanceof Container) {                                                    
                                                        for (Component cmpppppp : ((Container) cmppppp).getChildrenAsList(focusScrolling)) {
                                                            
                                                            if (cmpppppp instanceof Container) {
                                                              
                                                                for (Component cmppppppp : ((Container) cmpppppp).getChildrenAsList(focusScrolling)) {
                                                                 
                                                                    if (cmppppppp instanceof SpanLabel) {
                                                                        for (Component cmpp2 : ((Container) cmppppppp).getChildrenAsList(focusScrolling)) {                 
                                                                              boolean show = false;
                                                                            if (cmpp2 instanceof Container) {
                                                                                for (Component cmpp3 : ((Container) cmpp2).getChildrenAsList(focusScrolling)) {
                                                                                    if (cmpp3 instanceof TextArea)  
                                                                                        val = ((TextArea) cmpp3).getText();                                                                                                                                                                       
                                                                                }
                                                                                show = val != null && val.toLowerCase().indexOf(t) > -1;
                                                                                cmpp.setHidden(!show); // <3>
                                                                                cmpp.setVisible(show);
                                                                            }
                                                                            System.out.println(val+"/////////////////////"+show);
                                                                            
                                                                        }
                                         
                                                                    } 
                                                                 
                                                                }

                                                            }
                                                        }
                                                    } 
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        } 
                    }
                }
            }
            getContentPane().animateLayout(250);
        });
        getToolbar().addCommandToRightBar("", searchIcon, (e) -> {
            searchField.startEditingAsync(); // <4>
        });




        Container liste = new Container(BoxLayout.y());
        for (Evenement produit : ServiceEvenement.getInstance().getAllEvents()) {
            CelluleEvenement celluleProduit = new CelluleEvenement(produit, theme);
            liste.add(celluleProduit);

        }
        add(liste);

    }

}
