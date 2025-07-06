package org.example.domain.report;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;


//Clase implementada usando el patron decorador para añadir fecha de generacion en los reportes
public class TimestampReportDecorator extends ReportDecorator{
    public TimestampReportDecorator(ReportComponent reportComponent) {
        super(reportComponent);
    }

    @Override
    public Map<String, Object> generateReport() {
        Map<String, Object> report = new HashMap<>(reportComponent.generateReport());
        report.put("Fecha_de_Generacion", LocalDateTime.now());
        return report;
    }
}
