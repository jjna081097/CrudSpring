package com.Alfaro.CrudCars.service;

import com.Alfaro.CrudCars.entity.Car;
import com.Alfaro.CrudCars.repository.CarRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarService {
    @Autowired
    private CarRepository carRepository;

    public CarService() {
    }

    public Car getCar(Long id) {
        return (Car)this.carRepository.findById(id).get();
    }

    public void addCar(Car car) {
        this.carRepository.save(car);
    }

    public Optional<Car> getCarByid(Long id) {
        return this.carRepository.findById(id);
    }

    public Optional<Car> findCarByPlateNumber(String plateNumber) {
        return this.carRepository.findCarByPlateNumber(plateNumber);
    }

    public Optional<Car> deleteCarbyId(Long id) {
        Optional<Car> carOptional = this.carRepository.findById(id);
        if (carOptional.isPresent()) {
            Car car = (Car)carOptional.get();
            this.carRepository.delete(car);
        }

        return carOptional;
    }

    public List<Car> getAllCars() {
        return this.carRepository.findAll();
    }

    @Transactional
    public void UpdateCar(Long id, Car car) {
        Car carfromdb = (Car)this.carRepository.findById(id).orElseThrow(() -> {
            return new IllegalStateException("Car Id " + id + " not exist");
        });
        carfromdb.setCardesc(car.getCardesc());
        carfromdb.setPlateNumber(car.getPlateNumber());
        carfromdb.setCarBrand(car.getCarBrand());
        carfromdb.setCarModel(car.getCarModel());
        carfromdb.setChassisNumber(car.getChassisNumber());
        carfromdb.setEngineNumber(car.getEngineNumber());
        carfromdb.setPrice(car.getPrice());
        this.carRepository.save(carfromdb);
    }

    public void updateCarBrand(Long id, Car car) {
        Car carfromdb = (Car)this.carRepository.findById(id).orElseThrow(() -> {
            return new IllegalStateException("Car id " + id + "Not Exist");
        });
        carfromdb.setCarBrand(car.getCarBrand());
        this.carRepository.save(carfromdb);
    }
}
