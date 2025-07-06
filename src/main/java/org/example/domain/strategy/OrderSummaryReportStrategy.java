package org.example.domain.strategy;

import org.example.domain.repository.OrderRepository;
import org.springframework.stereotype.Component;

import java.util.Map;


//Clase responsable de generar reporte de ordenes creadas
@Component
public class OrderSummaryReportStrategy implements ReportStrategy {

    private final OrderRepository orderRepository;

    public OrderSummaryReportStrategy(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public String getType() {
        return "ORDENES";
    }

    @Override
    public Map<String, Object> generateReport() {
        long count = orderRepository.count();
        double total = orderRepository.findAll().stream()
                .mapToDouble(o -> o.getTotal() != null ? o.getTotal() : 0.0)
                .sum();
        return Map.of("total_ordenes", count, "total_ventas", total);
    }
}
