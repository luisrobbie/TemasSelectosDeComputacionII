package com.tienda.online.entities;
import org.springframework.data.mongodb.core.mapping.Document;


import org.springframework.data.annotation.Id;

@Document(collection = "IMAGENES")
public class Imagen {
    @Id
    private String id;

    private Integer productoId;
    private String url;
    private Integer orden;
    private Boolean principal;

    public Imagen(){}

    public Imagen(Integer productoId, String url, Integer orden, Boolean principal){
        this.productoId=productoId;
        this.url=url;
        this.orden=orden;
        this.principal=principal;
    }

    public Integer getProductoId(){
        return productoId;
    }

    public void setProductoId(Integer productoId){
        this.productoId=productoId;
    }

    public String getUrl(){
        return url;
    }

    public void setUrl(String url){
        this.url=url;
    }
    public Integer getOrden(){
        return orden;
    }

    public void setOrden(Integer orden){
        this.orden=orden;
    }

    public Boolean getPrincipal(){
        return principal;
    }
    
    public void setPrincipal(Boolean principal){
        this.principal=principal;
    }
}
