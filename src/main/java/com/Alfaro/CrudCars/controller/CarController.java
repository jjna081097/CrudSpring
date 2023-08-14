package com.Alfaro.CrudCars.controller;

import com.Alfaro.CrudCars.entity.Car;
import com.Alfaro.CrudCars.modelResponse.*;
import com.Alfaro.CrudCars.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping({"/api/cars"})
public class CarController {
    @Autowired
    private CarService carService;

    public CarController() {
    }

    @GetMapping
    public ResponseEntity<Object> getAllCars() {
        GetAllCarsApiResponse gacar = new GetAllCarsApiResponse();
        this.carService.getAllCars();
        gacar.setMessage("Get all Cars");
        gacar.setStatus(true);
        gacar.setCars(this.carService.getAllCars());
        return ResponseEntity.status(HttpStatus.FOUND).body(gacar);
    }

    @PostMapping
    public ResponseEntity<Object> addCar(@RequestBody Car car) {
        GetAddCarApiResponse addApiResponse = new GetAddCarApiResponse();
        Optional<Car> carOptional = this.carService.findCarByPlateNumber(car.getPlateNumber());
        if (carOptional.isPresent()) {
            addApiResponse.setMessage(car.getPlateNumber() + " Plate Number exist");
            addApiResponse.setStatus(false);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(addApiResponse);
        } else {
            this.carService.addCar(car);
            addApiResponse.setMessage("Car added");
            addApiResponse.setStatus(true);
            addApiResponse.setCar(car);
            return ResponseEntity.status(HttpStatus.OK).body(addApiResponse);
        }
    }

    @GetMapping({"/{id}"})
    public ResponseEntity<Object> getCar(@PathVariable Long id) {
        Optional<Car> carGetOptional = this.carService.getCarByid(id);
        GetCarApi gca = new GetCarApi();
        if (carGetOptional.isEmpty()) {
            gca.setMessage("Car with ID " + id + " not found");
            gca.setStatus(false);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(gca);
        } else {
            Car car = (Car)carGetOptional.get();
            gca.setMessage("Car found");
            gca.setStatus(true);
            gca.setCar(car);
            return ResponseEntity.ok(gca);
        }
    }

    @DeleteMapping
    public ResponseEntity<Object> deleteCar(@RequestParam Long id) {
        Optional<Car> deleteCarOptional = this.carService.deleteCarbyId(id);
        DeleteCarApi dca = new DeleteCarApi();
        if (deleteCarOptional.isEmpty()) {
            dca.setMessage("Car with ID " + id + " not found");
            dca.setStatus(false);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(dca);
        } else {
            dca.setMessage("Car with " + id + " found and deleted");
            dca.setCar((Car)deleteCarOptional.get());
            dca.setStatus(true);
            return ResponseEntity.ok(dca);
        }
    }

    @PutMapping
    public ResponseEntity<Object> updateCar(@RequestBody Car car, @RequestParam Long id) {
        UpdateAPiResponse upar = new UpdateAPiResponse();
        Optional<Car> carOptional = this.carService.findCarByPlateNumber(car.getPlateNumber());
        if (carOptional.isPresent()) {
            upar.setMessage(car.getPlateNumber() + " Plate Number exist");
            upar.setStatus(false);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(upar);
        } else {
            this.carService.UpdateCar(id, car);
            upar.setMessage("Car Updated");
            upar.setStatus(true);
            upar.setCar(car);
            return ResponseEntity.ok(upar);
        }
    }

    @PatchMapping
    public ResponseEntity<Object> updateCarBrand(@RequestParam Long id, @RequestBody Car car) {
        PatchApiResponse apr = new PatchApiResponse();
        this.carService.updateCarBrand(id, car);
        apr.setMessage(car.getCarBrand() + car.getCarModel() + " successfully updated.");
        apr.setStatus(true);
        apr.setCarBrand(car.getCarBrand());
        return ResponseEntity.status(HttpStatus.OK).body(apr);
    }
}
