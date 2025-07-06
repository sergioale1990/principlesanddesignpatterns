package org.example.domain.service;

import org.example.domain.report.BasicReport;
import org.example.domain.report.CompositeReport;
import org.example.domain.strategy.ReportStrategy;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

//Clase encargada de realizar operaciones para la generacion de reportes
@Service
public class ReportService {

    private final Map<String, ReportStrategy> reportStrategies;

    //Constructor de la Clase
    public ReportService(List<ReportStrategy> strategiesList) {
        this.reportStrategies = strategiesList.stream()
                .collect(Collectors.toMap(ReportStrategy::getType, strategy -> strategy));
    }

    //Metodo encargado de generar el reporte segun el parametro requerido
    public Map<String, Object> generateReport(String type) {
        ReportStrategy strategy = reportStrategies.get(type.toUpperCase());
        if (strategy == null) {
            throw new RuntimeException("Tipo de reporte no soportado" + type);
        }
        return strategy.generateReport();
    }

    //Metodo responsable de generar reportes combinados usando el patron composite
    public Map<String, Object> generateCombinedReport(List<String> types) {
        CompositeReport composite = new CompositeReport();

        for (String type : types) {
            ReportStrategy strategy = reportStrategies.get(type.toUpperCase());
            if (strategy == null) throw new RuntimeException("Tipo de reporte no soportado: " + type);
            composite.addComponent(new BasicReport(strategy));
        }

        return composite.generateReport();
    }
}
