package com.Alfaro.CrudCars.modelResponse;

import com.Alfaro.CrudCars.entity.Car;
import java.util.List;

public class GetAllCarsApiResponse {
    private String message;
    private Boolean Status;
    private List<Car> cars;

    public GetAllCarsApiResponse() {
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

    public List<Car> getCars() {
        return this.cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }
}
