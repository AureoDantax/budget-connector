package com.insurance.budget_connector.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "cars")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @NotBlank(message = "model is mandatory")
    private String model;
    @NotBlank(message = "manufacturer is mandatory")
    private String manufacturer;
    @NotBlank(message = "license plate is mandatory")
    private String licensePlate;
    @NotBlank(message = "year is mandatory")
    private String year;
    @NotBlank(message = "FIPE value is mandatory")
    private BigDecimal fipeValue;

}
