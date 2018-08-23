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

/**
 *
 * @author Usuario
 */
@ManagedBean
@ViewScoped
public class ListaParqueView {
    private List<Parque>  listaparques = new ArrayList<>();
    private final String url = "https://private-05017d-parques1.apiary-mock.com/parks?status=";
    
    //getters y setters

    public List<Parque> getListaparques() {
        return listaparques;
    }

    public void setListaparques(List<Parque> listaparques) {
        this.listaparques = listaparques;
    }
    
    
    public String consultaParques(){
        
        System.out.print("uuuuuuuuuuuuu");
        Client cliente = ClientBuilder.newClient();                                 
        WebTarget rs =cliente.target(url);       
        JsonArray jsonarray = (JsonArray) rs.request(MediaType.APPLICATION_JSON).get(JsonArray.class);
        
        Iterator iter = jsonarray.iterator();
        while(iter.hasNext()){
            JsonObject val = (JsonObject)iter.next();                 
            listaparques.add(Parque.fromJson(val));           
            /*
            equipoTemp.setCodigo(val.getString("codigo"));
            equipoTemp.setNombre(val.getString("nombre"));
            equipoTemp.setColor(val.getString("Naranja"));
            equipoTemp.setDt(val.getString("dt"));
            equipoTemp.setDivision(val.getString("fechaFund"));
            equipoTemp.setFecha_fundacion(val.getString("division"));
             */      
        }
        return "";
    }
}
