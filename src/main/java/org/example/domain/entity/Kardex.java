package org.example.domain.entity;


import jakarta.persistence.*;

import java.time.LocalDateTime;


//Clase responsable de contener la entidad para Kardex
@Entity
public class Kardex {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    private LocalDateTime date;
    private int quantity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="order_id", nullable = true)
    private Order order;

    @Column(name = "tipo_movimiento", nullable = false)
    private String movementType;

    public String getMovementType() {
        return movementType;
    }
    public void setMovementType(String movementType) {
        this.movementType = movementType;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Long getId() {
        return id;
    }
    public Product getProduct() {
        return product;
    }
    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Order getOrder() {
        return order;
    }
    public void setOrder(Order order) {
        this.order = order;
    }
}
