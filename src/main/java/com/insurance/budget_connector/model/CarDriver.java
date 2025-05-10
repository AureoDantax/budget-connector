package com.insurance.budget_connector.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CarDriver {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "car_id")
    private Car car;

    @ManyToOne
    @JoinColumn(name = "driver_id")
    private Driver driver;

    private Boolean isMainDriver;

    public CarDriver(Driver driver, Car car,Boolean isMainDriver) {
        this.driver = driver;
        this.car = car;
    }
}
