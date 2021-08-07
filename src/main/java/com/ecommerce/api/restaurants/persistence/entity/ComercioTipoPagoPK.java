package com.ecommerce.api.restaurants.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class ComercioTipoPagoPK implements Serializable {


    @Column(name = "id_comercio",updatable = false)
    private Integer idComercio;

    @Column(name = "id_tipo",updatable = false)
    private String idTipo;


    public String getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(String idTipo) {
        this.idTipo = idTipo;
    }

    public Integer getIdComercio() {
        return idComercio;
    }

    public void setIdComercio(Integer idComercio) {
        this.idComercio = idComercio;
    }
}