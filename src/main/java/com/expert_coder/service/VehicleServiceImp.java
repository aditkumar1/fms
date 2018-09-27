package com.expert_coder.service;

import com.expert_coder.Exception.VehicleNotFoundException;
import com.expert_coder.HighAlert.HighAlerts;
import com.expert_coder.entity.Alert;
import com.expert_coder.entity.Vehicle;
import com.expert_coder.repository.AlertRepository;
import com.expert_coder.repository.ReadingRepository;
import com.expert_coder.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.*;

@Service
public class VehicleServiceImp implements VehicleService {

    @Autowired
    private VehicleRepository vehicleRepository;

    @Autowired
    private AlertRepository alertRepository;

    @Autowired
    private ReadingRepository readingRepository;

    @Transactional
    public List<Vehicle> create(Iterable<Vehicle> vehicles) {

        List<Vehicle> result = new ArrayList<>();

        if (vehicles == null) {
            return result;
        }
        for (Vehicle v : vehicles) {
            result.add(vehicleRepository.save(v));
        }

        return result;
    }

    public List<Vehicle> findAll() {
        return (List<Vehicle>) vehicleRepository.findAll();
    }

    @Override
    public List<Alert> findAllAlertByVehicle(String vin) {
        Optional<Vehicle> vehicleExist = vehicleRepository.findByVin(vin);
        if (!vehicleExist.isPresent()) {
            throw new VehicleNotFoundException("Vehicle with VIN:#" + vin + " not available.");
        }
        System.out.println("Service");
        return alertRepository.findByVehicle(vehicleExist.get());
    }

    @Override
    public List<Map<String, String>> findLocationOfAllVehicles(String vin) {
        Optional<Vehicle> vehicleExist = vehicleRepository.findByVin(vin);
        if (!vehicleExist.isPresent()) {
            throw new VehicleNotFoundException("Vehicle with VIN:#" + vin + " not available.");
        }
        LocalDateTime current = LocalDateTime.now();
        return readingRepository.findLocationByVehicle(current.minusMinutes(30), current, vehicleExist.get());
    }

    @Override
    public List<HighAlerts> findHighAlertForAllVehicle() {
        List<HighAlerts> result = new LinkedList<>();
        List<Vehicle> listOfVehicle = alertRepository.findDistinctVehicle();
        LocalDateTime current = LocalDateTime.now();
        for (Vehicle v : listOfVehicle) {
            HighAlerts data = new HighAlerts();
            data.setVin(v.getVin());
            data.setAlerts(alertRepository.findHighAlertForAllVehicle(current.minusHours(2), current, v));
            result.add(data);
        }
        return result;
    }
}
