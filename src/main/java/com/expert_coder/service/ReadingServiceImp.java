package com.expert_coder.service;


import com.expert_coder.Exception.VehicleNotFoundException;
import com.expert_coder.entity.Reading;
import com.expert_coder.entity.Vehicle;
import com.expert_coder.repository.ReadingRepository;
import com.expert_coder.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class ReadingServiceImp implements ReadingService {

    @Autowired
    private ReadingRepository rRepository;

    @Autowired
    private VehicleRepository vRepository;
    
    @Transactional
    public void create(Reading reading) {
        Optional<Vehicle> vehicleExist = vRepository.findByVin(reading.getVehicle().getVin());
        if (!vehicleExist.isPresent()) {
            throw new VehicleNotFoundException("Vehicle with VIN:#" + reading.getVehicle().getVin() + " not available.");
        }
        reading.setVehicle(vehicleExist.get());
        rRepository.save(reading);
    }
}
