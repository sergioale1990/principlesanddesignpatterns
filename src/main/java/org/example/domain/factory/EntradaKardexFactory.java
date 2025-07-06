package org.example.domain.factory;


import org.example.domain.entity.Kardex;
import org.example.domain.entity.Order;
import org.example.domain.entity.OrderItem;
import org.springframework.stereotype.Component;

@Component("ENTRADA")
public class EntradaKardexFactory implements KardexFactory {
    @Override
    public Kardex createFrom(OrderItem item, Long orderId) {
        Kardex kardex = new Kardex();
        Order order = new Order();
        order.setId(orderId);
        kardex.setProduct(item.getProduct());
        kardex.setOrder(order);
        kardex.setQuantity(item.getQuantity());
        kardex.setMovementType("ENTRADA");
        kardex.setDate(java.time.LocalDateTime.now());
        return kardex;
    }
}
