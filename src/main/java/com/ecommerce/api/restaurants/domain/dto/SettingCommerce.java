package com.ecommerce.api.restaurants.domain.dto;

public class SettingCommerce {

    private Integer id;
    private Integer idComercio;
    private Boolean enviosms;
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
