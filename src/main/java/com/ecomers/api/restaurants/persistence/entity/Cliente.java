package com.ecomers.api.restaurants.persistence.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "cliente")
@PrimaryKeyJoinColumn(name="id_usuario")
public class Cliente extends Usuario{


   @Column(name = "id_cliente", insertable = false,updatable = false)
    private Integer idCliente;


    @OneToMany(mappedBy = "cliente")
    private List<Orden> ordenes;


    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public List<Orden> getOrdenes() {
        return ordenes;
    }

    public void setOrdenes(List<Orden> ordenes) {
        this.ordenes = ordenes;
    }
}



