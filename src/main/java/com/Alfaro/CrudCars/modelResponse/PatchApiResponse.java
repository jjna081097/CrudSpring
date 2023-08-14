package com.Alfaro.CrudCars.modelResponse;

public class PatchApiResponse {
    private String message;
    private Boolean Status;
    private String carBrand;

    public PatchApiResponse() {
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

    public String getCarBrand() {
        return this.carBrand;
    }

    public void setCarBrand(String carBrand) {
        this.carBrand = carBrand;
    }
}

