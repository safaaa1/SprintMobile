/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.services;

import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;
import com.mycompany.entites.Evenement;
import com.mycompany.entites.Reservation;
import com.mycompany.myapp.MyApplication;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 *
 * @author safa
 */
public class ServiceReservation {
  public ArrayList<Reservation> reservations;
    public static ServiceReservation instance=null;
    public boolean resultOK;
    private ConnectionRequest connectionRequest;
    Integer idEvent;

    
    
    private ServiceReservation() {
         connectionRequest = new ConnectionRequest();
    }
    
    public static ServiceReservation getInstance() {
        if (instance == null) {
            instance = new ServiceReservation();
        }
        return instance;
    }  
    
    
    
    
     public ArrayList<Reservation> parseReservations(String jsonText){
        try {
            reservations=new ArrayList<>();
            JSONParser j = new JSONParser();
            Map<String,Object> tasksListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
            List<Map<String,Object>> list = (List<Map<String,Object>>)tasksListJson.get("root");
            for(Map<String,Object> obj : list){
                Reservation enfant = new Reservation();
                
                 float id = Float.parseFloat(obj.get("idReser").toString());
                //float id_dossier = Float.parseFloat(obj.get("id_dossier").toString());
                enfant.setIdReser((int)id);
                //enfant.setId(((int)Float.parseFloat(obj.get("id").toString())));
               enfant.setEtat(obj.get("etat").toString());
               //enfant.setAge(((int)Float.parseFloat(obj.get("age").toString())));
                          //  enfant.setId_dossier((int)(id_dossier));
                          //if ((txNom.getText().length()==0)||(txAge.getText().length()==0))
                    if ((obj.get("evenement")!=null)){
                         //if ((obj.get("utilisateurs")!=null)){ 
                         Map<String,Object> obj2= (Map<String,Object>) obj.get("evenement");
                              //  enfant.setIdEvent(((int)Float.parseFloat(obj2.get("idEvent").toString())));
                                enfant.setNom(obj2.get("nom").toString());
                      //   Map<String,Object> obj3= (Map<String,Object>) obj.get("utilisateurs");
                           //    enfant.setNomUser(obj3.get("nomUser").toString());

                    }
                    else{
                    enfant.setNom("pas d event");
                                       // enfant.setNomUser("pas de user");

                    }
              if (obj.get("utilisateur")!=null){
                         Map<String,Object> obj3= (Map<String,Object>) obj.get("utilisateur");
                              //  enfant.setIdEvent(((int)Float.parseFloat(obj2.get("idEvent").toString())));
                                enfant.setNomUser(obj3.get("username").toString());

                    }
                    else{
                    enfant.setNom("pas d event");
                    }
                reservations.add(enfant);
            }
            
            
            
        } catch (IOException ex) {
            
        }
        return reservations;
    }
    
     
    public ArrayList<Reservation> getAllReservations(){
        String url = "http://127.0.0.1/PiFOS/Pi/web/app_dev.php/reservationM";
        connectionRequest.setUrl(url);
        connectionRequest.setPost(false);
        connectionRequest.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                reservations = parseReservations(new String(connectionRequest.getResponseData()));
                
                connectionRequest.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(connectionRequest);
        /*for (Panier panier : paniers) {
            System.out.println("--"+panier);
        }*/
        return reservations;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
  
     
     
     
     
     
     
     
  public boolean valider(int id) {
        String url = "http://127.0.0.1/PiFOS/Pi/web/app_dev.php/validerM/" + id ;
        connectionRequest.setUrl(url);
        connectionRequest.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                resultOK = connectionRequest.getResponseCode() == 200; //Code HTTP 200 OK
                connectionRequest.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(connectionRequest);
        return resultOK;
    }
         
     
      public boolean annuler(int id) {
        String url = "http://127.0.0.1/PiFOS/Pi/web/app_dev.php/annulerM/" + id ;
        connectionRequest.setUrl(url);
        connectionRequest.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                resultOK = connectionRequest.getResponseCode() == 200; //Code HTTP 200 OK
                connectionRequest.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(connectionRequest);
        return resultOK;
    }
         
     
     
     public boolean dec(int id) {
        String url = "http://127.0.0.1/PiFOS/Pi/web/app_dev.php/reserverMobile/"+id+"/"+userService.ti.getId()  ;
        connectionRequest.setUrl(url);
        connectionRequest.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                resultOK = connectionRequest.getResponseCode() == 200; //Code HTTP 200 OK
                connectionRequest.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(connectionRequest);
        return resultOK;
    }
     
     
   
      
}
