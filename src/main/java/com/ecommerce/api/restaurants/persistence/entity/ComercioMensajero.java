package com.ecommerce.api.restaurants.persistence.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "COMERCIO_MENSAJERO")
public class ComercioMensajero {

    @EmbeddedId
    private ComercioMensajeroPK id;

    public ComercioMensajeroPK getId() {
        return id;
    }

    public void setId(ComercioMensajeroPK id) {
        this.id = id;
    }

    public ComercioMensajero(ComercioMensajeroPK id) {
        this.id = id;
    }
    public ComercioMensajero() {
    }
}
