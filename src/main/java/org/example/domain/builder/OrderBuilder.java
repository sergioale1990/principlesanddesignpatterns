package org.example.domain.builder;

import org.example.domain.entity.Order;
import org.example.domain.entity.OrderItem;
import org.example.domain.entity.Product;

import java.util.ArrayList;
import java.util.List;


//Clase encargada de crear ordenes
public class OrderBuilder {

    private int status = 1001;
    private final List<OrderItem> items = new ArrayList<>();

    public OrderBuilder withStatus(int status) {
        this.status = status;
        return this;
    }

    public OrderBuilder addItem(Product product, int quantity) {
        OrderItem orderItem = new OrderItem();
        orderItem.setProduct(product);
        orderItem.setQuantity(quantity);
        orderItem.setPrice(product.getPrice());

        items.add(orderItem);
        return this;
    }

    public Order build() {
        Order order = new Order();
        order.setStatus(status);

        double total = 0.0;
        for (OrderItem item : items) {
            item.setOrder(order);
            order.getItems().add(item);
            total += item.getQuantity() * item.getPrice();
        }
        order.setTotal(total);
        return order;
    }
}
