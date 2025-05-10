CREATE SEQUENCE IF NOT EXISTS cars_seq START WITH 1 INCREMENT BY 50;

CREATE SEQUENCE IF NOT EXISTS claims_seq START WITH 1 INCREMENT BY 50;

CREATE SEQUENCE IF NOT EXISTS customers_seq START WITH 1 INCREMENT BY 50;

CREATE SEQUENCE IF NOT EXISTS drivers_seq START WITH 1 INCREMENT BY 50;

CREATE SEQUENCE IF NOT EXISTS insurances_seq START WITH 1 INCREMENT BY 50;

CREATE TABLE cars
(
    id            BIGINT NOT NULL,
    model         VARCHAR(255),
    manufacturer  VARCHAR(255),
    license_plate VARCHAR(255),
    year          VARCHAR(255),
    fipe_value    DECIMAL,
    CONSTRAINT pk_cars PRIMARY KEY (id)
);

CREATE TABLE claims
(
    id         BIGINT NOT NULL,
    car_id     BIGINT,
    driver_id  BIGINT,
    event_date TIMESTAMP WITHOUT TIME ZONE NOT NULL,
    CONSTRAINT pk_claims PRIMARY KEY (id)
);

CREATE TABLE customers
(
    id        BIGINT NOT NULL,
    name      VARCHAR(255),
    driver_id BIGINT,
    CONSTRAINT pk_customers PRIMARY KEY (id)
);

CREATE TABLE drivers
(
    id         BIGINT NOT NULL,
    document   VARCHAR(255),
    birth_date date   NOT NULL,
    CONSTRAINT pk_drivers PRIMARY KEY (id)
);

CREATE TABLE insurances
(
    id          BIGINT NOT NULL,
    customer_id BIGINT,
    car_id      BIGINT,
    is_active   BOOLEAN,
    created_at  TIMESTAMP WITHOUT TIME ZONE,
    updated_at  TIMESTAMP WITHOUT TIME ZONE,
    CONSTRAINT pk_insurances PRIMARY KEY (id)
);

ALTER TABLE claims
    ADD CONSTRAINT FK_CLAIMS_ON_CAR FOREIGN KEY (car_id) REFERENCES cars (id);

ALTER TABLE claims
    ADD CONSTRAINT FK_CLAIMS_ON_DRIVER FOREIGN KEY (driver_id) REFERENCES drivers (id);

ALTER TABLE customers
    ADD CONSTRAINT FK_CUSTOMERS_ON_DRIVER FOREIGN KEY (driver_id) REFERENCES drivers (id);

ALTER TABLE insurances
    ADD CONSTRAINT FK_INSURANCES_ON_CAR FOREIGN KEY (car_id) REFERENCES cars (id);

ALTER TABLE insurances
    ADD CONSTRAINT FK_INSURANCES_ON_CUSTOMER FOREIGN KEY (customer_id) REFERENCES customers (id);