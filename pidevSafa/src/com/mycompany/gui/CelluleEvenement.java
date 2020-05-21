
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.components.ImageViewer;
import com.codename1.components.SpanLabel;
import com.codename1.io.Storage;
import com.codename1.l10n.SimpleDateFormat;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Font;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.mycompany.entites.Evenement;
import com.mycompany.entities.fosUser.Utilisateur;
import com.mycompany.services.ServiceEvenement;
import com.mycompany.services.ServiceReservation;
import com.codename1.io.Util;
import com.codename1.notifications.LocalNotification;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.URLImage;
import com.codename1.ui.util.Resources;
/**
 *
 * @author safa
 */
public class CelluleEvenement extends Form{
    
    Form current;
    java.util.Date dt = new java.util.Date();
    java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
   
             //  EncodedImage enc;
          // URLImage uRLImage;
    public CelluleEvenement(Evenement produit,Resources theme) {
        
        current = this;
              //  uRLImage = URLImage.createToStorage(enc, produit.getImage(), Layout.URL +produit.getImage(), URLImage.RESIZE_SCALE_TO_FILL);

           // ImageViewer imgV = new ImageViewer(uRLImage);
    
        Utilisateur r=new Utilisateur();
           
        Container c0 = new Container(BoxLayout.x());
        Label lbId = new Label("Id : ");
        Label lbId2 = new Label(String.valueOf(produit.getIdEvent()));
        c0.add(lbId);
        c0.add(lbId2);
        c0.setHidden(true);
        
        
        
        Container c9 = new Container(BoxLayout.x());
        Label lbIdu = new Label("Id : ");
        Label lbIdu2 = new Label(String.valueOf(r.getId()));
        c9.add(lbIdu);
        c9.add(lbIdu2);
        c9.setHidden(true);
       
        
        
        Container c1 = new Container(BoxLayout.x());
        Label lbNom = new Label("Nom : ");
        SpanLabel lbNom2 = new SpanLabel(produit.getNom());
        c1.add(lbNom);
        c1.add(lbNom2);
        
        Container c2 = new Container(BoxLayout.x());
        Label lbPrix = new Label("type : ");
        Label lbPrix2 = new Label(String.valueOf(produit.getType()));
        c2.add(lbPrix);
        c2.add(lbPrix2);
        
        
         Container c5 = new Container(BoxLayout.x());
        Label lbDate = new Label("date : ");
        Label lbDate2 = new Label(sdf.format(produit.getDate()));
                
        c5.add(lbDate);
        c5.add(lbDate2);
        Evenement t=new Evenement();
        
               
            Font smallPlainSystemFont = Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_PLAIN, Font.SIZE_SMALL);
             
            
        
        
        
        Container c3 = new Container(BoxLayout.x());
        Label lbIdd = new Label("nbrPlace : ");
        Label lbIdd2 = new Label(String.valueOf(produit.getNbrPlace()));
        //lbId2.setHidden(true);
        c3.add(lbIdd);
        c3.add(lbIdd2);
        
        
        Container c4 = new Container(BoxLayout.x());
        Label lbDress = new Label("type : ");
        Label lbDress2 = new Label(String.valueOf(produit.getDressCode()));
        c4.add(lbDress);
        c4.add(lbDress2);
        
        Container c6 = new Container(BoxLayout.x());
       // Label lbImage = new Label("image : ");
       // Label lbImage2 = new Label(String.valueOf(produit.getImage()));
       // c6.add(lbImage);
            ImageViewer img = new ImageViewer();
            EncodedImage palceHolder = EncodedImage.createFromImage(theme.getImage("log.png"), false);
            URLImage urlImage = URLImage.createToStorage(palceHolder, produit.getImage(), "http://127.0.0.1/PiFOS/Pi/web/images/" + produit.getImage());
                                                                                         
            img.setImage(urlImage);
        c6.add(img);
         
        
        Container c7 = new Container(BoxLayout.y());
        Button btPar = new Button("Participer");
      Button btAvis = new Button("Commentaire");
      Button btPartage = new Button("Partager");
      Button btnstat = new Button("stat");
      Button btndetail= new Button("details");

        c7.addAll(btPar,btAvis,btPartage,btnstat);
     btnstat.addActionListener((evt) -> {new stat().createPieChartForm().show();
        }); 
    btPar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                System.out.println("Participer");
             //   Util.register("utilisateurs", Utilisateur.class);
       // Utilisateur u = (Utilisateur) Storage.getInstance().readObject("utilisateurs");
          

                System.out.println(ServiceReservation.getInstance().dec(Integer.parseInt(lbId2.getText())));
                 LocalNotification ln = new LocalNotification();
            ln.setId("LnMessage");
            ln.setAlertTitle("salut");
            ln.setAlertBody("merci d'aariver à Caritas!");
          Display.getInstance().scheduleLocalNotification( ln,
                System.currentTimeMillis() + 10 * 10, // fire date/time
                LocalNotification.REPEAT_MINUTE  // Whether to repeat and what frequency);
          );
                Dialog.show("Succès", "Votre reservation est effectuee", "Ok", null); 
   
               new ListEventsForm(theme).show();
            }
        });
         btAvis.addActionListener(e-> new AvisForm(current).show());
        
        
         btAvis.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                        btAvis.addActionListener(e-> new AvisForm(current).show());
                new AvisForm(Integer.parseInt(lbId2.getText())).show();

            }
        });
         
         
        
          btndetail.addActionListener(e-> new detailForm(current).show());
        
        
         btndetail.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                        btndetail.addActionListener(e-> new detailForm(current).show());
                new detailForm(current).show();

            }
        });
         
         
         
         
        
        btPartage.addActionListener((evt) -> {
            Display.getInstance().execute("https://www.facebook.com/sharer/sharer.php?u="+
                  "http://127.0.0.1/PiFOS/Pi/web/app_dev.php/Detail/" + produit.getIdEvent());

        });

        
       
        
        Container c_f = new Container(BoxLayout.y());
        Container c1f = new Container(new BoxLayout(BoxLayout.X_AXIS), "Container*");
        c_f.addAll(c0,c1, c2, c5,c3,c4,c7);
        c1f.add(c6);
        c1f.add(c_f);
        
        add(c1f);
    }

  
    
    
   
    
    
}




