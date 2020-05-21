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
import com.mycompany.entites.Avis;
import com.mycompany.entites.Evenement;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
/**
 *
 * @author safa
 */
public class ServiceEvenement {
   public ArrayList<Evenement> events;
    public static ServiceEvenement instance=null;
    public boolean resultOK;
    private ConnectionRequest connectionRequest;
    
    public ServiceEvenement() {
         connectionRequest = new ConnectionRequest();
    }
    
    public static ServiceEvenement getInstance() {
        if (instance == null) {
            instance = new ServiceEvenement();
        }
        return instance;
    }
     public ArrayList<Evenement> parseEvents(String jsonText){
        try {
            events=new ArrayList<>();
            JSONParser j = new JSONParser();
            Map<String,Object> tasksListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));

            List<Map<String,Object>> list = (List<Map<String,Object>>)tasksListJson.get("root");
            for(Map<String,Object> obj : list){
                Evenement produit = new Evenement();
    // java.util.Date dateeve = new Date(produit.getDate().getTime());

                float id = Float.parseFloat(obj.get("idEvent").toString());
                produit.setIdEvent((int)id);
                produit.setNom(obj.get("nom").toString());
              produit.setType(obj.get("type").toString());
              // produit.setDate((Date)dateeve);
               Map<String, Object> date2  = (Map<String, Object>) obj.get("date");
                 float da = Float.parseFloat(date2.get("timestamp").toString());
                 Date d = new Date((long)(da-3600 )*1000);
                 produit.setDate(d);

                 //produit.setDate(new Date((((Double) ((Map<String, Object>) obj.get("date")).get("timestamp")).longValue() * 1000)));          
// java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
                // sdf.format(produit.getDate());
              
                 produit.setNbrPlace(((int)Float.parseFloat(obj.get("nbrPlace").toString())));

                produit.setDressCode(obj.get("dressCode").toString());
                produit.setImage(obj.get("image").toString());

                
                events.add(produit);
            }
            
            
        } catch (IOException ex) {
            
        }
        return events;
    }
      public ArrayList<Evenement> getAllEvents(){
        String url = "http://127.0.0.1/PiFOS/Pi/web/app_dev.php/readFM";
        connectionRequest.setUrl(url);
        connectionRequest.setPost(false);
        connectionRequest.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                events = parseEvents(new String(connectionRequest.getResponseData()));
                connectionRequest.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(connectionRequest);
        return events;
    }
    
      public ArrayList<Evenement> detail(int id){
        String url = "http://127.0.0.1/PiFOS/Pi/web/app_dev.php/DetailM/" +id;
        connectionRequest.setUrl(url);
        connectionRequest.setPost(false);
        connectionRequest.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                events = parseEvents(new String(connectionRequest.getResponseData()));
                connectionRequest.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(connectionRequest);
        return events;
    }
    
      
      
      
      
  /*public int addParent(Parent adresse) {
        String url = "http://127.0.0.1/Pi/web/app_dev.php/ajoutUM?nom="+adresse.getNom()+"&prenom="+adresse.getPrenom()+"&email="+adresse.getEmail()+"&mdp="+adresse.getMdp()+"&tel="+adresse.getTel();

        connectionRequest.setUrl(url);
        connectionRequest.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                resultOK = connectionRequest.getResponseCode() == 200; //Code HTTP 200 OK
                parents = parseParents(new String(connectionRequest.getResponseData()));
                for (Parent adresse1 : parents) {
                    System.out.println(adresse1);
                }
                connectionRequest.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(connectionRequest);
        return parents.get(0).getId();
    } 
   */
 
      
      
      
      
      
      
       public ArrayList<Evenement> getListTask(String json) {

        ArrayList<Evenement> listEtudiants = new ArrayList<>();

        try {
            System.out.println(json);
            JSONParser j = new JSONParser();

            Map<String, Object> etudiants = j.parseJSON(new CharArrayReader(json.toCharArray()));
            System.out.println(etudiants);
           
            List<Map<String, Object>> list = (List<Map<String, Object>>) etudiants.get("root");

            for (Map<String, Object> obj : list) {
                

             
                                       Evenement p = new Evenement();
                        //float idEvent = Float.parseFloat(event.get("id").toString());
                float id = Float.parseFloat(obj.get("idPublication").toString());
                 //float idutilisateur=Float.parseFloat(((LinkedHashMap)obj.get("idutilisateur")).get("id").toString());
                //float idutilisateur = Float.parseFloat(obj.get("idutilisateur").toString());
                String nom = obj.get("nom").toString();
                 String type = obj.get("type").toString();
                 String nbrPlace = obj.get("nbrPlace").toString();
             String image = obj.get("image").toString();
                Map<String, Object> date  = (Map<String, Object>) obj.get("dateP");
                 float da = Float.parseFloat(date.get("timestamp").toString());
                 Date d = new Date((long)(da-3600 )*1000);
                 
           
                       // p.setIdutilisateur((int) idutilisateur);
                       p.setType(type);
                       p.setImage(image);
                       p.setNom(nom);
                        //p.setNbrPlace(nbrPlace.toString());
                        p.setIdEvent((int)id);
                         p.setDate(d);
                         System.out.println(p);
                listEtudiants.add(p);

            }

        } catch (IOException ex) {
        }
        System.out.println(listEtudiants);
        return listEtudiants;

    }
      
      
      
      
      
      
       public boolean dec(int id) {
        String url = "http://127.0.0.1/Pi/web/app_dev.php/reserverMobile/" + id;
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
    
      
      
     public boolean avis(int id) {
        String url = "http://127.0.0.1/Pi/web/app_dev.php/avisMobile/" + id ;
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
      
      
      
      
    public boolean avis(Avis a,int idEvent) {
        String url = "http://127.0.0.1/Pi/web/app_dev.php/avisMobile/"+idEvent+"?description="+a.getDescription() ;
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
   
  String response;

    public int nbLike(String id) {

        ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://127.0.0.1/PiFOS/Pi/web/app_dev.php/b/" + id);
        con.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                response = new String(con.getResponseData());
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        return Integer.parseInt(response);
    }
    
}
