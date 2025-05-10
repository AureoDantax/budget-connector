CREATE TABLE car_driver
(
    id             BIGINT NOT NULL,
    car_id         BIGINT,
    driver_id      BIGINT,
    is_main_driver BOOLEAN,
    CONSTRAINT pk_cardriver PRIMARY KEY (id)
);

ALTER TABLE car_driver
    ADD CONSTRAINT FK_CARDRIVER_ON_CAR FOREIGN KEY (car_id) REFERENCES cars (id);

ALTER TABLE car_driver
    ADD CONSTRAINT FK_CARDRIVER_ON_DRIVER FOREIGN KEY (driver_id) REFERENCES drivers (id);

ALTER TABLE cars
    ALTER COLUMN fipe_value TYPE DECIMAL USING (fipe_value::DECIMAL);