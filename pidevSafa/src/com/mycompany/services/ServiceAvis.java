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
import com.mycompany.entites.Avis;
import com.mycompany.entites.Evenement;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 *
 * @author safa
 */
public class ServiceAvis {
  public ArrayList<Avis> events;
    public static ServiceAvis instance=null;
    public boolean resultOK;
    private ConnectionRequest connectionRequest;
    Integer idEvent;

    public Integer getIdEvent() {
        return idEvent;
    }

    public void setIdEvent(Integer idEvent) {
        this.idEvent = idEvent;
    }
    
    
    public ServiceAvis() {
         connectionRequest = new ConnectionRequest();
    }
    
    public static ServiceAvis getInstance() {
        if (instance == null) {
            instance = new ServiceAvis();
        }
        return instance;
    }  
    
    
    
    
     public ArrayList<Avis> parseEnfants(String jsonText){
        try {
            events=new ArrayList<>();
            JSONParser j = new JSONParser();
            Map<String,Object> tasksListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
            List<Map<String,Object>> list = (List<Map<String,Object>>)tasksListJson.get("root");
            for(Map<String,Object> obj : list){
                Avis enfant = new Avis();
                
                 float id = Float.parseFloat(obj.get("idAvis").toString());
                //float id_dossier = Float.parseFloat(obj.get("id_dossier").toString());
                enfant.setIdAvis((int)id);
                //enfant.setId(((int)Float.parseFloat(obj.get("id").toString())));
               enfant.setDescription(obj.get("description").toString());
               //enfant.setAge(((int)Float.parseFloat(obj.get("age").toString())));
                          //  enfant.setId_dossier((int)(id_dossier));
                    if (obj.get("evenement")!=null){
                         Map<String,Object> obj2= (Map<String,Object>) obj.get("evenement");
                              //  enfant.setIdEvent(((int)Float.parseFloat(obj2.get("idEvent").toString())));
                                enfant.setNom(obj2.get("nom").toString());

                    }
                    else{
                    enfant.setNom("pas d event");
                    }
                    
                    if (obj.get("utilisateur")!=null){
                         Map<String,Object> obj3= (Map<String,Object>) obj.get("utilisateur");
                              //  enfant.setIdEvent(((int)Float.parseFloat(obj2.get("idEvent").toString())));
                                enfant.setNomUser(obj3.get("username").toString());

                    }
                    else{
                    enfant.setNom("pas d event");
                    }
                    
              
                events.add(enfant);
            }
            
            
            
        } catch (IOException ex) {
            
        }
        return events;
    }
    
     
    public ArrayList<Avis> getAllAvis(){
        String url = "http://127.0.0.1/PiFOS/Pi/web/app_dev.php/affM";
        connectionRequest.setUrl(url);
        connectionRequest.setPost(false);
        connectionRequest.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                events = parseEnfants(new String(connectionRequest.getResponseData()));
                
                connectionRequest.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(connectionRequest);
        /*for (Panier panier : paniers) {
            System.out.println("--"+panier);
        }*/
        return events;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    //($request->get('rating'))
    
     public boolean avis(Avis a,int idEvent) {
         System.out.println(a);
        String url = "http://127.0.0.1/PiFOS/Pi/web/app_dev.php/avisMobile/"+idEvent+"/"+userService.ti.getId()+"?description="+a.getDescription()+"&rating="+a.getRating();
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
