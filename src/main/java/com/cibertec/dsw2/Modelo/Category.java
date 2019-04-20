package com.cibertec.dsw2.Modelo;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import com.fasterxml.jackson.annotation.JsonProperty;

@com.fasterxml.jackson.annotation.JsonIgnoreProperties(ignoreUnknown = true)
@com.fasterxml.jackson.annotation.JsonInclude(com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL)
@javax.persistence.Entity

public class Category {

    @Id
    @GeneratedValue()
    @JsonProperty("id")
    private int id;

    @JsonProperty("descripcion")
    private String descripcion;

    public Category(){

    }

    public Category(int id, String descripcion){
        this.id = id;
        this.descripcion = descripcion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescription(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString(){

        return "Category: {"+
                "id = "+getId() +
                "descripcion = " + getDescripcion()+"}";

    }

}