/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui.login;

import com.codename1.components.ImageViewer;
import com.codename1.ui.Button;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Display;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.Stroke;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.plaf.RoundRectBorder;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.util.UIBuilder;
//import com.mycompany.entites.Enseignant;
import com.mycompany.entites.Evenement;
import com.mycompany.myapp.MyApplication;
//import static com.mycompany.myapp.MyApplication.theme;
//import static com.mycompany.myapp.MyApplication.theme;
//import com.mycompany.myapp.gui.front.annonce;
//import com.mycompany.myapp.gui.front.ecommerce;
//import com.mycompany.myapp.gui.front.event;
//import com.mycompany.myapp.gui.front.menuevent;
//import com.mycompany.myapp.gui.front.profil;
//import com.mycompany.myapp.gui.front.reclamation;

/**
 *
 * @author hazem
 */
public class acceuil extends Form {
    Form current;
    
    
     public acceuil(Form previous)
     {
     current=this;
        setTitle("Acceuil");
        setLayout(BoxLayout.y());
Style loginStyle= getAllStyles();


  //loginStyle.setBgImage(MyApplication.theme.getImage("is.jpg"));
  /**************************************************************************************************/       

//ImageViewer Logo=new ImageViewer(MyApplication.theme.getImage("logohunt.png"));

  /**************************************************************************************************/ 
   Button btnval = new Button("Enseignant");
Style butStyle=btnval.getAllStyles();
butStyle.setBorder(RoundRectBorder.create().
        strokeColor(0xCD853F).
        strokeOpacity(120)
        );
butStyle.setBgColor(0xCD853F);
butStyle.setFgColor(0x000000);
butStyle.setBgTransparency(255);
butStyle.setMarginUnit(Style.UNIT_TYPE_DIPS);
butStyle.setMargin(Component.BOTTOM, 3);       

          butStyle.setMargin(Component.TOP,10);  
              
          
          butStyle.setMargin(Component.LEFT,10);  
           butStyle.setMargin(Component.RIGHT,10); 
 /**************************************************************************************************/        
    Button btnval1 = new Button("Evenement");
Style butStyle1=btnval1.getAllStyles();
butStyle1.setBorder(RoundRectBorder.create().
        strokeColor(0xCD853F).
        strokeOpacity(120)
        );
butStyle1.setBgColor(0xCD853F);
butStyle1.setFgColor(0x000000);
butStyle1.setBgTransparency(255);
butStyle1.setMarginUnit(Style.UNIT_TYPE_DIPS);
butStyle1.setMargin(Component.BOTTOM, 3);       

          butStyle1.setMargin(Component.TOP,1);  
              
          
          butStyle1.setMargin(Component.LEFT,10);  
           butStyle1.setMargin(Component.RIGHT,10); 
     /**************************************************************************************************/ 
               Button btnval2 = new Button("Medecin");
Style butStyle2=btnval2.getAllStyles();
butStyle2.setBorder(RoundRectBorder.create().
        strokeColor(0xCD853F).
        strokeOpacity(120)
        );
butStyle2.setBgColor(0xCD853F);
butStyle2.setFgColor(0x000000);
butStyle2.setBgTransparency(255);
butStyle2.setMarginUnit(Style.UNIT_TYPE_DIPS);
butStyle2.setMargin(Component.BOTTOM, 3);       

          butStyle2.setMargin(Component.TOP,1);  
              
          
          butStyle2.setMargin(Component.LEFT,10);  
           butStyle2.setMargin(Component.RIGHT,10);
    /**************************************************************************************************/ 
        Button btnval3 = new Button("Reclamation");
Style butStyle3=btnval3.getAllStyles();
butStyle3.setBorder(RoundRectBorder.create().
        strokeColor(0xCD853F).
        strokeOpacity(120)
        );
butStyle3.setBgColor(0xCD853F);
butStyle3.setFgColor(0x000000);
butStyle3.setBgTransparency(255);
butStyle3.setMarginUnit(Style.UNIT_TYPE_DIPS);
butStyle3.setMargin(Component.BOTTOM, 3);       

          butStyle3.setMargin(Component.TOP,1);  
              
          
          butStyle3.setMargin(Component.LEFT,10);  
           butStyle3.setMargin(Component.RIGHT,10); 
    /**************************************************************************************************/ 
               Button btnval4 = new Button("Classe");
Style butStyle4=btnval4.getAllStyles();
butStyle4.setBorder(RoundRectBorder.create().
        strokeColor(0xCD853F).
        strokeOpacity(120)
        );
butStyle4.setBgColor(0xCD853F);
butStyle4.setFgColor(0x000000);
butStyle4.setBgTransparency(255);
butStyle4.setMarginUnit(Style.UNIT_TYPE_DIPS);
butStyle4.setMargin(Component.BOTTOM, 3);       

          butStyle4.setMargin(Component.TOP,1);  
              
          
          butStyle4.setMargin(Component.LEFT,10);  
           butStyle4.setMargin(Component.RIGHT,10);
             /**************************************************************************************************/ 
           Button btnval5 = new Button("Deconnexion");
Style butStyle5=btnval5.getAllStyles();
butStyle5.setBorder(RoundRectBorder.create().
        strokeColor(0xCD853F).
        strokeOpacity(120)
        );
butStyle5.setBgColor(0xCD853F);
butStyle5.setFgColor(0x000000);
butStyle5.setBgTransparency(255);
butStyle5.setMarginUnit(Style.UNIT_TYPE_DIPS);
butStyle5.setMargin(Component.BOTTOM, 3);       

          butStyle5.setMargin(Component.TOP,1);  
              
          
          butStyle5.setMargin(Component.LEFT,10);  
           butStyle5.setMargin(Component.RIGHT,10); 
      /**************************************************************************************************/        
               addAll(btnval,btnval1,btnval2,btnval3,btnval4,btnval5);
               
  /**************************************************************************************************/             
               
             /*  btnval.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
               new Enseignant(current).show(); 
            }
               });
               btnval1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
               new Evenement(current).show(); 
            }
               });
               btnval2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
               new Medecin(current).show(); 
            }
               });
               btnval3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
               new reclamation(current).show(); 
            }
               });
               btnval4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
               new classe(current).show(); 
            }
               });
                 btnval5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
               new login().show();
            }
               });
               
/**************************************************/
               
               
                        //Container cnt1=new Container(new FlowLayout(Container.CENTER));

                       // add(Logo3);
               
                getToolbar().addCommandToOverflowMenu("Exit",
            null, ev->{Display.getInstance().exitApplication();});
        
          
          
          
          
          

     }
}

