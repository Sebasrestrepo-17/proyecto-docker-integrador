package com.app.detail.domain;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "details")
@Data
public class Detail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long detalleId; // DetalleID

    @Column(nullable = false)
    private Long pedidoId; // PedidoID

    @Column(nullable = false)
    private Long productoId; // ProductoID

    @Column(nullable = false)
    private Integer cantidad; // Cantidad

    @Column(nullable = false)
    private Double precioUnitario; // PrecioUnitario

    @Column(nullable = false)
    private Double subtotal; // Subtotal

    // Empty constructor (required for JPA)
    public Detail() {}

    // Constructor with parameters
    public Detail(Long detalleId, Long pedidoId, Long productoId, Integer cantidad, Double precioUnitario, Double subtotal) {
        this.detalleId = detalleId;
        this.pedidoId = pedidoId;
        this.productoId = productoId;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
        this.subtotal = subtotal;
    }

    // Getters and Setters
    public Long getDetalleId() {
        return detalleId;
    }

    public void setDetalleId(Long detalleId) {
        this.detalleId = detalleId;
    }

    public Long getPedidoId() {
        return pedidoId;
    }

    public void setPedidoId(Long pedidoId) {
        this.pedidoId = pedidoId;
    }

    public Long getProductoId() {
        return productoId;
    }

    public void setProductoId(Long productoId) {
        this.productoId = productoId;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(Double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public Double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }

}
