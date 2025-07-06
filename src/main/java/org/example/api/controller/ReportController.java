package org.example.api.controller;

import org.example.domain.report.BasicReport;
import org.example.domain.report.CompositeReport;
import org.example.domain.report.ReportComponent;
import org.example.domain.report.TimestampReportDecorator;
import org.example.domain.service.ReportService;
import org.example.domain.strategy.ReportStrategy;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;


//Controlador REST para la generacion de reportes
@RestController
@RequestMapping( "/api/reports")
public class ReportController {

    private final ReportService reportService;

    //Constructor de la clase
    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }

    //Endpoint encargado de obtener los datos de ventas para la generacion de reportes
    @GetMapping("/sales")
    public ResponseEntity<Map<String, Object>> getReport(@RequestParam String type, @RequestParam(required = false) boolean withTimestamp) {
        Map<String, Object> report = reportService.generateReport(type);

        if (withTimestamp) {
            Map<String, Object> finalReport = report;
            ReportComponent reportBase = () -> finalReport;
            ReportComponent reportDecorated = new TimestampReportDecorator(reportBase);
            report = reportDecorated.generateReport();
        }
        return ResponseEntity.ok(report);
    }

    //Endpoint utilizado para combinar reportes usando el patron composite
    @GetMapping("/combined")
    public ResponseEntity<Map<String, Object>> getCombinedReport(@RequestParam List<String> types) {
        Map<String, Object> report = reportService.generateCombinedReport(types);
        return ResponseEntity.ok(report);
    }
}
