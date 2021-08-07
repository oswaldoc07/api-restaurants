package com.ecommerce.api.restaurants.persistence.entity;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.LazyToOne;
import org.hibernate.annotations.LazyToOneOption;


import javax.persistence.*;



import java.util.List;

@Entity
@Table(name = "comercio")
public class Comercio{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_comercio", updatable = false, nullable = false)
    private Integer id;

    @Column(name = "id_usuario")
    private Integer idUsuario;
    @Column(name = "tipo_comercio")
    private String tipocomercio;
    private String geolocalizacion;
    private String url ;
    private String descripcion;
    @Column(name = "imagen_fondo")
    private String imagenFondo;

    @OneToMany(mappedBy = "comercio")
    private List<Orden> ordenes;

    @OneToOne(fetch=FetchType.EAGER)
    @JoinColumn(name = "id_usuario", insertable = false, updatable = false)
    private Usuario usuario;

    @OneToOne(mappedBy = "comercio",cascade = CascadeType.ALL,fetch=FetchType.EAGER)
    private ConfiguracionComercio configuracionComercio ;

    @ManyToMany(cascade = CascadeType.PERSIST,fetch=FetchType.EAGER)
    @JoinTable(
            name = "tipo_pago_comercio",
            joinColumns = { @JoinColumn(name = "id_comercio", insertable = false, updatable = false) },
            inverseJoinColumns = { @JoinColumn(name = "id_tipo",insertable = false, updatable = false) }
    )
    private List<TipoPago> tiposPago;

    @ManyToMany(cascade = CascadeType.PERSIST,fetch=FetchType.LAZY)
    @JoinTable(
            name = "COMERCIO_CATEGORIA_PRODUCTO",
            joinColumns = { @JoinColumn(name = "id_comercio", insertable = false, updatable = false) },
            inverseJoinColumns = { @JoinColumn(name = "id_categoria",insertable = false, updatable = false) }
    )
    private List<CategoriaProducto> categoriaProductos;


    @ManyToMany(cascade = { CascadeType.PERSIST },fetch=FetchType.LAZY)
    @JoinTable(
            name = "COMERCIO_MENSAJERO",
            joinColumns = { @JoinColumn(name = "id_comercio", referencedColumnName = "id_comercio", insertable = false, updatable = false) },
            inverseJoinColumns = { @JoinColumn(name = "id_mensajero",referencedColumnName="id_mensajero",insertable = false, updatable = false) }
    )
    private List<Mensajero> mensajeros;


    @Column(name = "id_tipo")
    private int idTipoComercio;

    private String color;
    private String horario;
    private Boolean disponible;

    public Boolean getDisponible() {
        return disponible;
    }

    public void setDisponible(Boolean disponible) {
        this.disponible = disponible;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public ConfiguracionComercio getConfiguracionComercio() {
        return configuracionComercio;
    }

    public void setConfiguracionComercio(ConfiguracionComercio configuracionComercio) {
        this.configuracionComercio = configuracionComercio;
    }

    public List<TipoPago> getTiposPago() {
        return tiposPago;
    }

    public void setTiposPago(List<TipoPago> tiposPago) {
        this.tiposPago = tiposPago;
    }

    public List<Orden> getOrdenes() {
        return ordenes;
    }

    public void setOrdenes(List<Orden> ordenes) {
        this.ordenes = ordenes;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipocomercio() {
        return tipocomercio;
    }

    public void setTipocomercio(String tipocomercio) {
        this.tipocomercio = tipocomercio;
    }

    public String getGeolocalizacion() {
        return geolocalizacion;
    }

    public void setGeolocalizacion(String geolocalizacion) {
        this.geolocalizacion = geolocalizacion;
    }


    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }


    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<CategoriaProducto> getCategoriaProductos() {
        return categoriaProductos;
    }

    public void setCategoriaProductos(List<CategoriaProducto> categoriaProductos) {
        this.categoriaProductos = categoriaProductos;
    }

    public int getIdTipoComercio() {
        return idTipoComercio;
    }

    public void setIdTipoComercio(int idTipoComercio) {
        this.idTipoComercio = idTipoComercio;
    }

    public String getImagenFondo() {
        return imagenFondo;
    }

    public void setImagenFondo(String imagenFondo) {
        this.imagenFondo = imagenFondo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public List<Mensajero> getMensajeros() {
        return mensajeros;
    }

    public void setMensajeros(List<Mensajero> mensajeros) {
        this.mensajeros = mensajeros;
    }
}