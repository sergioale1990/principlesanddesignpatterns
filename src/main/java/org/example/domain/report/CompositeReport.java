package org.example.domain.report;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Clase encargada de utilizar el patron composite para unir reportes
public class CompositeReport implements ReportComponent {
    private final List<ReportComponent> components = new ArrayList<>();

    public void addComponent(ReportComponent component) {
        components.add(component);
    }

    @Override
    public Map<String, Object> generateReport() {
        Map<String, Object> combined = new HashMap<>();
        for (ReportComponent component : components) {
            Map<String, Object> partial = component.generateReport();
            combined.putAll(partial);
        }
        return combined;
    }
}
