package com.expert_coder.HighAlert;

import java.util.List;
import java.util.Map;

public class HighAlerts {
    String vin;
    String priority = "HIGH";
    List<Map<String, Object>> alerts;

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public List<Map<String, Object>> getAlerts() {
        return alerts;
    }

    public void setAlerts(List<Map<String, Object>> alerts) {
        this.alerts = alerts;
    }

    public HighAlerts() {

    }

    public HighAlerts(String vin, List<Map<String, Object>> alerts) {

        this.vin = vin;
        this.alerts = alerts;
    }
}
