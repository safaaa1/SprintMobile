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
import com.mycompany.entites.Parent;
import com.mycompany.services.ServiceParent;

/**
 *
 * @author safa
 */

public class CelluleParent extends Form{
    
    Form current;

    public CelluleParent(Parent parent) {
        
        current = this;
        
        
        
        
        
        
        
        Container c2 = new Container(BoxLayout.x());
        Label lbNom = new Label("Nom : ");
        Label lbNom2 = new Label(parent.getNom());
        c2.add(lbNom);
        c2.add(lbNom2);
        
        
        
        Container c3 = new Container(BoxLayout.x());
        Label lbPrenom = new Label("prenom : ");
        Label lbPrenom2 = new Label(parent.getPrenom());
        c3.add(lbPrenom);
        c3.add(lbPrenom2);
        
        Container c4 = new Container(BoxLayout.x());
        Label lbEmail = new Label("email : ");
        Label lbEmail2 = new Label(parent.getEmail());
        c4.add(lbEmail);
        c4.add(lbEmail2);
        
        
         
        Container c5 = new Container(BoxLayout.x());
        TextField lbMdp = new TextField("mdp : ");
        TextField lbMdp2 = new TextField(parent.getMdp());
   lbMdp2.setConstraint(lbMdp2.PASSWORD);

        c5.add(lbMdp);
        c5.add(lbMdp2);
        
        Container c6 = new Container(BoxLayout.x());
        Label lbTel = new Label("tel : ");
        Label lbTel2 = new Label(String.valueOf(parent.getTel()));
        c6.add(lbTel);
        c6.add(lbTel2);
        
        Container c1 = new Container(BoxLayout.x());
        Label lbId = new Label("Id : ");
        Label lbId2 = new Label(String.valueOf(parent.getId()));
        //lbId2.setHidden(true);
        c1.add(lbId);
        c1.add(lbId2);
       Container c7 = new Container(BoxLayout.x());
        Button btSupprimer = new Button("Supprimer");
            Button btValider = new Button("Add parent");
        btValider.addActionListener(e-> new AjoutParentForm(current).show());

               c7.addAll(btSupprimer,btValider);
                   
  btSupprimer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                System.out.println("supp");
                System.out.println(ServiceParent.getInstance().delete(Integer.parseInt(lbId2.getText())));
                new ListParentForm().show();
            }
        });
   btValider.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                System.out.println("ajout");
                System.out.println(ServiceParent.getInstance().delete(Integer.parseInt(lbId2.getText())));
                new AjoutParentForm().show();
            }
        });
  
  
  
  
  
  
  
  
  
        Container c_f = new Container(BoxLayout.y());
        c_f.addAll(c3,c4,c5,c6,c7);
        
        
        add(c_f);
    }
    
    
    
}
