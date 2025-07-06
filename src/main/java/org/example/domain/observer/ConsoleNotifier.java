package org.example.domain.observer;


import org.example.domain.entity.Order;
import org.springframework.stereotype.Component;


//Implementacion de la interfaz "observador" para el cambio de estados en ordenes de compra
@Component
public class ConsoleNotifier implements OrderStatusObserver {

    @Override
    public void onStatusChanged(Order order, int oldStatus, int newStatus) {
        System.out.println("Order " + order.getId() + " status changed from " + oldStatus + " to " + newStatus);
    }
}
