package org.example.domain.strategy;

import java.util.Map;

//Interfaz creada para la generacion de reportes, cada clase que implemente esta interfaz sera una "estrategia" diferente de reporte
public interface ReportStrategy {
    String getType(); //Identificacion de la estrategia
    Map<String, Object> generateReport();
}
