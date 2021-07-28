package com.ecommerce.api.restaurants.persistence.entity;
import javax.persistence.*;

@Entity
@Table(name = "configuracion_comercio")
public class ConfiguracionComercio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_configuracion")
    private Integer id;

    @Column(name = "id_comercio")
    private Integer idComercio;

    @OneToOne
    @JoinColumn(name = "id_comercio", insertable = false, updatable = false)
    private Comercio comercio;

    @Column(name = "envio_sms")
    private Boolean enviosms;

    @Column(name = "radio_cobertura")
    private Integer radiocobertura;

    //GET and SET
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdComercio() {
        return idComercio;
    }

    public void setIdComercio(Integer idComercio) {
        this.idComercio = idComercio;
    }

    public Comercio getComercio() {
        return comercio;
    }

    public void setComercio(Comercio comercio) {
        this.comercio = comercio;
    }

    public Boolean getEnviosms() {
        return enviosms;
    }

    public void setEnviosms(Boolean enviosms) {
        this.enviosms = enviosms;
    }

    public Integer getRadiocobertura() {
        return radiocobertura;
    }

    public void setRadiocobertura(Integer radiocobertura) {
        this.radiocobertura = radiocobertura;
    }



}

