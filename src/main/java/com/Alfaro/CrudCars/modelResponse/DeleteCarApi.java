package com.Alfaro.CrudCars.modelResponse;

import com.Alfaro.CrudCars.entity.Car;

public class DeleteCarApi {
    private String message;
    private Boolean Status;
    private Car car;

    public DeleteCarApi() {
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Boolean getStatus() {
        return this.Status;
    }

    public void setStatus(Boolean status) {
        this.Status = status;
    }

    public Car getCar() {
        return this.car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}
