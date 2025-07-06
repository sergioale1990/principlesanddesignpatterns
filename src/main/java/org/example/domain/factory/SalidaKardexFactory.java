package org.example.domain.factory;

import org.example.domain.entity.Kardex;
import org.example.domain.entity.Order;
import org.example.domain.entity.OrderItem;
import org.springframework.stereotype.Component;

@Component("SALIDA")
public class SalidaKardexFactory implements KardexFactory {
    @Override
    public Kardex createFrom(OrderItem orderItem, Long orderId) {
        Kardex kardex = new Kardex();
        Order order = new Order();
        order.setId(orderId);
        kardex.setProduct(orderItem.getProduct());
        kardex.setOrder(order);
        kardex.setQuantity(orderItem.getQuantity());
        kardex.setMovementType("SALIDA");
        kardex.setDate(java.time.LocalDateTime.now());
        return kardex;
    }
}
