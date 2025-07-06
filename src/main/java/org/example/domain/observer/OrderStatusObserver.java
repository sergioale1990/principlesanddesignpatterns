package org.example.domain.observer;

import org.example.domain.entity.Order;

//Interfaz responsable de "observar" el cambio de estado de una orden
public interface OrderStatusObserver {
    void onStatusChanged(Order order, int oldStatus, int newStatus);
}
