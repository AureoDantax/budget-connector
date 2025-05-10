package com.insurance.budget_connector.service;

import com.insurance.budget_connector.dto.CustomerRequestDTO;
import com.insurance.budget_connector.model.Car;
import com.insurance.budget_connector.model.CarDriver;
import com.insurance.budget_connector.model.Customer;
import com.insurance.budget_connector.model.Driver;
import com.insurance.budget_connector.repository.CarDriverRepository;
import com.insurance.budget_connector.repository.CarRepository;
import com.insurance.budget_connector.repository.CustomerRepository;
import com.insurance.budget_connector.repository.DriverRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository repository;
    @Autowired
    private DriverRepository driverRepository;
    @Autowired
    private CarRepository carRepository;
    @Autowired
    private CarDriverRepository carDriverRepository;

    @Transactional
    @Modifying
    public Customer createCustomer(CustomerRequestDTO customerDto) {
        // find existing driver by document number
        if (driverRepository.existsByDocument(customerDto.driver().getDocument()))
            throw new RuntimeException("Driver already exists");

        // create new driver
        Driver driver = Driver.builder()
                .document(customerDto.driver().getDocument())
                .birthDate(customerDto.driver().getBirthDate())
                .build();
        driver = driverRepository.save(driver);

        // CREATE CAR
        var requestCar = customerDto.car();
        Car car = Car.builder().
                model(requestCar.getModel())
                .fipeValue(requestCar.getFipeValue())
                .manufacturer(requestCar.getManufacturer())
                .year(requestCar.getYear())
                .licensePlate(requestCar.getLicensePlate())
                .build();
        carRepository.save(car);
        carDriverRepository.save(new CarDriver(driver, car,customerDto.isMainDriver()));

        Customer customer = Customer.builder()
                .name(customerDto.name())
                .driver(driver)
                .build();
        return repository.save(customer);


    }

    public Customer getCustomer(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Customer not found"));
    }
}