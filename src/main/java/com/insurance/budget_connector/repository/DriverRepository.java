package com.insurance.budget_connector.repository;

import com.insurance.budget_connector.model.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DriverRepository extends JpaRepository<Driver, Integer> {
 Boolean existsByDocument (String document);
}
