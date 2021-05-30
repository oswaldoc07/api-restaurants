package com.ecommerce.api.restaurants.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class OrdenProductoPK implements Serializable {
    @Column(name = "id_orden",updatable = false)
    private Integer idOrden;

    @Column(name = "id_producto",updatable = false)
    private Integer idProducto;

    public Integer getIdOrden() {
        return idOrden;
    }

    public void setIdOrden(Integer idOrden) {
        this.idOrden = idOrden;
    }

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }
}