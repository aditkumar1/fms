package com.expert_coder.repository;

import com.expert_coder.entity.Vehicle;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VehicleRepository extends CrudRepository<Vehicle, String> {
    Optional<Vehicle> findByVin(String vin);
}
