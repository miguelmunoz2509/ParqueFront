/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.parque.front.model;

import javax.json.JsonObject;

/**
 *
 * @author Usuario
 */
public class Parque {
    
    String id, nombre, estado, status;
    int capacidad;
    
    //Constructores

    public Parque() {
    }

    public Parque(String id, String nombre, String estado, String status, int capacidad) {
        this.id = id;
        this.nombre = nombre;
        this.estado = estado;
        this.status = status;
        this.capacidad = capacidad;
    }
    
    //Getters y setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }
    
    //Metodo
    public static  Parque fromJson(JsonObject val){
        
        Parque parqueTemp = new Parque();        
        parqueTemp.setId(val.getString("id"));
        parqueTemp.setNombre(val.getString("name"));
        parqueTemp.setEstado(val.getString("state"));
        parqueTemp.setStatus(val.getString("status"));
        parqueTemp.setCapacidad(val.getInt("capacity"));
        
        return parqueTemp;
    }
    
}
