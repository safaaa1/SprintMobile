/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.layouts.BoxLayout;
import com.mycompany.entites.Parent;
import com.mycompany.services.ServiceParent;

/**
 *
 * @author safa
 */
public class ListParentForm extends Form{
    
    Form current;
    Form f;

    public ListParentForm() {
        current = this;
         f = new Form();
        Container liste = new Container(BoxLayout.y());
        for (Parent parentt : ServiceParent.getInstance().getAllParents()) {
            CelluleParent celluleProduit = new CelluleParent(parentt);
            liste.add(celluleProduit);
        }
        
        add(liste);
    }

    ListParentForm(Form current) {
    }

    public Form getCurrent() {
        return current;
    }

    public void setCurrent(Form current) {
        this.current = current;
    }

   
   public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    } 
}
