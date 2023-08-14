package com.Alfaro.CrudCars.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(
        name = "cars"
)
public class Car {
    @Id
    @SequenceGenerator(
            name = "car_sequence",
            sequenceName = "car_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "car_sequence"
    )
    private Long id;
    private String carBrand;
    private String carModel;
    private String plateNumber;
    private String engineNumber;
    private String chassisNumber;
    private String cardesc;
    private double price;

    public Car() {
    }

    public Car(String carBrand, String carModel, String plateNumber, String engineNumber, String chassisNumber, String cardesc, double price) {
        this.carBrand = carBrand;
        this.carModel = carModel;
        this.plateNumber = plateNumber;
        this.engineNumber = engineNumber;
        this.chassisNumber = chassisNumber;
        this.cardesc = cardesc;
        this.price = price;
    }

    public Long getId() {
        return this.id;
    }

    public String getCarBrand() {
        return this.carBrand;
    }

    public void setCarBrand(String carBrand) {
        this.carBrand = carBrand;
    }

    public String getCarModel() {
        return this.carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public String getPlateNumber() {
        return this.plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public String getEngineNumber() {
        return this.engineNumber;
    }

    public void setEngineNumber(String engineNumber) {
        this.engineNumber = engineNumber;
    }

    public String getChassisNumber() {
        return this.chassisNumber;
    }

    public void setChassisNumber(String chassisNumber) {
        this.chassisNumber = chassisNumber;
    }

    public String getCardesc() {
        return this.cardesc;
    }

    public void setCardesc(String cardesc) {
        this.cardesc = cardesc;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}

