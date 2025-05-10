package com.insurance.budget_connector.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "cars")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
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
    @NotNull(message = "FIPE value is mandatory")
    private BigDecimal fipeValue;

}
