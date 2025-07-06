package org.example.domain.report;

import java.util.Map;


//Interfaz necesaria para la generacion de reportes
public interface ReportComponent {
    Map<String, Object> generateReport();
}
