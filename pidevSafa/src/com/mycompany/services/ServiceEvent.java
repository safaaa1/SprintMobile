/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.services;
import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;
import com.mycompany.entites.Evenement;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 *
 * @author yanisinfo
 */
public class ServiceEvent {
        public ArrayList<Evenement> evenements;
    public static ServiceEvent instance=null;
    public boolean resultOK;
    private ConnectionRequest connectionRequest;
    
    private ServiceEvent() {
         connectionRequest = new ConnectionRequest();
    }
    
    public static ServiceEvent getInstance() {
        if (instance == null) {
            instance = new ServiceEvent();
        }
        return instance;
    }
    
        public ArrayList<Evenement> parseEvenements(String jsonText){
        try {
            evenements=new ArrayList<>();
            JSONParser j = new JSONParser();
            Map<String,Object> tasksListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
            
            List<Map<String,Object>> list = (List<Map<String,Object>>)tasksListJson.get("root");
            for(Map<String,Object> obj : list){
                Evenement evenement = new Evenement();
                float id = Float.parseFloat(obj.get("id").toString());
                evenement.setIdEvent((int)id);
                evenement.setNom(obj.get("nom").toString());
                evenement.setType(obj.get("type").toString());
                
                evenement.setDressCode(obj.get("dresscode").toString());
                evenement.setNbrPlace(((int)Float.parseFloat(obj.get("nbrPlace").toString())));
                evenements.add(evenement);
            }
            
            
        } catch (IOException ex) {
            
        }
        return evenements;
    }
        
            public ArrayList<Evenement> getAllEvents(){
        String url = "http://127.0.0.1/Pi/web/app_dev.php/read";
        connectionRequest.setUrl(url);
        connectionRequest.setPost(false);
        connectionRequest.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                evenements = parseEvenements(new String(connectionRequest.getResponseData()));
                connectionRequest.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(connectionRequest);
        return evenements;
    }
}
