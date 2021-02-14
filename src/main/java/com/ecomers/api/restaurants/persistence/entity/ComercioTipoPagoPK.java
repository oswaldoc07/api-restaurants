package com.ecomers.api.restaurants.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class ComercioTipoPagoPK implements Serializable {


    @Column(name = "id_comercio")
    private Integer idcomercio;

    @Column(name = "id_tipo")
    private String idTipo;


    public String getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(String idTipo) {
        this.idTipo = idTipo;
    }

    public Integer getIdcomercio() {
        return idcomercio;
    }

    public void setIdcomercio(Integer idcomercio) {
        this.idcomercio = idcomercio;
    }
}