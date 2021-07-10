package com.ecommerce.api.restaurants.persistence.entity;

import javax.persistence.*;


import java.util.List;

@Entity
@Table(name = "mensajero")
public class Mensajero{


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_mensajero")
    private Integer id;

    @OneToMany(mappedBy = "mensajero")
    private List<Orden> ordenes;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    private String placa;

    @Column(name = "tipo_vehiculo")
    private String tipoVehiculo;

    @ManyToMany(mappedBy = "mensajeros")
    private List<Comercio> comercios;

    private Boolean abierto;

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

    public String getTipoVehiculo() {
        return tipoVehiculo;
    }

    public void setTipoVehiculo(String tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }


    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public List<Comercio> getComercios() {
        return comercios;
    }

    public void setComercios(List<Comercio> comercios) {
        this.comercios = comercios;
    }

    public Boolean getAbierto() {
        return abierto;
    }

    public void setAbierto(Boolean abierto) {
        this.abierto = abierto;
    }
}
