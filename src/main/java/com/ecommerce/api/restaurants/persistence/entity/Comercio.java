package com.ecommerce.api.restaurants.persistence.entity;

import javax.persistence.*;



import java.util.List;

@Entity
@Table(name = "comercio")
public class Comercio{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_comercio")
    private Integer id;

    @Column(name = "id_usuario")
    private Integer idUsuario;
    private String tipo_comercio;
    private String geolocalizacion;
    private String url ;
    private String descripcion;
    @Column(name = "imagen_fondo")
    private String imagenFondo;

    @OneToMany(mappedBy = "comercio")
    private List<Orden> ordenes;

    @ManyToOne
    @JoinColumn(name = "id_usuario", insertable = false, updatable = false)
    private Usuario usuario;

    @OneToMany(mappedBy = "comercio", cascade = {CascadeType.ALL})
    private List<ComercioTipoPago> tiposPago;

    @ManyToMany(cascade = { CascadeType.ALL },fetch=FetchType.LAZY)
    @JoinTable(
            name = "COMERCIO_CATEGORIA_PRODUCTO",
            joinColumns = { @JoinColumn(name = "id_comercio", insertable = false, updatable = false) },
            inverseJoinColumns = { @JoinColumn(name = "id_categoria",insertable = false, updatable = false) }
    )
    private List<CategoriaProducto> categoriaProductos;

    @Column(name = "id_tipo")
    private int idTipoComercio;

    private String color;


    public List<ComercioTipoPago> getTiposPago() {
        return tiposPago;
    }

    public void setTiposPago(List<ComercioTipoPago> tiposPago) {
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

    public String getTipo_comercio() {
        return tipo_comercio;
    }

    public void setTipo_comercio(String tipo_comercio) {
        this.tipo_comercio = tipo_comercio;
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
}
