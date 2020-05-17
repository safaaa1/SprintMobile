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
import com.mycompany.entites.Parent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author safa
 */
public class ServiceParent {
   public ArrayList<Parent> parents;
    public static ServiceParent instance=null;
    public boolean resultOK;
    private ConnectionRequest connectionRequest;
    
    public ServiceParent() {
         connectionRequest = new ConnectionRequest();
    }
    
    public static ServiceParent getInstance() {
        if (instance == null) {
            instance = new ServiceParent();
        }
        return instance;
    }
     public ArrayList<Parent> parseParents(String jsonText){
        try {
            parents=new ArrayList<>();
            JSONParser j = new JSONParser();
            Map<String,Object> tasksListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
            
            List<Map<String,Object>> list = (List<Map<String,Object>>)tasksListJson.get("root");
            for(Map<String,Object> obj : list){
                Parent produit = new Parent();
                float id = Float.parseFloat(obj.get("id").toString());
                produit.setId((int)id);
                produit.setNom(obj.get("nom").toString());
              produit.setPrenom(obj.get("prenom").toString());
                produit.setEmail(obj.get("email").toString());
                produit.setMdp(obj.get("mdp").toString());

                produit.setTel(((int)Float.parseFloat(obj.get("tel").toString())));
                
                parents.add(produit);
            }
            
            
        } catch (IOException ex) {
            
        }
        return parents;
    }
      public ArrayList<Parent> getAllParents(){
        String url = "http://127.0.0.1/PiFOS/Pi/web/app_dev.php/readUM";
        connectionRequest.setUrl(url);
        connectionRequest.setPost(false);
        connectionRequest.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                parents = parseParents(new String(connectionRequest.getResponseData()));
                connectionRequest.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(connectionRequest);
        return parents;
    }
    
      public boolean createMedecin(Parent adresse) {
        String url = "http://127.0.0.1/PiFOS/Pi/web/app_dev.php/ajoutUM?nom="+adresse.getNom()+"&prenom="+adresse.getPrenom()+"&email="+adresse.getEmail()+"&mdp="+adresse.getMdp()+"&tel="+adresse.getTel();
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
    public boolean delete(int id) {
        String url = "http://127.0.0.1/PiFOS/Pi/web/app_dev.php/deleteeM/" + id;
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
    
    
    /*public void editCom(Parent com){
         ConnectionRequest con = new ConnectionRequest();
        con.setUrl("http://localhost/Mobile/editCom.php?id="+com.getId()+"&contenant="+com.getContenant());
        System.out.println("Services.CommentaireService.editCom()");
         NetworkManager.getInstance().addToQueueAndWait(con);
    }
    */
    
    
    
  public Parent getProduitById(int id) {
        ArrayList<Parent> produitslist = new ArrayList<>();
        final Parent[] bs;
        String url = "http://127.0.0.1/Pi/web/app_dev.php/findUser/" + id;

      //  Routes routes = new Routes();
        ConnectionRequest con = new ConnectionRequest();
        con.setUrl(url);
        con.addResponseListener(new ActionListener<NetworkEvent>() {

            @Override
            public void actionPerformed(NetworkEvent evt) {
                String json = new String(con.getResponseData());
                //System.out.println(".actionPerformed() : "+json);
                try {

                    JSONParser j = new JSONParser();

                    Map<String, Object> produits = j.parseJSON(new CharArrayReader(json.toCharArray()));

                    List<Map<String, Object>> list = (List<Map<String, Object>>) produits.get("root");
                    System.out.println("siize : "+list.size());
                    for (Map<String, Object> obj : list) {
                        System.out.println("id : : "+Math.round(Float.parseFloat(obj.get("id").toString())));
                        Parent produit = new Parent();
                        produit.setId( Math.round(Float.parseFloat(obj.get("id").toString())));
                        produit.setNom(obj.get("nom").toString());
                        produit.setPrenom(obj.get("prenom").toString());
                        produit.setEmail(obj.get("email").toString());
                         produit.setMdp(obj.get("mdp").toString());

                        //produit.setPrix(Float.parseFloat(obj.get("prix").toString()));
                        produit.setTel(Math.round(Float.parseFloat(obj.get("tel").toString())));
                       // produit.setIdboutique(Math.round(Float.parseFloat(obj.get("idboutique").toString())));
                        //produit.setIdcategorie(Math.round(Float.parseFloat(obj.get("idcategorie").toString())));
                        
                        //
                        System.out.println("produit : " + produit.toString() + " size : " + produitslist.size());
                        produitslist.add(produit);
                    }
                } catch (IOException ex) {
                }

            }
        });
        //NetworkManager.getInstance().addToQueue(con);
        NetworkManager.getInstance().addToQueueAndWait(con); //asynchrone


        Parent p = new Parent();
        for (Parent produit : produitslist) {
            p = produit;
        }
        return p;
    }   
    
    
    
}
