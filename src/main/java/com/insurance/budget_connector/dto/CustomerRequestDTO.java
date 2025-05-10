package com.insurance.budget_connector.dto;

import com.insurance.budget_connector.model.Car;
import com.insurance.budget_connector.model.Driver;

public record CustomerRequestDTO(String name, Driver driver, Car car,Boolean isMainDriver) {



}
