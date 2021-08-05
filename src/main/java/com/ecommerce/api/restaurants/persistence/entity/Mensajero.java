package com.ecommerce.api.restaurants.persistence.entity;

import javax.persistence.*;


import java.util.List;

@Entity
@Table(name = "mensajero")
public class Mensajero implements Comparable{


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

    @ManyToMany(mappedBy = "mensajeros",fetch=FetchType.LAZY)
    private List<Comercio> comercios;

    private Boolean disponible;

    @Transient
    private Long entregasPendientes;

    @Transient
    private Double tiempoPendiente;

    public Mensajero() {
    }

    public Mensajero(Long entregasPendientes, Double tiempoPendiente) {
        this.entregasPendientes = entregasPendientes;
        this.tiempoPendiente = tiempoPendiente;
    }

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

    public Boolean getDisponible() {
        return disponible;
    }

    public void setDisponible(Boolean disponible) {
        this.disponible = disponible;
    }

    public void setComercios(List<Comercio> comercios) {
        this.comercios = comercios;
    }

    public Long getEntregasPendientes() {
        return entregasPendientes;
    }

    public void setEntregasPendientes(Long entregasPendientes) {
        this.entregasPendientes = entregasPendientes;
    }

    public Double getTiempoPendiente() {
        return tiempoPendiente;
    }

    public void setTiempoPendiente(Double tiempoPendiente) {
        this.tiempoPendiente = tiempoPendiente;
    }

    @Override
    public int compareTo(Object o) {
        Mensajero otra = (Mensajero) o;
        return this.getEntregasPendientes().compareTo(otra.getEntregasPendientes());
    }
}
