/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.notifications.LocalNotification;
import com.codename1.notifications.LocalNotificationCallback;
import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.Slider;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.RoundRectBorder;
import com.codename1.ui.plaf.Style;
import com.mycompany.entites.Parent;
import com.mycompany.services.ServiceParent;

/**
 *
 * @author Mohamed
 */
public class AjoutParentForm extends Form {
    
    Form current;
    
    
    
    
    
    public AjoutParentForm()  {
        
        current = this;
           LocalNotification n = new LocalNotification();
        n.setId("demo-notification");
        n.setAlertBody("It's time to take a break and look at me");
        n.setAlertTitle("Break Time!");
        Display.getInstance().scheduleLocalNotification(
                n,
                System.currentTimeMillis() + 10 * 1000, // fire date/time
                LocalNotification.REPEAT_MINUTE // Whether to repeat and what frequency
        ); 
        
        Container c1 = new Container(BoxLayout.x());
        Label lbMail = new Label("Nom : ");
        TextField txMail = new TextField("", "nom");
        c1.add(lbMail);
        c1.add(txMail);
        
        Container c2 = new Container(BoxLayout.x());
        Label lbPays = new Label("prenom : ");
        TextField txPays = new TextField("", "prenom");
        c2.add(lbPays);
        c2.add(txPays);
        
        Container c3 = new Container(BoxLayout.x());
        Label lbVille = new Label("email : ");
        TextField txVille = new TextField("", "email");
        c3.add(lbVille);
        c3.add(txVille);
        
         Slider starRank = new Slider();
        starRank.setEditable(true);
        starRank.setMinValue(0);
        starRank.setMaxValue(10);
        

        
        
        Container c4 = new Container(BoxLayout.x());
        Label lbPin = new Label("mdp : ");
        TextField txPin = new TextField("", "mdp");
        c4.add(lbPin);
        c4.add(txPin);
        
        
        
         Container c5 = new Container(BoxLayout.x());
        Label lbNumTel = new Label("Num tel : ");
        TextField txNumTel = new TextField("", "num tel");
        c5.add(lbNumTel);
        c5.add(txNumTel);
        
        
        
        Container c_f = new Container(BoxLayout.y());
        c_f.addAll(c1, c2, c3, c4,c5,starRank);
        
        
        
        
        
        
        
        
        
        
        Button btValider = new Button("Valider");
                btValider.addActionListener(e-> new ListParentForm(current).show());
               
                btValider.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                if ((txMail.getText().length()==0)||(txPays.getText().length()==0))
                    Dialog.show("Alert", "Please fill all the fields", new Command("OK"));
                else
                {
                    try {
                        Parent t = new Parent(txMail.getText(),txPays.getText(),  txVille.getText(), txPin.getText(), Integer.parseInt(txNumTel.getText()));
                        if( ServiceParent.getInstance().createMedecin(t)){
                            
                       
                            
                            Dialog.show("Success","Connection accepted",new Command("OK"));
                                        btValider.addActionListener(e-> new ListParentForm(current).show());
                                                        new ListParentForm().show();

                        }
                        else
                            Dialog.show("ERROR", "Server error", new Command("OK"));
                    } catch (NumberFormatException e) {
                        Dialog.show("ERROR", "Status must be a number", new Command("OK"));
                    }
                    
                }
                
                
            }
        });




        /*btValider.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                System.out.println("begin add adresse");
                Parent adresse = new Parent();
               adresse.setMdp(txPin.getText());

                adresse.setEmail(txVille.getText());
                adresse.setNom(txMail.getText());
                adresse.setPrenom(txPays.getText());
                adresse.setTel(Integer.parseInt(txNumTel.getText()));
                int idAdresse = ServiceParent.getInstance().addParent(adresse);
                //ServiceParent.getInstance().addParent(idAdresse);
                System.out.println("end add adresse");
                        btValider.addActionListener(e-> new ListParentForm(current).show());

            }
        });*/
        c_f.add(btValider);
        
        add(c_f);
       
        
    }

    AjoutParentForm(Form current) {
    }
    
}
