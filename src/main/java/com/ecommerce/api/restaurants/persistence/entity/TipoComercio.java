package com.ecommerce.api.restaurants.persistence.entity;

import javax.persistence.*;

@Entity
@Table(name="TIPO_COMERCIO")
public class TipoComercio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo")
    private Integer idTipo;

    private String nombre;
    private String descripcion;
    private Boolean estado;
    private String imagen;


    public Integer getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(Integer idTipo) {
        this.idTipo = idTipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
}
