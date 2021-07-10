package com.ecommerce.api.restaurants.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class ComercioMensajeroPK implements Serializable {

    @Column(name = "id_comercio",updatable = false)
    private Integer idComercio;

    @Column(name = "id_mensajero",updatable = false)
    private Integer idMesajero;

    public ComercioMensajeroPK(Integer idComercio, Integer idMesajero) {
        this.idComercio = idComercio;
        this.idMesajero = idMesajero;
    }

    public ComercioMensajeroPK() {

    }

    public Integer getIdComercio() {
        return idComercio;
    }

    public void setIdComercio(Integer idComercio) {
        this.idComercio = idComercio;
    }

    public Integer getIdMesajero() {
        return idMesajero;
    }

    public void setIdMesajero(Integer idMesajero) {
        this.idMesajero = idMesajero;
    }
}
