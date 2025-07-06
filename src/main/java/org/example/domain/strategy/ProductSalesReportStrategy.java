package org.example.domain.strategy;

import org.example.domain.repository.OrderRepository;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;


//Clase responsable de generar reportes de ventas por producto
@Component
public class ProductSalesReportStrategy implements ReportStrategy{

    private final OrderRepository orderRepository;

    public ProductSalesReportStrategy(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public String getType() {
        return "PRODUCTSALES";
    }

    @Override
    public Map<String, Object> generateReport() {
        Map<String, Double> report = new HashMap<>();

        orderRepository.findAll().forEach(order -> {
            for (var item : order.getItems()) {
                String name = item.getProduct().getName();
                double subTotal = item.getPrice() * item.getQuantity();
                report.merge(name, subTotal, Double::sum);
            }
        });

        return Map.of("Ventas_Por_Producto", report);
    }
}
