

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gui;

import com.codename1.capture.Capture;
import com.codename1.components.MultiButton;
import com.codename1.io.FileSystemStorage;
import com.codename1.io.Log;
import com.codename1.io.Util;
import com.codename1.l10n.SimpleDateFormat;
import com.codename1.media.Media;
import com.codename1.media.MediaManager;
import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.Font;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.Slider;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.geom.Dimension;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.plaf.Border;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.plaf.UIManager;
import com.mycompany.entites.Avis;
import com.mycompany.entites.Evenement;
import com.mycompany.entites.Parent;
import com.mycompany.services.ServiceAvis;
import com.mycompany.services.ServiceEvenement;
import com.mycompany.services.ServiceParent;
import java.io.IOException;
import java.util.Date;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

/**
 *
 * @author safa
 */
    public class AvisForm extends Form {

    Form current;
    
    Integer idEvent;

    public AvisForm() {
    }

 
    public Integer getIdEvent() {
        return idEvent;
    }

    public void setIdEvent(Integer idEvent) {
        this.idEvent = idEvent;
    }
     double r=0;
    
     
     
     
     
     
     
     
     
     
     
     
     
    Slider starRank = new Slider();
     Avis t= new Avis();
    public AvisForm(int id) {
    Container c9 = new Container(BoxLayout.y());
     
 Form hi = new Form("Capture", BoxLayout.y());
hi.setToolbar(new Toolbar());
Style s = UIManager.getInstance().getComponentStyle("Title");
FontImage icon = FontImage.createMaterial(FontImage.MATERIAL_MIC, s);

FileSystemStorage fs = FileSystemStorage.getInstance();
String recordingsDir = fs.getAppHomePath() + "recordings/";
fs.mkdir(recordingsDir);
try {
    for(String file : fs.listFiles(recordingsDir)) {
        MultiButton mb = new MultiButton(file.substring(file.lastIndexOf("/") + 1));
        mb.addActionListener((e) -> {
            try {
                Media m = MediaManager.createMedia(recordingsDir + file, false);
                m.play();
            } catch(IOException err) {
                Log.e(err);
            }
        });
        hi.add(mb);
    }

    hi.getToolbar().addCommandToRightBar("", icon, (ev) -> {
        try {
            String file = Capture.captureAudio();
            if(file != null) {
                SimpleDateFormat sd = new SimpleDateFormat("yyyy-MMM-dd-kk-mm");
                String fileName =sd.format(new Date());
                String filePath = recordingsDir + fileName;
                Util.copy(fs.openInputStream(file), fs.openOutputStream(filePath));
                MultiButton mb = new MultiButton(fileName);
                mb.addActionListener((e) -> {
                    try {
                        Media m = MediaManager.createMedia(filePath, false);
                        m.play();
                    } catch(IOException err) {
                        Log.e(err);
                    }
                });
                hi.add(mb);
                hi.revalidate();
            }
        } catch(IOException err) {
            Log.e(err);
        }
    });
} catch(IOException err) {
    Log.e(err);
}
//hi.show();
       
       
         
        c9.add(hi);
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
      //  Slider starRank = new Slider();
        current = this;
        Avis a=new Avis();      
        Evenement b=new Evenement();
        
       Container c0 = new Container(BoxLayout.x());
        Label lbId = new Label("Id : ");
        Label lbId2 = new Label(String.valueOf(a.getNomUser()));
        c0.add(lbId);
        c0.add(lbId2);
        
        
        
        
        Container c1 = new Container(BoxLayout.x());
        Label lbMail = new Label("Description : ");
        TextField txMail = new TextField("", "description");
        c1.add(lbMail);
        c1.add(txMail);
    Container c_f = new Container(BoxLayout.y());
     
     
     
    Container c7 = new Container(BoxLayout.x());
      Button btAvis = new Button("ajouter");

        c7.addAll(btAvis);
        //c9.addAll(hi);
        c_f.addAll(c1,c7,hi);
                Slider slider = createStarRankSlider();

    btAvis.addActionListener(new ActionListener() {
           @Override
            public void actionPerformed(ActionEvent evt) {
                System.out.println("begin add avis");
                Avis a = new Avis();
                a.setDescription(txMail.getText());
               // a.getIdEvent();
                a.setRating(slider.getProgress());
                 boolean idA = ServiceAvis.getInstance().avis(a,id);
               //ServiceAvis.getInstance().avis(idA);
                        btAvis.addActionListener(e-> new ListAvisForm(current).show());
                     new ListAvisForm().show();
                //ServiceEvenement.getInstance().createCommande(idAdresse);
                System.out.println("end add adresse");
                
            }
        });
   //    add(c_f);
           

   
   //c_f.add(hi);
     c_f.add(FlowLayout.encloseCenter(createStarRankSlider()));     

                //    container6.add(FlowLayout.encloseCenter(slider));

   
   /*btAvis.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
               
                if ((txMail.getText().length()==0))
                    Dialog.show("Alert", "Please fill all the fields", new Command("OK"));
                else
                {
                    try {
                        //DossierMedical d = new DossierMedical();
                                              
                        if( ServiceAvis.getInstance().avis(t,idEvent)){
                            Dialog.show("Success","Connection accepted",new Command("OK"));
                            //new ListEnfantForm().show();
                        }
                                
                        else
                            Dialog.show("ERROR", "Server error", new Command("OK"));
                    } catch (NumberFormatException e) {
                        Dialog.show("ERROR", "telephone must be a number", new Command("OK"));
                    }
                    
                }
                
                
            }
        }); 
    
   */
   

   
  
    starRank.addActionListener(
        e->{Dialog.show("Evaluation ", "Merci d'evaluer notre event", "OK", "Annuler");
         System.out.println(starRank.getProgress());
            r=starRank.getProgress() ;
            System.out.println("aaa"+r);
           });
 
 
 

      
    
    add(c_f);
    

    
    
    
    }
    

    
    private void initStarRankStyle(Style s, Image star) {
    s.setBackgroundType(Style.BACKGROUND_IMAGE_TILE_BOTH);
    s.setBorder(Border.createEmpty());
    s.setBgImage(star);
    s.setBgTransparency(0);
}

private Slider createStarRankSlider() {
    
    starRank.setEditable(true);
    starRank.setMinValue(0);
    starRank.setMaxValue(5);
    Font fnt = Font.createTrueTypeFont("native:MainLight", "native:MainLight").
            derive(Display.getInstance().convertToPixels(5, true), Font.STYLE_PLAIN);
    Style s = new Style(0xffff33, 0, fnt, (byte)0);
    Image fullStar = FontImage.createMaterial(FontImage.MATERIAL_STAR, s).toImage();
    s.setOpacity(100);
    s.setFgColor(0);
    Image emptyStar = FontImage.createMaterial(FontImage.MATERIAL_STAR, s).toImage();
    initStarRankStyle(starRank.getSliderEmptySelectedStyle(), emptyStar);
    initStarRankStyle(starRank.getSliderEmptyUnselectedStyle(), emptyStar);
    initStarRankStyle(starRank.getSliderFullSelectedStyle(), fullStar);
    initStarRankStyle(starRank.getSliderFullUnselectedStyle(), fullStar);
    starRank.setPreferredSize(new Dimension(fullStar.getWidth() * 5, fullStar.getHeight()));
    return starRank;
}

    AvisForm(Form current) {
   
    }
 
     
    

}


