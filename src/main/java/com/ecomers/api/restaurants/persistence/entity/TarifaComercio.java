package com.ecomers.api.restaurants.persistence.entity;

import javax.persistence.*;

@Entity
@Table(name="TARIFA_COMERCIO")
public class TarifaComercio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ind_tarifa")
    private Integer idTarifa;

    @Column(name = "id_comercio")
    private Integer idComercio;

    private Double distancia;

    @Column(name = "precio")
    private Double tarifa;

    public Integer getIdTarifa() {
        return idTarifa;
    }

    public void setIdTarifa(Integer idTarifa) {
        this.idTarifa = idTarifa;
    }

    public Integer getIdComercio() {
        return idComercio;
    }

    public void setIdComercio(Integer idComercio) {
        this.idComercio = idComercio;
    }

    public Double getDistancia() {
        return distancia;
    }

    public void setDistancia(Double distancia) {
        this.distancia = distancia;
    }

    public Double getTarifa() {
        return tarifa;
    }

    public void setTarifa(Double tarifa) {
        this.tarifa = tarifa;
    }
}


