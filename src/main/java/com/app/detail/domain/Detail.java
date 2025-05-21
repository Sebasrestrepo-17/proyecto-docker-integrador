package com.app.detail.domain;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "details")
@Data
public class Detail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long detailId; // Detail ID

    @Column(nullable = false)
    private Long orderId; // Order ID

    @Column(nullable = false)
    private Long productId; // Product ID

    @Column(nullable = false)
    private Integer quantity; // Quantity

    @Column(nullable = false)
    private Double unitPrice; // Unit Price

    @Column(nullable = false)
    private Double subtotal; // Subtotal

    // Empty constructor (required for JPA)
    public Detail() {}

    // Constructor with parameters
    public Detail(Long detailId, Long orderId, Long productId, Integer quantity, Double unitPrice, Double subtotal) {
        this.detailId = detailId;
        this.orderId = orderId;
        this.productId = productId;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.subtotal = subtotal;
    }

    // Getters and Setters
    public Long getDetailId() {
        return detailId;
    }

    public void setDetailId(Long detailId) {
        this.detailId = detailId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }
}

