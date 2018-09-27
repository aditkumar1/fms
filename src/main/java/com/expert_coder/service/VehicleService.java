package com.expert_coder.service;


import com.expert_coder.HighAlert.HighAlerts;
import com.expert_coder.entity.Alert;
import com.expert_coder.entity.Vehicle;

import java.util.List;
import java.util.Map;

public interface VehicleService {
    List<Vehicle> create(Iterable<Vehicle> vehicle);

    List<Vehicle> findAll();

    List<Alert> findAllAlertByVehicle(String vin);

    public List<Map<String, String>> findLocationOfAllVehicles(String vin);

    public List<HighAlerts> findHighAlertForAllVehicle();
}
