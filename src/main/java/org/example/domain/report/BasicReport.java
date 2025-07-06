package org.example.domain.report;

import org.example.domain.strategy.ReportStrategy;

import java.util.Map;


//Clase para la generacion basica de reportes
public class BasicReport implements ReportComponent{
    private final ReportStrategy strategy;

    public BasicReport(ReportStrategy strategy) {
        this.strategy = strategy;
    }

    @Override
    public Map<String, Object> generateReport() {
        return strategy.generateReport();
    }
}
