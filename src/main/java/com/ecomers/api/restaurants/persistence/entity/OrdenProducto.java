package com.ecomers.api.restaurants.persistence.entity;

import javax.persistence.*;

@Entity
@Table(name = "orden_producto")
public class OrdenProducto {
    @EmbeddedId
    private OrdenProductoPK id;

    private Integer cantidad;
    private Double subtotal;


    @ManyToOne
    @MapsId("idOrden")
    @JoinColumn(name = "id_compra", insertable = false, updatable = false)
    private Orden orden;

    @ManyToOne
    @MapsId("idProducto")
    @JoinColumn(name = "id_producto", insertable = false, updatable = false)
    private Producto producto;

    public OrdenProductoPK getId() {
        return id;
    }

    public void setId(OrdenProductoPK id) {
        this.id = id;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }

    public Orden getOrden() {
        return orden;
    }

    public void setOrden(Orden orden) {
        this.orden = orden;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
}