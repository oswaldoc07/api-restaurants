package com.ecomers.api.restaurants.persistence.entity;

import javax.persistence.*;

@Entity
@Table(name = "cliente")
@PrimaryKeyJoinColumn(name="id_usuario")
public class Cliente extends Usuario{


    /* @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)*/
    @Column(name = "id_cliente")
    private Integer idCliente;

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

}



