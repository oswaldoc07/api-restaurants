package com.ecomers.api.restaurants.persistence.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "cliente")
public class Cliente{


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente")
    private Integer id;

    @OneToMany(mappedBy = "cliente")
    private List<Orden> ordenes;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public List<Orden> getOrdenes() {
        return ordenes;
    }

    public void setOrdenes(List<Orden> ordenes) {
        this.ordenes = ordenes;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}



