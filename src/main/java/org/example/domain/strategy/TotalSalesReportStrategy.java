package org.example.domain.strategy;

import org.example.domain.repository.OrderRepository;
import org.springframework.stereotype.Component;

import java.util.Map;


//Clase Responsable de generar reporte de ventas totales
@Component
public class TotalSalesReportStrategy implements ReportStrategy{
    private final OrderRepository orderRepository;

    public TotalSalesReportStrategy(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public String getType() {
        return "TOTALSALES";
    }

    @Override
    public Map<String, Object> generateReport() {
        Double total = orderRepository.findAll().stream()
                .mapToDouble(o -> o.getTotal() != null ? o.getTotal() : 0.0)
                .sum();
        return Map.of("total_ventas", total);
    }
}
