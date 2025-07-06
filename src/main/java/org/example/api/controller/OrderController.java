package org.example.api.controller;


import org.example.domain.entity.Order;
import org.example.domain.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

//Controlador REST para la entidad Orden
@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService orderService;

    //Constructor de la clase
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    //Metodo encargado de crear una orden de compra nueva
    @PostMapping
    public ResponseEntity<Order> createOrder(@RequestBody Order order) {
        return ResponseEntity.ok(orderService.createOrder(order));
    }

    //Metodo encargado de obtener la lista de ordenes creadas
    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable Long id) {
        return orderService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    //Metodo encargado modificar el estado de una orden por su ID
    @PutMapping("/{id}/status")
    public ResponseEntity<Order> updateStatusOrder(@PathVariable Long id, @RequestParam int status){
        return ResponseEntity.ok(orderService.updateStatusOrder(id, status));
    }
}
