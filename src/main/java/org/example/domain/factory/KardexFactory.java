package org.example.domain.factory;

import org.example.domain.entity.Kardex;
import org.example.domain.entity.OrderItem;

public interface KardexFactory {
    Kardex createFrom(OrderItem orderItem, Long oderId);
}
