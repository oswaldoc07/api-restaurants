package com.ecommerce.api.restaurants.persistence.entity;

import javax.persistence.*;

@Entity
@Table(name = "COMERCIO_CATEGORIA_PRODUCTO")
public class ComercioCategoriaProducto {

    @EmbeddedId
    private ComercioCategoriaProductoPK id;


    public ComercioCategoriaProductoPK getId() {
        return id;
    }

    public void setId(ComercioCategoriaProductoPK id) {
        this.id = id;
    }
}
