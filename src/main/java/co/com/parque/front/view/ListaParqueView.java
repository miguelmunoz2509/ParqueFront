/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.parque.front.view;

import co.com.parque.front.model.Parque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Usuario
 */
@ManagedBean
@ViewScoped
public class ListaParqueView {
    private List<Parque>  listaparques;
    private final String url = "https://private-05017d-parques1.apiary-mock.com/parks?status=";
    private final String urlopen = "https://private-05017d-parques1.apiary-mock.com/parks?status=Open";
    private final String urlclose = "https://private-05017d-parques1.apiary-mock.com/parks?status=Closed";
    private final String urldelete = "https://private-05017d-parques1.apiary-mock.com/parks/{id}";

    public List<Parque> getListaparques() {
        return listaparques;
    }

    public void setListaparques(List<Parque> listaparques) {
        this.listaparques = listaparques;
    }
    
    
    public String consultaParques(){
        listaparques = new ArrayList<>();
        Client cliente = ClientBuilder.newClient();                                 
        WebTarget rs =cliente.target(url);       
        JsonArray jsonarray = (JsonArray) rs.request(MediaType.APPLICATION_JSON).get(JsonArray.class);
        
        Iterator iter = jsonarray.iterator();
        while(iter.hasNext()){
            JsonObject val = (JsonObject)iter.next();                 
            listaparques.add(Parque.fromJson(val));          
        }
        return "";
    }
    public String consultaParquesOpen(){ 
        listaparques = new ArrayList<>();
        Client cliente = ClientBuilder.newClient();                                 
        WebTarget rs =cliente.target(urlopen);       
        JsonArray jsonarray = (JsonArray) rs.request(MediaType.APPLICATION_JSON).get(JsonArray.class);
        
        Iterator iter = jsonarray.iterator();
        while(iter.hasNext()){
            JsonObject val = (JsonObject)iter.next();                 
            listaparques.add(Parque.fromJson(val));          
        }
        return "";
    }
    public String consultaParquesClose(){ 
        listaparques = new ArrayList<>();
        Client cliente = ClientBuilder.newClient();                                 
        WebTarget rs =cliente.target(urlclose);       
        JsonArray jsonarray = (JsonArray) rs.request(MediaType.APPLICATION_JSON).get(JsonArray.class);
        
        Iterator iter = jsonarray.iterator();
        while(iter.hasNext()){
            JsonObject val = (JsonObject)iter.next();                 
            listaparques.add(Parque.fromJson(val));          
        }
        return "";
    }
    public void eliminaParques(Parque parque){ 
        listaparques = new ArrayList<>();
        Client cliente = ClientBuilder.newClient();                                 
        WebTarget rs =cliente.target(urldelete);  
        
        Response response = rs.resolveTemplate("id", parque.getId())
                    .request(MediaType.APPLICATION_JSON).get();
        
        //JsonObject jsonObj = (JsonObject) rs.resolveTemplate("parkId", parkId)
        //           .request(MediaType.APPLICATION_JSON)
        //           .delete(JsonObject.class);
    }
}
