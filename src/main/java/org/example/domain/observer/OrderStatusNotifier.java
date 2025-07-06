package org.example.domain.observer;


import org.example.domain.entity.Order;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

//Clase encargada de notificar a los "observadores" sobre el cambio de estado en ordenes de compra
@Component
public class OrderStatusNotifier {

    private final List<OrderStatusObserver> observers = new ArrayList<>();

    public void registerObserver(OrderStatusObserver observer) {
        observers.add(observer);
    }

    public void notifyObservers(Order order, int oldStatus, int newStatus) {
        for (OrderStatusObserver observer : observers) {
            observer.onStatusChanged(order, oldStatus, newStatus);
        }
    }
}
