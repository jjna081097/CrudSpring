package com.Alfaro.CrudCars.repository;

import com.Alfaro.CrudCars.entity.Car;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
    Optional<Car> findCarByPlateNumber(String plateNumber);

    Optional<Car> getCarById(Long id);

    Optional<Car> deleteCarByid(Long id);
}
