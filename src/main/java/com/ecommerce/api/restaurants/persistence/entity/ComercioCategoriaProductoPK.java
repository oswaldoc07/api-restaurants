package com.ecommerce.api.restaurants.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class ComercioCategoriaProductoPK implements Serializable {

    @Column(name = "id_comercio",updatable = false)
    private Integer idComercio;

    @Column(name = "id_categoria",updatable = false)
    private Integer idCategoria;

    public Integer getIdComercio() {
        return idComercio;
    }

    public void setIdComercio(Integer idComercio) {
        this.idComercio = idComercio;
    }

    public Integer getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }
}
