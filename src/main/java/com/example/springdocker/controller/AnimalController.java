package com.example.springdocker.controller;

import com.example.springdocker.model.Food;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Patrik Melander
 * Date: 2021-05-11
 * Time: 11:17
 * Project: SoloProject
 * Copyright: MIT
 */
@RequiredArgsConstructor
@RestController
public class AnimalController {
    private final AnimalService animalService;

    @GetMapping("/animals")
    public List<Animal> getAnimals() {
        return animalService.getAnimals();
    }

    @GetMapping("/animals/petable")
    public List<String> getPetableoods() {
        return animalService.getPetableAnimals();
    }
}
