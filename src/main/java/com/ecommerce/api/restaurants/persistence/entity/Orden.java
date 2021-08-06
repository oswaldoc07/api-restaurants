package com.ecommerce.api.restaurants.persistence.entity;



import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "orden")
public class Orden{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_orden")
    private Integer id;

    @Column(name = "id_cliente")
    private Integer idCliente;

    @Column(name = "id_comercio")
    private Integer idComercio;

    @Column(name = "fecha_ingreso")
    private LocalDateTime fechaIngreso;

    @Column(name = "fecha_estimada")
    private LocalDateTime fechaEstimada;

    @Column(name = "fecha_entrega")
    private LocalDateTime fechaEntrega;

    @Column(name = "comentario_cliente")
    private String comentarioCliente;

    @Column(name = "comentario_comercio")
    private String comentarioComercio;

    @Column(name = "comentario_mensajero")
    private String comentarioMensajero;

    private String estado;

    private Integer precio;

    @Column(name = "costo_envio")
    private Integer costoEnvio;

    @Column(name = "motivo_rechazo")
    private String motivoRechazo;

    @Column(name = "ubicacion_GPS")
    private String ubicacionGPS;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name = "id_cliente", insertable = false, updatable = false)
    private Cliente cliente;


    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name = "id_comercio", insertable = false, updatable = false)
    private Comercio comercio;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name = "id_mensajero", insertable = false, updatable = true)
    private Mensajero mensajero;

    @OneToMany(mappedBy = "orden", cascade = {CascadeType.ALL},fetch=FetchType.LAZY)
   // @Fetch(value = FetchMode.SELECT)
    private List<OrdenProducto> ordenProductos;

    @Column(name="direccion_entrega")
    private String direccion;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name = "medio_pago", insertable = true, updatable = false)
    private TipoPago tipoPago;

    @Column(name = "pago_efectivo")
    private Double montoEfectivo;

    @Column(name = "tiempo_envio")
    private Double tiempoEnvio;

    @Column(name = "entrega_domicio")
    private Boolean entregaDomicio;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public Integer getIdComercio() {
        return idComercio;
    }

    public void setIdComercio(Integer idComercio) {
        this.idComercio = idComercio;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Comercio getComercio() {
        return comercio;
    }

    public void setComercio(Comercio comercio) {
        this.comercio = comercio;
    }

    public LocalDateTime getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(LocalDateTime fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public LocalDateTime getFechaEstimada() {
        return fechaEstimada;
    }

    public void setFechaEstimada(LocalDateTime fechaEstimada) {
        this.fechaEstimada = fechaEstimada;
    }

    public LocalDateTime getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(LocalDateTime fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }



    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Integer getPrecio() {
        return precio;
    }

    public void setPrecio(Integer precio) {
        this.precio = precio;
    }

    public Integer getCostoEnvio() {
        return costoEnvio;
    }

    public void setCostoEnvio(Integer costoEnvio) {
        this.costoEnvio = costoEnvio;
    }



    public List<OrdenProducto> getOrdenProductos() {
        return ordenProductos;
    }

    public void setOrdenProductos(List<OrdenProducto> ordenProductos) {
        this.ordenProductos = ordenProductos;
    }

    public String getMotivoRechazo() {
        return motivoRechazo;
    }

    public void setMotivoRechazo(String motivoRechazo) {
        this.motivoRechazo = motivoRechazo;
    }

    public String getUbicacionGPS() {
        return ubicacionGPS;
    }

    public void setUbicacionGPS(String ubicacionGPS) {
        this.ubicacionGPS = ubicacionGPS;
    }


    public Mensajero getMensajero() {
        return mensajero;
    }

    public void setMensajero(Mensajero mensajero) {
        this.mensajero = mensajero;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public TipoPago getTipoPago() {
        return tipoPago;
    }

    public void setTipoPago(TipoPago tipoPago) {
        this.tipoPago = tipoPago;
    }

    public Double getMontoEfectivo() {
        return montoEfectivo;
    }

    public void setMontoEfectivo(Double montoEfectivo) {
        this.montoEfectivo = montoEfectivo;
    }

    public Double getTiempoEnvio() {
        return tiempoEnvio;
    }

    public void setTiempoEnvio(Double tiempoEnvio) {
        this.tiempoEnvio = tiempoEnvio;
    }

    public String getComentarioCliente() {
        return comentarioCliente;
    }

    public void setComentarioCliente(String comentarioCliente) {
        this.comentarioCliente = comentarioCliente;
    }

    public String getComentarioComercio() {
        return comentarioComercio;
    }

    public void setComentarioComercio(String comentarioComercio) {
        this.comentarioComercio = comentarioComercio;
    }

    public String getComentarioMensajero() {
        return comentarioMensajero;
    }

    public void setComentarioMensajero(String comentarioMensajero) {
        this.comentarioMensajero = comentarioMensajero;
    }

    public Boolean getEntregaDomicio() {
        return entregaDomicio;
    }

    public void setEntregaDomicio(Boolean entregaDomicio) {
        this.entregaDomicio = entregaDomicio;
    }
}