package com.example.springdocker.service;

import com.example.springdocker.model.Animal;
import com.example.springdocker.model.Car;
import com.example.springdocker.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class CarService {
    private final CarRepository carRepository;

    public List<Car> getCars() {
        return carRepository.findAll();
    }

    public void saveNewCar(Car car) {
        carRepository.save(car);
    }

    public List<String> getDriveableCars() {
        // hämtar alla Foods som vi kan laga
        List<Car> driveableCars = carRepository.findCarByCanIDriveIt(true);

        // returnerar endast Animals namnen i en lista
        return driveableCars.stream()
                .map(car -> car.getModel())
                .collect(Collectors.toList());
    }
}
