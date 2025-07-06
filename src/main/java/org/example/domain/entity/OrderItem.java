package org.example.domain.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

//Clase responsable de contener la entidad para productos en ordenes de ventas
@Entity
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    private int quantity;

    private Double price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name= "order_id", nullable = false)
    @JsonBackReference
    private Order order;

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public Double getPrice() {
        return price;
    }
    public Long getId() {
        return id;
    }
    public Order getOrder() {
        return order;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
