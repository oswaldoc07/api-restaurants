package com.ecommerce.api.restaurants.persistence.entity;



import javax.persistence.*;

@Entity
@Table(name = "tipo_pago_comercio")
public class ComercioTipoPago {

    @EmbeddedId
    private ComercioTipoPagoPK id;


    @ManyToOne
    @MapsId("id_comercio")
    @JoinColumn(name = "id_comercio", insertable = false, updatable = false)
    private Comercio comercio;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name = "id_tipo", insertable = false, updatable = false)
    private TipoPago tipoPago;

    public ComercioTipoPagoPK getId() {
        return id;
    }

    public void setId(ComercioTipoPagoPK id) {
        this.id = id;
    }

    public TipoPago getTipoPago() {
        return tipoPago;
    }

    public void setTipoPago(TipoPago tipoPago) {
        this.tipoPago = tipoPago;
    }


    public Comercio getComercio() {
        return comercio;
    }

    public void setComercio(Comercio comercio) {
        this.comercio = comercio;
    }


}