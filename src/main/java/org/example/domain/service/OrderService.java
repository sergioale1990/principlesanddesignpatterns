package org.example.domain.service;


import org.example.domain.builder.OrderBuilder;
import org.example.domain.entity.Order;
import org.example.domain.entity.OrderItem;
import org.example.domain.observer.ConsoleNotifier;
import org.example.domain.observer.OrderStatusNotifier;
import org.example.domain.repository.OrderRepository;
import org.example.domain.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;


//Clase encargada de ralizar operaciones en las ordenes de compra
@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;
    private final KardexService kardexService;
    public final OrderStatusNotifier orderStatusNotifier;

    //Constructor de la clase, se registra el observador ConsoleNotifier para el cambio de estado de la orden
    public OrderService(OrderRepository orderRepository, ProductRepository productRepository, KardexService kardexService, OrderStatusNotifier orderStatusNotifier, ConsoleNotifier consoleNotifier) {
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
        this.kardexService = kardexService;
        this.orderStatusNotifier = orderStatusNotifier;
        this.orderStatusNotifier.registerObserver(consoleNotifier);
    }

    //Metodo encargado de crear ordenes de compra nuevas
    public Order createOrder(Order order) {
        OrderBuilder orderBuilder = new OrderBuilder().withStatus(order.getStatus());

        for (OrderItem orderItem : order.getItems()) {
            Long productId = orderItem.getProduct().getId();
            var product = productRepository.findById(productId).orElseThrow(() -> new RuntimeException("Producto no encontrado"));
            orderBuilder.addItem(product, orderItem.getQuantity());
        }

        Order NewOrder = orderBuilder.build();
        Order savedOrder = orderRepository.save(NewOrder);
        kardexService.registrarSalida(savedOrder);
        return savedOrder;
    }

    //Metodo encargado de actualizar el estado de una orden de compra creada
    public Order updateStatusOrder(Long orderId, int newStatus){
        Order order = orderRepository.findById(orderId).orElseThrow(()-> new RuntimeException("Orden no encontrada"));
        int oldStatus = order.getStatus();
        order.setStatus(newStatus);
        Order orderUpdated = orderRepository.save(order);
        orderStatusNotifier.notifyObservers(orderUpdated, oldStatus, newStatus); //Inyeccion de dependencias para el patron observador y se registre el cambio de estado en las ordenes de comppra
        return orderUpdated;
    }

    //Metodo encargado de buscar una orden por su ID
    public Optional<Order> findById(Long id) {
        return orderRepository.findById(id);
    }
}
