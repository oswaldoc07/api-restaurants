package com.ecommerce.api.restaurants.persistence.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="tipo_pago")
public class TipoPago {

    @Id
    @Column(name = "id_tipo")
    private String id;

    private String nombre;

    @OneToMany(mappedBy = "tipoPago")
    private List<Orden> ordenes;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public List<Orden> getOrdenes() {
        return ordenes;
    }

    public void setOrdenes(List<Orden> ordenes) {
        this.ordenes = ordenes;
    }
}
