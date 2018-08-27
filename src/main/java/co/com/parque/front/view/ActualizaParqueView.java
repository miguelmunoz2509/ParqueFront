/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.parque.front.view;

import co.com.parque.front.model.Parque;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.json.JsonObject;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Usuario
 */
@ManagedBean
@ViewScoped
public class ActualizaParqueView {
    
    private String selectedId;
    private Parque selectedParque;
    
    public void init(){
        Client client = ClientBuilder.newClient();
        WebTarget rs= client.target("https://private-05017d-parques1.apiary-mock.com/parks/{identificacion}");
        
        JsonObject jsonObj = (JsonObject) rs.resolveTemplate("identificacion", selectedId)
                   .request(MediaType.APPLICATION_JSON)
                   .get(JsonObject.class);
        
        selectedParque = Parque.fromJson(jsonObj);
    }

    public String getSelectedId() {
        return selectedId;
    }

    public void setSelectedId(String selectedId) {
        this.selectedId = selectedId;
    }

    public Parque getSelectedParque() {
        return selectedParque;
    }

    public void setSelectedParque(Parque selectedParque) {
        this.selectedParque = selectedParque;
    }

   

    
}
