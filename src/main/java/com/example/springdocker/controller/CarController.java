package com.example.springdocker.controller;

import com.example.springdocker.model.Animal;
import com.example.springdocker.model.Car;
import com.example.springdocker.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class CarController {
    private final CarService carService;

    @GetMapping("/cars")
    public List<Car> getCars() {
        return carService.getCars();
    }

    @PostMapping("/cars")
    public void saveNewAnimal(@RequestBody Car car) {
        carService.saveNewCar(car);
    }

    @GetMapping("/cars/driveable")
    public List<String> getDriveableCars() { return carService.getDriveableCars();}
}
