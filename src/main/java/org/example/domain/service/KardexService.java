package org.example.domain.service;

import org.example.domain.entity.Kardex;
import org.example.domain.entity.Order;
import org.example.domain.entity.OrderItem;
import org.example.domain.factory.KardexFactory;
import org.example.domain.repository.KardexRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


//Clase encargada de realizar operaciones en el kardex
@Service
public class KardexService {
    private final KardexRepository kardexRepository;
    private final Map<String, KardexFactory> kardexFactories;

    //Constructor de la clase
    public KardexService(KardexRepository kardexRepository, List<KardexFactory> factoryList) {
        this.kardexRepository = kardexRepository;
        this.kardexFactories = factoryList.stream().collect(Collectors.toMap(f -> f.getClass().getAnnotation(Component.class).value(), f -> f));
    }

    public void registrarMovimiento(List<OrderItem> items, Long orderId, String type) {
        KardexFactory factory = kardexFactories.get(type.toUpperCase());
        if (factory == null) {
            throw new RuntimeException("Tipo de movimiento no soportado" + type);
        }
        for (OrderItem item : items) {
            Kardex kardex = factory.createFrom(item, orderId);
            kardexRepository.save(kardex);
        }
    }
    //Metodo encargado de registrar el movimiento de productos en el kardex
    public void registrarSalida(Order order) {
        registrarMovimiento(order.getItems(), order.getId(), "SALIDA");
        }
}
