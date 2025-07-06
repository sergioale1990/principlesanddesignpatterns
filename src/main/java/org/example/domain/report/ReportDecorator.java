package org.example.domain.report;


//Clase abstracta necesaria para utilizar el patron decorador.
public abstract class ReportDecorator implements ReportComponent {
    protected ReportComponent reportComponent;

    public ReportDecorator(ReportComponent reportComponent) {
        this.reportComponent = reportComponent;
    }
}
