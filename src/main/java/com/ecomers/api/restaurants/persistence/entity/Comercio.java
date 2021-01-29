package com.ecomers.api.restaurants.persistence.entity;

import javax.persistence.*;

@Entity
@Table(name = "comercio")
@PrimaryKeyJoinColumn(name="id_usuario")
public class Comercio extends Usuario{


    @Column(name = "id_comercio", insertable = false,updatable = false)
    private Integer idComercio;

    private String tipo_comercio;
    private String geolocalizacion;
    private String url ;
    private String descripcion;
    private String imagen;


    /*@Override
    public Rol getRol() {
         return null;
    }

    @Override
    public void setRol(Rol rol) {
        super.setRol(rol);
    }*/

    public Integer getIdComercio() {
        return idComercio;
    }

    public void setIdComercio(Integer idComercio) {
        this.idComercio = idComercio;
    }

    public String getTipo_comercio() {
        return tipo_comercio;
    }

    public void setTipo_comercio(String tipo_comercio) {
        this.tipo_comercio = tipo_comercio;
    }

    public String getGeolocalizacion() {
        return geolocalizacion;
    }

    public void setGeolocalizacion(String geolocalizacion) {
        this.geolocalizacion = geolocalizacion;
    }


    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }


}
