package com.expert_coder.repository;


import com.expert_coder.entity.Reading;
import com.expert_coder.entity.Vehicle;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Repository
public interface ReadingRepository extends CrudRepository<Reading, String> {

    @Query("SELECT timestamp as time,longitude as longitude, latitude as latitude from Reading r where r.timestamp between :from  and :to and r.vehicle = :vehicle")
    List<Map<String, String>> findLocationByVehicle(@Param("from") @CreationTimestamp LocalDateTime from, @Param("to") @CreationTimestamp LocalDateTime to, @Param("vehicle") Vehicle vehicle);

}
