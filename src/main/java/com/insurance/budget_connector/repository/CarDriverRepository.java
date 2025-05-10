package com.insurance.budget_connector.repository;

import com.insurance.budget_connector.model.CarDriver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarDriverRepository extends JpaRepository<CarDriver, Long>{
    Boolean existsByCarIdAndDriverId(Long carId, Long driverId);
}
